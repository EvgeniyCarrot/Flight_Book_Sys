package com.booking_system.util;

import lombok.experimental.UtilityClass;
import org.flywaydb.core.Flyway;

@UtilityClass
public final class MigrationUtil {
    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(
                        PropertiesUtil.get("db.url"),
                        PropertiesUtil.get("db.user"),
                        PropertiesUtil.get("db.pass")
                )
                .defaultSchema("booking_system")
                .locations("classpath:db/migration")
                .cleanDisabled(true)
                .load();
        //flyway.clean();
        flyway.migrate();
    }
}