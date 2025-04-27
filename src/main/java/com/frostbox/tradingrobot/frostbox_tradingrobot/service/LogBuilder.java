package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBuilder {

    private static final Logger logger = LoggerFactory.getLogger(LogBuilder.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }
}
