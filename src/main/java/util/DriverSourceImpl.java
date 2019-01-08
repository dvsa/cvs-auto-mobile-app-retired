package util;

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


    @Override

    public WebDriver newDriver() {

        WebDriver webDriver = null;

        if (System.getProperty("environment") != null && System.getProperty("environment").equalsIgnoreCase("CI")) {
            DesiredCapabilities caps = getDesireCapByImpl(new LoaderBrowserstackCIImpl());
            webDriver = new IOSDriver<>(getUrl(new LoaderBrowserstackCIImpl()), caps);
        } else {
            if (TypeLoader.getType().equalsIgnoreCase(LOCAL_REAL_DEVICE)) {
                DesiredCapabilities caps = getDesireCapByImpl(new LoaderlLocalRealDeviceImpl());
                webDriver = new IOSDriver<>(getUrl(new LoaderlLocalRealDeviceImpl()), caps);
            } else if (TypeLoader.getType().equalsIgnoreCase(LOCAL_SIMULATOR)) {
                DesiredCapabilities caps = getDesireCapByImpl(new LoaderLocalSimulatorImpl());
                webDriver = new IOSDriver<>(getUrl(new LoaderLocalSimulatorImpl()), caps);
            } else if (TypeLoader.getType().equalsIgnoreCase(LOCAL_BROWSERSTACK)) {
                DesiredCapabilities caps = getDesireCapByImpl(new LoaderBrowserstackLocalImpl());
                webDriver = new IOSDriver<>(getUrl(new LoaderBrowserstackLocalImpl()), caps);
            }
        }


        return webDriver;

    }

    @Override
    public boolean takesScreenshots() {
        return false;
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
