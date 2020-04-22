package pages;

import exceptions.AutomationException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EUVehicleCategoryPage extends BasePage{
    private static final String PAGE_TITLE_ID = "EU vehicle category";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String M_CATEGORY_DESCRIPTION_ID = "M - vehicles designed and constructed for the carriage of passengers and comprising:";
    private static final String M1_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"M1 no more than eight seats in addition to the driver's seat\")]";
    private static final String M1_VEHICLE_DESCRIPTION_CHECKED_XPATH = "//XCUIElementTypeButton[@name=\"M1 no more than eight seats in addition to the driver's seat checkmark\"]";
    private static final String M2_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"M2 more than eight seats in addition to the driver's seat, and having a maximum mass not exceeding 5 tonnes\")]";
    private static final String M3_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contails(@name, \"M3 more than eight seats in addition to the driver's seat, and having a maximum mass exceeding 5 tonnes\")]";
    private static final String O1_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"O1 not exceeding 0.75 tonnes\")]";
    private static final String O2_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"O2 exceeding 0.75 tonnes but not exceeding 3.5 tonnes\")]";
    private static final String O3_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"O3 exceeding 3.5 tonnes but not exceeding 10 tonnes\")]";
    private static final String O4_TRAILER_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, \"O4 exceeding 10 tonnes\")]";
    private static final String PAGE_ALL_BUTTONS_CLASS_NAME = "XCUIElementTypeButton";

    // Motorcycle categories.
    private static final String L_CATEGORY_DESCRIPTION_ID = "L - 2 and 3-wheel vehicles and quadricycles.";
    private static final String L1EA_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L1e-A Low Powered Moped')]";
    private static final String L1E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L1e Two-wheel vehicle with a maximum design speed of not more than 45 km/h and characterised by an engine whose cylinder capacity does not exceed 50 cm3 in the case of the internal combustion type, or maximum continuous rated power is no more than 4 kW in the case of an electric motor')]";
    private static final String L2E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L2e Three-wheel vehicle with a maximum design speed of not more than 45 km/h and characterised by an engine whose cylinder capacity does not exceed 50 cm3 if of the spark (positive) ignition type, or maximum net power output does not exceed 4 kW in the case of other internal combustion engines, or maximum continuous rated power does not exceed 4 kW in the case of an electric motor')]";
    private static final String L3E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L3e Two-wheel vehicle without a sidecar fitted with an engine having a cylinder capacity of more than 50 cm3 if of the internal combustion type and/or having a maximum design speed of more than 45 km/h')]";
    private static final String L4E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L4e Two-wheel vehicle with a sidecar fitted with an engine having a cylinder capacity of more than 50 cm3 if of the internal combustion type and/or having a maximum design speed of more than 45 km/h')]";
    private static final String L5E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L5e Vehicle with three symmetrically arranged wheels fitted with an engine having a cylinder capacity of more than 50 cm3 if of the internal combustion type and/or a maximum design speed of more than 45 km/h')]";
    private static final String L6E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L6e Quadricycle whose unladen mass is not more than 350 kg, not including the mass of the batteries in case of electric vehicles, whose maximum design speed is not more than 45 km/h, and whose engine cylinder capacity does not exceed 50 cm3 for spark (positive) ignition engines, or maximum net power output does not exceed 4 kW in the case of other internal combustion engines, or maximum continuous rated power does not exceed 4 kW in the case of an electric motor. This vehicle shall fulfill the technical requirements applicable to three-wheel mopeds of category L2e unless specified differently')]";
    private static final String L7E_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'L7e Quadricycle other than those referred to in category L6e, whose unladen mass is not more than 400 kg (550 kg for vehicles intended for carrying goods), not including the mass of batteries in the case of electric vehicles, and whose maximum net engine power does not exceed 15 kW. These vehicles shall be considered to be motor tricycles and shall fulfill the technical requirements applicable to motor tricycles of category L5e unless specified differently')]";

    private static final String N_CATEGORY_DESCRIPTION_ID = "N - vehicles designed and constructed for the carriage of goods and having a maximum mass:";
    private static final String N1_VEHICLE_DESCRIPTION_CHECKED_XPATH = "//XCUIElementTypeButton[contains(@name, 'N1 not exceeding 3.5 tonnes checkmark')]";
    private static final String N1_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'N1 not exceeding 3.5 tonnes checkmark')]";
    private static final String N2_VEHICLE_DESCRIPTION_CHECKED_XPATH = "//XCUIElementTypeButton[contains(@name, 'N2 exceeding 3.5 tonnes but not exceeding 12 tonnes checkmark')]";
    private static final String N3_VEHICLE_DESCRIPTION_XPATH = "//XCUIElementTypeButton[contains(@name, 'N3 exceeding 12 tonnes')]";

    public boolean isLDescriptionLabelDisplayed() {
        return findElementById(L_CATEGORY_DESCRIPTION_ID).isDisplayed();
    }

    public boolean isL1eADisplayed() {

        // Sometimes this first element is checked.
        boolean isL1eaShown = false;
        if (findElementByXpath(L1E_VEHICLE_DESCRIPTION_XPATH).isDisplayed()) {
            isL1eaShown = true;
        } else if (findElementByXpath(L1E_VEHICLE_DESCRIPTION_XPATH + " checkmark").isDisplayed()) {
            isL1eaShown = true;
        }
        return isL1eaShown;
    }

    public boolean isL1eDisplayed() {
        return findElementByXpath(L1E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL2eDisplayed() {
        return findElementByXpath(L2E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL3eDisplayed() {
        return findElementByXpath(L3E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL4eDisplayed() {
        return findElementByXpath(L4E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL5eDisplayed() {
        return findElementByXpath(L5E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL6eDisplayed() {
        return findElementByXpath(L6E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }
    public boolean isL7eDisplayed() {
        return findElementByXpath(L7E_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
    }

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
        try {
            return findElementByXpath(M1_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isM1CheckedDisplayed() {
        return findElementByXpath(M1_VEHICLE_DESCRIPTION_CHECKED_XPATH).isDisplayed();
    }

    public boolean isNDescriptionLabelDisplayed() {
        return findElementById(N_CATEGORY_DESCRIPTION_ID).isDisplayed();
    }

    public boolean isN1CheckedDisplayed() {
        return findElementByXpath(N1_VEHICLE_DESCRIPTION_CHECKED_XPATH).isDisplayed();
    }

    public boolean isN1Displayed() {
        try {
            return findElementByXpath(N1_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isN2CheckedDisplayed() {
        return findElementByXpath(N2_VEHICLE_DESCRIPTION_CHECKED_XPATH).isDisplayed();
    }

    public boolean isN3Displayed() {
        return findElementByXpath(N3_VEHICLE_DESCRIPTION_XPATH).isDisplayed();
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

    @Deprecated
    public void clickM1Option() {
        findElementByXpath(M1_VEHICLE_DESCRIPTION_XPATH).click();
    }

    @Deprecated
    public void clickM2Option() {
        findElementByXpath(M2_VEHICLE_DESCRIPTION_XPATH).click();
    }

    @Deprecated
    public void clickM3Option() {
        findElementByXpath(M3_VEHICLE_DESCRIPTION_XPATH).click();
    }

    public void clickVehicleCategory(String category) {
        waitUntilPageIsLoaded();
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'" + category + "')]").click();
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
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        int i = 0;
        for (WebElement button : buttonList) {
            // shortWaitUntilPageIsLoadedByIdAndClickable(button.getAttribute("name"));
            if (button.getAttribute("name").contains(option)) {
                System.out.println("Clicking on Option: " + button.getAttribute("name"));
                button.click();
                break;
            }
        }
        if ( i == buttonList.size()) {
            throw  new AutomationException("The selected option does not exist");
        }
    }
}
