package pages;

import org.openqa.selenium.WebElement;

public class SelectVehiclePage extends BasePage {

    private static final String SELECT_VEHICLE_PAGE_TITLE = "Select Vehicle";
    private static final String MULTIPLE_VEHICLES_FOUND_XPATH = "(//XCUIElementTypeStaticText[@name='Multiple vehicles found matching this search'])";
    private static final String BACK_BUTTON_XPATH = "(//XCUIElementTypeButton[@name='arrow back Identify vehicle'])";
    private static final String INCOMPLETE_RECORD_MULTIPLE_DESCRIPTION = "//XCUIElementTypeStaticText[contains(@name, 'Some vehicles matching this search do not have enough data to be tested. Call Technical Support to correct these records and use SAR to test this vehicle.')]";
    private static final String INCOMPLETE_RECORD_DESCRIPTION = "//XCUIElementTypeStaticText[contains(@name, 'This vehicle does not have enough data to be tested. Call Technical Support to correct this record and use SAR to test this vehicle.')]";
    private static final String INCOMPLETE_RECORD_TITLE = "//XCUIElementTypeStaticText[contains(@name, 'Incomplete vehicle record')]";
    private static final String INCOMPLETE_RECORD_VEHICLE = "Incomplete vehicle record Requires more data to be tested";

    private static final String OK_ID = "OK";
    private static final String OK = "//XCUIElementTypeButton[contains(@name, 'OK')]";


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

    public boolean isSkeletonRecordWarningShown() {
        try {
            return findElementByXpath(INCOMPLETE_RECORD_MULTIPLE_DESCRIPTION).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isIncompleteVehiclePresent() {
        try {
            return findElementById(INCOMPLETE_RECORD_VEHICLE).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
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
                logger.info("- Popup found.");
                status = true;
            }
        }
        return status;
    }

    public void clickOkInPopUp() {
        waitUntilPageIsLoadedById(OK_ID);
        findElementById(OK_ID).click();
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
        String searchString = make + " " + year + " , " + model;
        boolean status = false;
        if(findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").isDisplayed()){
            status = true;
        }
        return status;
    }

    public void clickOnVehicle(String make, String year, String model){
        String searchString = make + " " + year + " , " + model;
        logger.info("Selecting vehicle: " + searchString);
        findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").click();
    }

    public void clickOnIncompleteVehicle(){
        findElementById(INCOMPLETE_RECORD_VEHICLE).click();
    }

    public void waitForErrorPopUpToDisplay() {
        waitUntilPageIsLoadedById(OK_ID);
    }
}

