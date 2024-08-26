package sconto.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static final String PROP_FILE = "/selenide.properties";

    public static String loadProperty(String name){
        Properties props = new Properties();
        try {
            props.load(PropertiesLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props.getProperty(name, "");
    }
}
