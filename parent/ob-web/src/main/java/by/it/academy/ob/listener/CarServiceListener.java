package by.it.academy.ob.listener;

import by.it.academy.ob.db.connection.pool.ServiceCarDataSource;
import by.it.academy.ob.db.migration.DbMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebListener()
public class CarServiceListener implements ServletContextListener {
    private static final Logger loger = LoggerFactory.getLogger(CarServiceListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loger.info("Context initialized");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
            ServiceCarDataSource.configure(bundle);
            DataSource dataSource = ServiceCarDataSource.getDataSource();
            DbMigration.migrate(dataSource);

        } catch (ClassNotFoundException | SQLException e) {
            loger.error("ERROR666", e);
            throw new RuntimeException("Datasource initialisation error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        loger.info("Context destroyed");
    }
}
