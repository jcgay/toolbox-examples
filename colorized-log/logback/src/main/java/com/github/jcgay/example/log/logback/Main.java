package com.github.jcgay.example.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.trace("a trace message.");
        LOGGER.debug("a debug message.");
        LOGGER.info("an info message.");
        LOGGER.warn("a warn message.");
        LOGGER.error("a error message.");
    }
}
