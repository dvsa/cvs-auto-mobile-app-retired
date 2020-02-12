package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectVehiclePage extends BasePage {

    private static final String SELECT_VEHICLE_PAGE_TITLE = "Select Vehicle";
    private static final String MULTIPLE_VEHICLES_FOUND_XPATH = "(//XCUIElementTypeStaticText[@name='Multiple vehicles found matching this search'])";
    private static final String BACK_BUTTON_XPATH = "(//XCUIElementTypeButton[@name='arrow back Identify vehicle'])";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_VEHICLE_PAGE_TITLE);
    }

    public void isMultipleVehiclesDisplayed(){
        findElementByXpath(MULTIPLE_VEHICLES_FOUND_XPATH).isDisplayed();
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if (findElementById(SELECT_VEHICLE_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public String getBackCtaText() {
        return findElementByXpath(BACK_BUTTON_XPATH).getText();
    }

    public boolean isBackCtaDisplayed() {
        return findElementByXpath(BACK_BUTTON_XPATH).isDisplayed();
    }

    public void clickBackCta(){
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public boolean isVehicleDetailsPresent(String make, String year, String model){
        String searchString = make+" "+year+","+" "+model;
        boolean status = false;
        if(findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").isDisplayed()){
            status = true;
        }
        return status;
    }

    public void clickOnVehicle(String make, String year, String model){
        String searchString = make+" "+year+","+" "+model;
        findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").click();
    }

   /* public void searchForVehicle(String text) {
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
    }*/
}

