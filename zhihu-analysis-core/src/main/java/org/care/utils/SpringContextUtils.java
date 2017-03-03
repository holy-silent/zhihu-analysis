package org.care.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by van persie on 2017/3/2.
 */
public class SpringContextUtils {
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name) {
        return (T)applicationContext.getBean(name);
    }
}
