package org.example.novel.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author：hb
 * @Package：org.example.novel.common.config
 * @Project：my
 * @Date：22/11/2024 9:11 am
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextRegister.class);
    private static ApplicationContext APPLICATION_CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("ApplicationContext registed-->{}", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }
    /**
     * 获取容器
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }
    /**
     * 获取容器对象
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> type) {
        return APPLICATION_CONTEXT.getBean(type);
    }
}
