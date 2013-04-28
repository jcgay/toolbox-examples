package com.github.jcgay.example.log.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.trace("a trace message.");
        LOGGER.debug("a debug message.");
        LOGGER.info("an info message.");
        LOGGER.warn("a warn message.");
        LOGGER.error("a error message.");
        LOGGER.fatal("a fatal message.");
    }
}
