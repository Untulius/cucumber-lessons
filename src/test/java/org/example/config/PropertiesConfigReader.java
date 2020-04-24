package org.example.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfigReader implements ConfigReader {
    private final Properties properties = new Properties();
    public PropertiesConfigReader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream = contextClassLoader.getResourceAsStream("config/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
