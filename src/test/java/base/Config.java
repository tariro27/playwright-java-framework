package base;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("playwright.properties")) {
            if (in == null) throw new RuntimeException("playwright.properties not found");
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load playwright.properties", e);
        }
    }

    public static String get(String key) {
        // Allows overrides like: mvn test -DbaseUrl=...
        return System.getProperty(key, props.getProperty(key));
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(get(key));
    }
}