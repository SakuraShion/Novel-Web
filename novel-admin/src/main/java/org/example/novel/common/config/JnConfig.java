package org.example.novel.common.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author：hb
 * @Package：org.example.novel.common.config
 * @Project：my
 * @Date：22/11/2024 9:23 am
 */
@Data
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix="java2nb")
public class JnConfig {
    private String uploadPath;

    private String username;

    private String password;
}
