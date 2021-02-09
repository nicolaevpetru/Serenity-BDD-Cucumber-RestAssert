package com.SerenityBDD.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = new FileInputStream("config.properties")) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("##### FAILED TO LOAD PROPERTIES FILE");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}