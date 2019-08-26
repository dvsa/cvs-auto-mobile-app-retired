package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class EUVehicleCategoryPage extends BasePage{
    private static final String PAGE_TITLE_ID = "EU vehicle category";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String M_CATEGORY_DESCRIPTION_ID = "M - vehicles designed and constructed for the carriage of passengers and comprising:";
    private static final String M1_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M1 no more than eight seats in addition to the driver's seat\"]";
    private static final String M2_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M2 more than eight seats in addition to the driver's seat, and having a maximum mass not exceeding 5 tonnes\"]";
    private static final String M3_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"M3 more than eight seats in addition to the driver's seat, and having a maximum mass exceeding 5 tonnes\"]";
    private static final String O1_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"O1 not exceeding 0.75 tonnes\"]";
    private static final String O2_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"O2 exceeding 0.75 tonnes but not exceeding 3.5 tonnes\"]";
    private static final String O3_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"O3 exceeding 3.5 tonnes but not exceeding 10 tonnes\"]";
    private static final String O4_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[@name=\"O4 exceeding 10 tonnes\"]";
    private static final String PAGE_ALL_BUTTONS_CLASS_NAME = "XCUIElementTypeButton";

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

    public boolean isO1Displayed() {
        return findElementByXpath(O1_TRAILER_DESCRIPTION_XPATH).isDisplayed();
    }

    public boolean isO2Displayed() {
        return findElementByXpath(O2_TRAILER_DESCRIPTION_XPATH).isDisplayed();
    }

    public boolean isO3Displayed() {
        return findElementByXpath(O3_TRAILER_DESCRIPTION_XPATH).isDisplayed();
    }

    public boolean isO4Displayed() {
        return findElementByXpath(O4_TRAILER_DESCRIPTION_XPATH).isDisplayed();
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

    public void clickO1Option() {
        findElementByXpath(O1_TRAILER_DESCRIPTION_XPATH).click();
    }

    public void clickO2Option() {
        findElementByXpath(O2_TRAILER_DESCRIPTION_XPATH).click();
    }

    public void clickO3Option() {
        findElementByXpath(O3_TRAILER_DESCRIPTION_XPATH).click();
    }

    public void clickO4Option() {
        findElementByXpath(O4_TRAILER_DESCRIPTION_XPATH).click();
    }

    public void clickOption(String option) {
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains(option)) {
                button.click();
            }
        }
    }
}
