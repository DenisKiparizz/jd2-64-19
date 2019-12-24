package by.it.academy.ob.db.migration;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public final class DbMigration {
    private static final Logger loger = LoggerFactory.getLogger(DbMigration.class);

    private DbMigration() {
    }

    public static void migrate(DataSource dataSource) {
        loger.info("====Start DATABASE migration====");
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
        loger.info("=====Finish DATABASE migration=====");

    }
}
