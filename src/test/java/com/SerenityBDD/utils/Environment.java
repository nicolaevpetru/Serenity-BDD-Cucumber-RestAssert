package com.SerenityBDD.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class Environment {

    private final static Logger log = Logger.getLogger(Environment.class);
    private static Properties properties;

    // GET THE ENVIRONMENT
    public static String getEnvironment() {
        String environment = System.getProperty("env");
        if (environment == null) {
            environment = ConfigReader.getProperty("environment");
            log.info("#### : [ " + environment + " ] ENVIRONMENT WAS SPECIFIED FROM THE PROPERTIES FILE.");
        } else
            log.info("#### : [ " + environment + " ] ENVIRONMENT WAS SPECIFIED FROM SYSTEM VARIABLE.");
        return environment.toUpperCase();
    }

    static {
        try {
            String path = "config.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            // LOAD ENVIRONMENT SPECIFIC PROPERTIES
            path = "src/test/resources/env/" + getEnvironment() + ".properties";
            input = new FileInputStream(path);
            properties.load(input);
            input.close();
            log.info("#### : PROPERTIES FILE FOR [ " + getEnvironment() + " ] ENVIRONMENT WAS SUCCESSFULLY LOADED.");
        } catch (Exception exception) {
            exception.printStackTrace();
            log.info("##### : FAILED TO LOAD PROPERTIES FILE FOR [ " + getEnvironment() + " ] ENVIRONMENT.");
        }

    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}