package util;

import exceptions.AutomationException;
import org.apache.commons.exec.environment.EnvironmentUtils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

class TypeLoader {

    private static Properties properties;
    private static final String FILE_PATH = "conf/environment.properties";
    private static final List<String> PROFILE_LIST = Arrays.asList("CI");

    static {
        try {

            properties = new Properties();
            InputStream fileInput = EnvironmentUtils.class.getClassLoader().getResourceAsStream(FILE_PATH);

            if (fileInput != null) {
                properties.load(fileInput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getType() {
         return isProfileActive(PROFILE_LIST) ? getProfileName() : properties.getProperty("type");
    }

    private static boolean isProfileActive(List<String> evaluatedTypes) {
        return evaluatedTypes.stream().anyMatch(t -> t.equalsIgnoreCase(getProfileName()));
    }

    private static String getProfileName() {
        return System.getProperty("environment");
    }

}
