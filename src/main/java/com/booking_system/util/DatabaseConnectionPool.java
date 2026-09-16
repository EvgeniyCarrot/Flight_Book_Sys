package com.booking_system.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class DatabaseConnectionPool {

    private static final SessionFactory sessionFactory;

    static {
        Properties properties = new Properties();
        try(InputStream stream = DatabaseConnectionPool.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (stream == null) {
                throw new RuntimeException("Файл application.properties не был загружен в память.");
            }
            properties.load(stream);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(new RuntimeException("Фатальная ошибка - система " +
                    "не смогла загрузить данные для работы с базой данных."));
        }
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setPassword(properties.getProperty("db.pass"));
        config.setUsername(properties.getProperty("db.user"));
        config.setDriverClassName(properties.getProperty("db.driver"));
        config.setPoolName("FlightBookingSystem");

        config.setMaximumPoolSize(15);
        config.setMinimumIdle(15);
        config.setMaxLifetime(300000);
        config.setConnectionTimeout(3000);
        config.setValidationTimeout(5000);
        config.setKeepaliveTime(30000);

        HikariDataSource source = new HikariDataSource(config);

        sessionFactory = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .configure()
                        .applySetting("hibernate.connection.datasource", source)
                        .build()
        ).buildMetadata().buildSessionFactory();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Приложение завершило свой жизненный цикл. Закрываем фабрику и соединения");
            sessionFactory.close();
        }));
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
