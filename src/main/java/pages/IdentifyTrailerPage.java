package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class IdentifyTrailerPage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify trailer";
    private static final String SEARCH_FIELD_CLASS_NAME = "XCUIElementTypeSearchField";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String SEARCH_OPTION = "Search";
    private static final String OK_ID = "OK";
    private static final String DESCRIPTION_ID = "You can find a vehicle by typing in its registration number or vehicle identification/chassis number";
    private static final String TITLE_ID = "Vehicle not found";
    private static final String LOADING_SCREEN_ID = "Loading...";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE);
    }

    public void searchForVehicle(String text) {
        WebElement searchField = findElementByClassName(SEARCH_FIELD_CLASS_NAME);
        searchField.clear();
        searchField.sendKeys(text);
        waitUntilPageIsLoadedByXpath("//*[@value='" + text + "']");
    }

    public void clickSearch() {
        findElementById(SEARCH_OPTION).click();
    }

    public void tapCancel() {
        findElementById(CANCEL_OPTION_ID).click();
    }

    public boolean isSearchFieldDisplayed() {
        return findElementByClassName(SEARCH_FIELD_CLASS_NAME).isDisplayed();
    }

    public boolean isSearchFieldEmpty() {
        String inputText = findElementByClassName(SEARCH_FIELD_CLASS_NAME).getText();
        return inputText.isEmpty();
    }

    public String getSearchFieldText() {
        return findElementByClassName(SEARCH_FIELD_CLASS_NAME).getText();
    }

    public boolean isVehicleNotFoundPopUpDisplayed() {
        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        try {
            okButton = findElementById(OK_ID);
        } catch (Exception e) {
            isException = true;
        }

        if (!isException) {
            WebElement description = findElementById(DESCRIPTION_ID);
            WebElement title = findElementById(TITLE_ID);
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public void clickOkInPopUp() {
        waitUntilPageIsLoadedById(OK_ID);
        findElementById(OK_ID).click();
    }

    public boolean isSearchFieldUnique() {
        boolean status = false;
        List<WebElement> searchFieldList = findElementsByClassName(SEARCH_FIELD_CLASS_NAME);
        if (searchFieldList.size() == 1)
            status = true;
        return status;
    }

    public boolean isLoadingScreenDisplayed() {
        return findElementByAccessibilityId(LOADING_SCREEN_ID).isDisplayed();
    }

    public boolean isIdentifyVehicleTitleDisplayed() {
        return waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE).isDisplayed();
    }
}

