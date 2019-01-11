package util;

import exceptions.AutomationException;
import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSourceImpl implements DriverSource {

    private static final String LOCAL_REAL_DEVICE = "localRealDevice";
    private static final String LOCAL_BROWSERSTACK = "localBrowserstack";
    private static final String LOCAL_SIMULATOR = "localSimulator";
    private static final String CI_BROWSERSTACK = "CI";


    @Override

    public WebDriver newDriver() {

        WebDriver webDriver = null;
        String envType = TypeLoader.getType();

        switch (envType) {
            case CI_BROWSERSTACK:
                webDriver = setupWebDriver(new LoaderBrowserstackCIImpl());
                break;
            case LOCAL_REAL_DEVICE:
                webDriver = setupWebDriver(new LoaderlLocalRealDeviceImpl());
                break;
            case LOCAL_SIMULATOR:
                webDriver = setupWebDriver(new LoaderLocalSimulatorImpl());
                break;
            case LOCAL_BROWSERSTACK:
                webDriver = setupWebDriver(new LoaderBrowserstackLocalImpl());
                break;
            default:
                throw new AutomationException("Environment configuration not found");

        }

        return webDriver;

    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

    private WebDriver setupWebDriver(Loader loader) {

        DesiredCapabilities caps = getDesireCapByImpl(loader);
        return new IOSDriver<>(getUrl(loader), caps);
    }


    private DesiredCapabilities getDesireCapByImpl(Loader loader) {
        return loader.loadCapabilities();
    }

    private URL getUrl(Loader loader) {

        URL url = null;
        try {
            url = loader.loadUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
