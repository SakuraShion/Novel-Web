package org.example.novel.common.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：hb
 * @Package：org.example.novel.common.config
 * @Project：my
 * @Date：22/11/2024 9:26 am
 */
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@Configuration
public class SecuityConfig {
}
