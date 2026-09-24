package com.booking_system.util;

import com.booking_system.audit.AuditTableEventListener;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class HibernateAndConnectionPoolUtil {

    private static final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(HibernateAndConnectionPoolUtil.class);

    static {
        Properties properties = new Properties();
        try (InputStream stream = HibernateAndConnectionPoolUtil.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (stream == null) {
                logger.error("Файл с настройками не был загружен в память приложения.");
                throw new RuntimeException("Файл application.properties не был загружен в память.");
            }
            properties.load(stream);
        } catch (IOException e) {
            logger.error("Работа приложения невозможна - нет связи с базой данных. Ошибка: {} Причина: {}",
                    e.getMessage(), e.getCause(), e);
            throw new ExceptionInInitializerError(new RuntimeException("Фатальная ошибка - система " +
                    "не смогла загрузить данные для работы с базой данных."));
        }

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setPassword(properties.getProperty("db.pass"));
        config.setUsername(properties.getProperty("db.user"));
        config.setDriverClassName(properties.getProperty("db.driver", "org.postgresql.Driver"));
        config.setPoolName("FlightBookingSystem");

        config.setMaximumPoolSize(15);
        config.setMinimumIdle(3);
        config.setMaxLifetime(300000);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(3000);
        config.setValidationTimeout(5000);
        config.setKeepaliveTime(30000);

        HikariDataSource source = new HikariDataSource(config);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .applySetting("hibernate.connection.datasource", source)
                .build();

        Metadata metadata = new MetadataSources(registry).buildMetadata();
        sessionFactory = metadata.buildSessionFactory();

        SessionFactoryImplementor sessionFactoryImplementor = sessionFactory.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry listenerRegistry = sessionFactoryImplementor.getServiceRegistry()
                .getService(EventListenerRegistry.class);

        AuditTableEventListener listener = new AuditTableEventListener();
        listenerRegistry.appendListeners(EventType.PRE_INSERT, listener);
        listenerRegistry.appendListeners(EventType.PRE_UPDATE, listener);
        listenerRegistry.appendListeners(EventType.PRE_DELETE, listener);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Приложение завершило свой жизненный цикл. Закрываем фабрику и соединения...");
            sessionFactory.close();
        }));
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
