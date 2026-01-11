package base;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("playwright.properties")) {
            if (in == null) throw new RuntimeException("playwright.properties not found in src/test/resources");
            props.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load playwright.properties", e);
        }
    }

    private Config() {}

    public static String get(String key) {
        // allow cli overrides: mvn test -DbaseUrl=...
        String override = System.getProperty(key);
        return (override != null && !override.isBlank()) ? override : props.getProperty(key);
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(get(key));
    }
}