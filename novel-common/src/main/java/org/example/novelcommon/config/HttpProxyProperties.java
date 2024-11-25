package org.example.novelcommon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.config
 * @Project：my
 * @Date：21/11/2024 1:48 pm
 */
@Data
@Component
@ConfigurationProperties("http.proxy")
public class HttpProxyProperties {
    private Boolean enabled;

    private String ip;

    private Integer port;
}
