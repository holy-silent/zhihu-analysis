package org.care.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by van persie on 2017/3/2.
 */
public class PropertiesUtils {
    private static Properties p = new Properties();

    static {
        try {
            p.load(PropertiesUtils.class.getResourceAsStream("app.properties"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return p.getProperty(key);
    }
}
