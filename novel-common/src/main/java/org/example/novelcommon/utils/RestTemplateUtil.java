package org.example.novelcommon.utils;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.http.HttpHost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.example.novelcommon.config.HttpProxyProperties;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.utils
 * @Project：my
 * @Date：21/11/2024 1:48 pm
 */
@Component
@Data
public class RestTemplateUtil {
    private static HttpProxyProperties httpProxyProperties;

    @SneakyThrows
    public static RestTemplate getInstance(String charset) {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

        //忽略证书
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", csf)
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry); //连接池的最大连接数，0代表不限；如果取0，需要考虑连接泄露导致系统崩溃的后果
        connectionManager.setMaxTotal(1000);
        //每个路由的最大连接数,如果只调用一个地址,可以将其设置为最大连接数
        connectionManager.setDefaultMaxPerRoute(300);

        HttpClientBuilder clientBuilder = HttpClients.custom();
        if (Objects.nonNull(httpProxyProperties) && Boolean.TRUE.equals(httpProxyProperties.getEnabled())) {
            HttpHost proxy = new HttpHost(httpProxyProperties.getIp(), httpProxyProperties.getPort());
            clientBuilder.setProxy(proxy);
        }
        CloseableHttpClient httpClient = clientBuilder.setConnectionManager(connectionManager)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);
        requestFactory.setConnectionRequestTimeout(3000);
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(30000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> list = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> httpMessageConverter : list) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName(charset));
                break;
            }
        }
        return restTemplate;

    }
}
