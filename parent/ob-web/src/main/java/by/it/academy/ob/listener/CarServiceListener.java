package by.it.academy.ob.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CarServiceListener implements ServletContextListener {
    private static final Logger loger = LoggerFactory.getLogger(CarServiceListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loger.info("Context initialized");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        loger.info("Context destroyed");
    }
}
