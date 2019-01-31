package pages;


import org.openqa.selenium.WebElement;

public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify Vehicle";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String SEARCH_OPTION = "Search";
    private static final String OK_ID = "OK";
    private static final String DESCRIPTION_ID = "You can find a vehicle by typing in its registration number or vehicle identification/chassis number";
    private static final String TITLE_ID = "Vehicle not found";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE);
    }

    public void searchForVehicle(String text) {
        WebElement searchField = findElementByXpath(SEARCH_FIELD_XPATH);
        searchField.clear();
        searchField.sendKeys(text);
    }

    public void clickSearch() {
        findElementById(SEARCH_OPTION).click();
    }

    public void tapCancel() {
        findElementById(CANCEL_OPTION_ID).click();
    }

    public boolean isSearchFieldDisplayed() {
        return findElementByXpath(SEARCH_FIELD_XPATH).isDisplayed();
    }

    public String getSearchFieldText() {
        return findElementByXpath(SEARCH_FIELD_XPATH).getText();
    }

    public boolean isVehicleNotFoundPopUpDisplayed() {
        boolean status = false ;
        WebElement okButton = waitUntilPageIsLoadedById(OK_ID);
        WebElement description = findElementById(DESCRIPTION_ID);
        WebElement title = findElementById(TITLE_ID);
        if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickOkInPopUp() {
        waitUntilPageIsLoadedById(OK_ID);
        findElementById(OK_ID).click();
    }
}
