package util;

import org.apache.commons.exec.environment.EnvironmentUtils;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TypeLoader {

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

    public static EnvironmentType getType() {
        return isProfileActive() ? EnvironmentType.get(getProfileName()) : EnvironmentType.get(properties.getProperty("type"));
    }

    public static String getAppUsername() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getProperty("MICROSOFT_USERNAME");
                break;
            default:
                userName = properties.getProperty("app.username");
                break;

        }
        return userName;
    }

    public static String getAppPassword() {
        EnvironmentType envType = getType();
        String password;
        switch (envType) {
            case CI_BROWSERSTACK:
                password = System.getProperty("MICROSOFT_PASS");
                break;
            default:
                password = properties.getProperty("app.password");
                break;

        }
        return password;
    }


    public static String getBsUsername() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getenv("BROWSERSTACK_USERNAME");
                break;
            default:
                userName = properties.getProperty("browserstack.username");
                break;

        }
        return userName;
    }


    public static String getBsPass() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getenv("BROWSERSTACK_ACCESS_KEY");
                break;
            default:
                userName = properties.getProperty("browserstack.password");
                break;

        }
        return userName;
    }

    public static String getMicrosoftonlineUrl() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getProperty("MICROSOFT_URL");
                break;
            default:
                userName = properties.getProperty("microsoftonline.url");
                break;

        }
        return userName;
    }


    public static String getBasePathUrl() {

        EnvironmentType envType = getType();
        String userName;
        switch (envType) {
            case CI_BROWSERSTACK:
                userName = System.getProperty("DEVELOP_BASE_PATH");
                break;
            default:
                userName = properties.getProperty("base.path.url");
                break;

        }
        return userName;
    }


    private static boolean isProfileActive() {
        return PROFILE_LIST.stream().anyMatch(t -> t.equalsIgnoreCase(getProfileName()));
    }

    private static String getProfileName() {
        return System.getProperty("environment");
    }

}
