package by.it.academy.ob.dao.impl;

import by.it.academy.ob.db.connection.pool.ServiceCarDataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO {
    protected final Logger logger;

    protected AbstractDAO(Logger logger) {
        this.logger = logger;
    }

    protected Connection getConnection() throws SQLException {
        return ServiceCarDataSource.geConnection();
    }

    protected void closeQuietly(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }
}
