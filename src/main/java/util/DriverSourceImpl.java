package util;

import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSourceImpl implements DriverSource {


    @Override
    public WebDriver newDriver() {

        WebDriver webDriver = setupWebDriver(new LoaderBrowserstackLocalImpl());

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
