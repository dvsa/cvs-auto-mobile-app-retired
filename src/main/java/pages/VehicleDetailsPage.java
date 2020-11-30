package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetailsPage extends BasePage {

    private static final String VEHICLE_DETAILS_PAGE_TITLE = "Vehicle details";
    private static final String CONFIRM_BUTTON_ID = "Confirm";
    private static final String ADDITIONAL_VEHICLE_DETAILS_BUTTON_ID = "Additional vehicle details";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String PAGE_ALL_BUTTON_XPATH = "//XCUIElementTypeButton";
    private static final String CANCEL_ID = "Cancel";
    private static final String CONFIRM_ID = "Confirm";
    private static final String CONFIRM_VEHICLE_ID = "Confirm vehicle";
    private static final String CONFIRMATION_TEXT_ID = "This action will confirm the vehicle for testing.";
    private static final String VEHICLE_TEST_HISTORY_BUTTON_ID = "Vehicle test history";
    private static final String TRAILER_TEST_HISTORY_BUTTON_ID = "Trailer test history";
    private static final String BACK_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name,'arrow back')]";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(VEHICLE_DETAILS_PAGE_TITLE);
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    /**
     * Creates a list of the vehicle summary values using xpath
     *
     * @return the list of data containing both Keys and Values of the details page
     */
    public List<String> findAllValuesByXpath() {
        waitUntilPageIsLoaded();
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("value"));
        }

        return listOfData;
    }


    public void clickConfirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }

    public void clickConfirmPopUp() {
        waitUntilNumberOfElementsToBe(MobileBy.AccessibilityId(CONFIRM_BUTTON_ID), 2);
        findElementsByAccessibilityId(CONFIRM_BUTTON_ID).get(1).click();
    }

    public void clickCancel() {
        findElementById(CANCEL_ID).click();
    }

    public boolean isConfirmationPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(CANCEL_ID);
        WebElement confirmButton = findElementById(CONFIRM_ID);
        WebElement text = findElementById(CONFIRMATION_TEXT_ID);
        WebElement title = findElementById(CONFIRM_VEHICLE_ID);
        if (cancelButton.isDisplayed() && confirmButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isPageTitleDisplayed() {
        try {
            return findElementById(VEHICLE_DETAILS_PAGE_TITLE).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isRegistrationPlateDisplayed(String registrationPlate) {
        waitUntilPageIsLoaded();
        try {
            return findElementById(registrationPlate).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean elementFromListIsDisplayed(String element) {
        try {
            return findElementById(element).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public void clickExpandableInformation(String info) {
        waitUntilPageIsLoadedById(info).click();
    }

    public boolean isFieldValueNull(String value) {
        boolean status = false;
        if (findElementByXpath("//*[@value='" + value + "']").getAttribute("value") == null) {
            status = true;
        }
        return status;
    }

    public void clickVehicleTestHistory() {
        findElementByXpath("//*[@name='" + VEHICLE_TEST_HISTORY_BUTTON_ID + "']|" +
                "//*[@name='" + TRAILER_TEST_HISTORY_BUTTON_ID + "']").click();
    }

    public void clickBackButton() {
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public boolean isTestHistoryButtonDisplayed() {
        try {
            return findElementById(VEHICLE_TEST_HISTORY_BUTTON_ID).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isAttribute(String attribute, String value) {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> actualData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            actualData.add(webElement.getAttribute("name"));
        }
        for (String data : actualData) {
            if (data.equals(attribute)) {
                if (actualData.get(actualData.indexOf(data) + 1).equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isButtonDisplayed(String button) {

        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_BUTTON_XPATH);
        for (WebElement webElement : webElementList) {
            if (webElement.getAttribute("name").equals(button)) {
                return webElement.isDisplayed();
            }
        }
        return false;
    }

    public boolean isVinDisplayed(String vin) {
        waitUntilPageIsLoaded();
        try {
            return findElementById(vin).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isSectionHeadingDisplayed(String sectionHeading) {
        try {
            return findElementById(sectionHeading).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean isFieldDisplayed(String field) {
        try {
            return findElementById(field).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }
}
