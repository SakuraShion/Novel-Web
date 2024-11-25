package org.example.novelcommon.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.utils
 * @Project：my
 * @Date：21/11/2024 3:30 pm
 */
public class HttpUtils {
    private static RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");
    public static String getByHttpClient(String url) {
        try {

            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            if (forEntity.getStatusCode() == HttpStatus.OK) {
                return forEntity.getBody();
            } else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
