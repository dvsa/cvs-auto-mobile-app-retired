package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import java.util.List;

public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify vehicle";
    private static final String SEARCH_FIELD_CLASS_NAME = "XCUIElementTypeSearchField";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String SEARCH_OPTION = "Search";
    private static final String OK_ID = "OK";
    private static final String DESCRIPTION_ID = "Check you have entered the correct value or change the search criteria to identify a vehicle";
    private static final String TITLE_ID = "Vehicle not found";
    private static final String LOADING_SCREEN_ID = "Loading...";
    private static final String INCOMPLETE_RECORD_DESCRIPTION_ID = "This vehicle does not have enough data to be tested. Call Technical Support to correct this record and use SAR to test this vehicle.";
    private static final String INCOMPLETE_RECORD_TITLE_ID = "Incomplete vehicle record";

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

    public boolean isIncompleteRecordPopupShown() {
        System.out.println("Checking if the 'Incomplete Record' popup is shown...");
        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        try {
            okButton = findElementById(OK_ID);
        } catch (Exception e) {
            isException = true;
            System.out.println("- NOT found.");
        }

        if (!isException) {
            WebElement description = findElementById(INCOMPLETE_RECORD_DESCRIPTION_ID);
            WebElement title = findElementById(INCOMPLETE_RECORD_TITLE_ID);
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                System.out.println("- Popup found.");
                status = true;
            }
        }
        return status;
    }

    public String getSearchFieldText() {
        return findElementByClassName(SEARCH_FIELD_CLASS_NAME).getText();
    }

    public boolean isVehicleNotFoundPopUpDisplayed() {
        System.out.println("Checking for the presence of the 'Vehicle not found' popup...");
        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        try {
            okButton = findElementById(OK_ID);
        } catch (Exception e) {
            isException = true;
            System.out.println("- NOT found.");
        }

        if (!isException) {
            WebElement description = findElementById(DESCRIPTION_ID);
            WebElement title = findElementById(TITLE_ID);
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
                System.out.println("- Popup found.");
            }
        }
        return status;
    }

    public void clickOkInPopUp() {
        waitUntilPageIsLoadedById(OK_ID);
        findElementById(OK_ID).click();
    }

    public void waitForErrorPopUpToDisplay() {
        waitUntilPageIsLoadedById(OK_ID);
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

    public void waitForLoadingToEnd(){
        waitElementToDisappear(MobileBy.AccessibilityId(LOADING_SCREEN_ID), 20, 200);
    }

    public boolean isIdentifyVehicleTitleDisplayed() {
        return waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE).isDisplayed();
    }
}

