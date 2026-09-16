package com.booking_system.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesUtil {

    private static final Properties properties = new Properties();

    static {
        try(InputStream stream = PropertiesUtil.class.
                getClassLoader().
                getResourceAsStream("application.properties")) {
            if (stream == null) {
                throw new IllegalStateException("Properties файл не был загружен в приложение или найден в classpath");
            }
            properties.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
