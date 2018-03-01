package com.blog.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * @author moutian
 */
public class InitListener implements ServletContextListener {

    private static Logger logger = LogManager.getLogger(InitListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    /**
     * 初始化信息。包括初始化以下内容:
     * 1.
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
        logger.info("----------初始化监听器----------");


    }

}
