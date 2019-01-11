package pages;


import io.appium.java_client.ios.IOSDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Keys;

public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify Vehicle";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeSearchField";
    private static final String CLOSE_OPTION_ID = "Close";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE);
    }

    public void searchForVehicle(String text) {
        findElementByXpath(SEARCH_FIELD_XPATH).sendKeys(text);
    }

    public void tapReturn() {
        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).getKeyboard().sendKeys(Keys.RETURN);
    }

    public void tapClose() {
        findElementById(CLOSE_OPTION_ID).click();
    }

}
