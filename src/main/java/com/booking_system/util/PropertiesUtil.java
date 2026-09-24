package com.booking_system.util;

import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class PropertiesUtil {

    private static final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    static {
        try(InputStream stream = PropertiesUtil.class.
                getClassLoader().
                getResourceAsStream("application.properties")) {
            if (stream == null) {
                throw new IllegalStateException("Properties файл не был загружен в приложение или найден в classpath");
            }
            properties.load(stream);
        } catch (IOException e) {
            logger.error("Ошибка во время чтения файла с настройками. Ошибка: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
