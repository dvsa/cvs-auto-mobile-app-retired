package pages;


import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify Vehicle";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeSearchField";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE);
    }

    public void searchForVehicle(String text) {
        findElementByXpath(SEARCH_FIELD_XPATH).sendKeys(text);
    }

    public void tapReturn() {
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).hideKeyboard();
    }
}
