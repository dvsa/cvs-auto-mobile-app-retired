package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import data.util.SearchCriteria;

import java.util.List;

public class IdentifyVehiclePage extends BasePage {

    private static final String IDENTIFY_VEHICLE_PAGE_TITLE = "Identify vehicle";
    private static final String SEARCH_FIELD_CLASS_NAME = "XCUIElementTypeSearchField";
    private static final String SEARCH_BUTTON_CLASS_NAME = "XCUIElementTypeButton";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String SEARCH_OPTION = "Search";
    private static final String DESCRIPTION = "//XCUIElementTypeStaticText[contains(@name, 'Check you have entered the correct value or change the search criteria to identify a vehicle')]";
    private static final String TITLE = "//XCUIElementTypeStaticText[contains(@name, 'Vehicle not found')]";
    private static final String LOADING_SCREEN_ID = "Loading...";
    private static final String INCOMPLETE_RECORD_DESCRIPTION = "//XCUIElementTypeStaticText[contains(@name, 'This vehicle does not have enough data to be tested. Call Technical Support to correct this record and use SAR to test this vehicle.')]";
    private static final String INCOMPLETE_RECORD_TITLE = "//XCUIElementTypeStaticText[contains(@name, 'Incomplete vehicle record')]";
    private static final String SEARCH_CRITERIA_BUTTON = "//*[contains(@name, 'Change arrow forward')]";
    private static final String OK = "//XCUIElementTypeButton[contains(@name, 'OK')]";
    private static final String SEARCH_CRITERIA_ID = "SEARCH CRITERIA";

    public void clickSearchCriteriaButton() {
        findElementByXpath(SEARCH_CRITERIA_BUTTON).click();
    }

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

        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        WebElement description = null;
        WebElement title = null;

        try {
            okButton = findElementByXpath(OK);
            description = findElementByXpath(INCOMPLETE_RECORD_DESCRIPTION);
            title = findElementByXpath(INCOMPLETE_RECORD_TITLE);
        } catch (Exception e) {
            isException = true;
        }

        if ((okButton == null) || (description == null) || (title == null)) {
            isException = true;
        }

        if (!isException) {
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public String getSearchFieldText() {
        return findElementByClassName(SEARCH_FIELD_CLASS_NAME).getText();
    }

    public boolean isVehicleNotFoundPopUpDisplayed() {

        boolean status = false;
        boolean isException = false;
        WebElement okButton = null;
        WebElement description = null;
        WebElement title = null;

        try {
            okButton = findElementByXpath(OK);
            description = findElementByXpath(DESCRIPTION);
            title = findElementByXpath(TITLE);
        } catch (Exception e) {
            isException = true;
        }

        if ((okButton == null) || (description == null) || (title == null)) {
            isException = true;
        }

        if (!isException) {
            if (okButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
                status = true;
            }
        }
        return status;
    }

    public void clickOkInPopUp() {
        findElementByXpath(OK).click();
    }

    public void waitForErrorPopUpToDisplay() {
        waitUntilPageIsLoadedByXpath(OK);
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
        waitElementToDisappear(MobileBy.AccessibilityId(LOADING_SCREEN_ID), 90, 200);
    }

    public boolean isIdentifyVehicleTitleDisplayed() {
        return waitUntilPageIsLoadedById(IDENTIFY_VEHICLE_PAGE_TITLE).isDisplayed();
    }

    public boolean isSearchCriteriaSectionDisplayed() {
        waitUntilPageIsLoaded();
        return findElementByAccessibilityId(SEARCH_CRITERIA_ID).isDisplayed();
    }

    public boolean isSearchCriteriaButtonDisplayed(SearchCriteria searchCriteria) {
        waitUntilPageIsLoaded();
        return findElementByAccessibilityId(searchCriteria.getDescription()+" Change arrow forward").isDisplayed();
    }

    public void pressSearchCriteriaButton() {
        List<WebElement> allButtons = findElementsByClassName(SEARCH_BUTTON_CLASS_NAME);
        for(WebElement button: allButtons){
            if (button.getAttribute("name").endsWith("Change arrow forward")){
                button.click();
                break;
            }
        }
    }
}

