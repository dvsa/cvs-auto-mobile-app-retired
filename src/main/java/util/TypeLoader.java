package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;

import java.util.Properties;

class TypeLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";

    static {
        try {

            properties = new Properties();
            properties.load(EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AutomationException("Could not load environment setup");
        }
    }

    public static String getType() {
        return properties.getProperty("type");
    }


}
