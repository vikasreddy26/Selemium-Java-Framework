package lib.util;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
    public static Properties prop;

    public Configuration() {
        prop = new Properties();
    }

    public static void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Coniguration.properties");
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        loadProperties();
        return prop.getProperty(key);
    }

}
