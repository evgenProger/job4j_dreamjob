package ru.job4j.dream.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Path {
    private static final Properties PROPERTIES = new Properties();

    public static   String pathToImages(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        try {
            PROPERTIES.load(Path.class.getClassLoader().getResourceAsStream("path.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
