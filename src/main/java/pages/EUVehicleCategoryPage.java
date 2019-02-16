package pages;

public class EUVehicleCategoryPage extends BasePage{
    private static final String PAGE_TITLE_ID = "EU vehicle category";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String M_CATEGORY_DESCRIPTION_ID = "M - vehicles designed and constructed for the carriage of passengers and comprising:";
    private static final String M1_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M1 Vehicles designed and constructed for the carriage of passengers and comprising no more than eight seats in addition to the driver's seat.\"]";
    private static final String M2_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M2 Vehicles designed and constructed for the carriage of passengers, comprising more than eight seats in addition to the driver's seat, and having a maximum mass not exceeding 5 tonnes\"]";
    private static final String M3_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M3 Vehicles designed and constructed for the carriage of passengers, comprising more than eight seats in addition to the driver's seat, and having a maximum mass exceeding 5 tonnes\"]";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    public boolean isMDescriptionLabelDisplayed() {
        return findElementById(M_CATEGORY_DESCRIPTION_ID).isDisplayed();
    }

    public boolean isM1Displayed() {
        return findElementByXpath(M1_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }

    public boolean isM2Displayed() {
        return findElementByXpath(M2_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }

    public boolean isM3Displayed() {
        return findElementByXpath(M3_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }

    public void clickSaveButton() {
         findElementById(SAVE_BUTTON_ID).click();
    }

    public void clickM1Option() {
        findElementByXpath(M1_VEHICLE_DESCRIPTION_XPATH).click();
    }

    public void clickM2Option() {
        findElementByXpath(M2_VEHICLE_DESCRIPTION_XPATH).click();
    }

    public void clickM3Option() {
        findElementByXpath(M3_VEHICLE_DESCRIPTION_XPATH).click();
    }
}
