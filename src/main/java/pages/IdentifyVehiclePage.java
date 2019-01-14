package pages;


public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify Vehicle";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String SEARCH_OPTION = "Search";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE);
    }

    public void searchForVehicle(String text) {
        findElementByXpath(SEARCH_FIELD_XPATH).sendKeys(text);
    }

    public void clickSearch() {
        findElementById(SEARCH_OPTION).click();
//        ((IOSDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).getKeyboard().sendKeys(Keys.RETURN);
    }

    public void tapCancel() {
        findElementById(CANCEL_OPTION_ID).click();
    }

}
