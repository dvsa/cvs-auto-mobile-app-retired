package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPage extends BasePage {

    private static final String SELECT_PREPARER_PAGE_TITLE = "Test";
    private static final String ADD_TEST_TYPE_BUTTON_ID = "Add a test type";
    private static final String PAGE_ALL_BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String ADD_LINKED_TEST_TYPE_BUTTON_ID = "Add a linked test add circle-outline";
    private static final String REVIEW_AND_CONFIRM_BUTTON_ID = "Review & Confirm";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String CANCEL_BUTTON_BOTTOM_RIGHT = "Cancel";

    private static final String CANCEL_ID = "Cancel";
    private static final String REMOVE_ID = "Remove";
    private static final String DESCRIPTION_ID = "This action will remove this test from the vehicle.";
    private static final String TITLE_ID = "Remove test";
    private static final String ABANDON_BUTTON_ID = "Abandon";
    private static final String TEST_NOT_COMPLETE_TITLE = "Test not complete";
    private static final String TEST_NOT_COMPLETE_INFO = "You must complete all test types marked \"in progress\" before reviewing.";
    private static final String OK_BUTTON = "OK";
    private static final String VEHICLE_DETAILS_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'Details')]";


    public enum OdometerUnitIndicatives {
        ENTER("Enter"), KM("km"), MI("mi");

        private String value;

        OdometerUnitIndicatives(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public enum TestTypeStatuses {
        IN_PROGRESS("In progress"), EDIT("Edit"), ABANDONED("Abandoned");

        private String value;

        TestTypeStatuses(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void addTestType() {
        findElementById(ADD_TEST_TYPE_BUTTON_ID).click();
    }

    public void clickOnTestType(String testType, TestTypeStatuses testTypeStatus) {
        switch (testTypeStatus) {
            case EDIT:
                findElementById(testType + " " + testTypeStatus.getValue() + " checkmark").click();
                break;
            case ABANDONED:
                // TODO refactor after bug fix for CVSB-2065
                findElementById(testType + " " + testTypeStatus.getValue()).click();
                break;
            default:
                findElementById(testType + " " + testTypeStatus.getValue() + " arrow forward").click();
                break;
        }
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(SELECT_PREPARER_PAGE_TITLE).isDisplayed();
    }

    public boolean isCancelButtonDisplayed() {
        return findElementById(CANCEL_BUTTON_BOTTOM_RIGHT).isDisplayed();
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate, String vin) {
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (PSV) " + vin + " Details arrow forward']").isDisplayed();
    }

    public boolean isAddATestTypeButtonDisplayed() {
        return findElementById(ADD_TEST_TYPE_BUTTON_ID).isDisplayed();
    }

    public List<String> findAllTestTypesFromListByClassName() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        List<String> listOfButtons = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfButtons.add(webElement.getAttribute("name"));
        }

        return listOfButtons;
    }

    public boolean isTestTypeStatusDisplayed(String testType, TestTypeStatuses status) {
        boolean isDisplayed;
        switch (status) {
            case EDIT:
                isDisplayed = findElementById(testType + " " + status.getValue() + " checkmark").isDisplayed();
                break;
            case ABANDONED:
                // TODO refactor after bug fix for CVSB-2065
                isDisplayed = findElementById(testType + " " + status.getValue()).isDisplayed();
                break;
            default:
                isDisplayed = findElementById(testType + " " + status.getValue() + " arrow forward").isDisplayed();
                break;
        }
        return isDisplayed;
    }

    public int checkDataByLabelValueAndName(String... values) {
        return findAllDataByComposedXpath(values).size();
    }

    public void clickOnNotCompleteTest(String testName) {
        findElementById(testName + " In progress arrow forward").click();
    }

    public void clickOnAbandonedTest(String testName) {
        findElementByXpath("//XCUIElementTypeButton[@name='" + testName + "']").click();
    }

    public void clickVehicleDetails() {
        findElementByXpath(VEHICLE_DETAILS_BUTTON_XPATH).click();
    }

    public boolean isSubmitButtonAvailable() {
        return findElementById(REVIEW_AND_CONFIRM_BUTTON_ID).isDisplayed();
    }

    //TODO create generic swipe action in BasePage
    public void swipeLeftOnTestType(String testType) {
        WebElement testTypeToSwipe = findElementById(testType);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((RemoteWebElement) testTypeToSwipe).getId());
        js.executeScript("mobile: swipe", params);
    }

    public boolean isRemoveButtonDisplayed() {
        return findElementById(REMOVE_BUTTON_ID).isDisplayed();
    }

    public void clickOnRedRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isRemovePopUpDisplayed() {
        boolean status = false;
        WebElement cancelButton = findElementById(CANCEL_ID);
        WebElement removeButton = findElementById(REMOVE_ID);
        WebElement description = findElementById(DESCRIPTION_ID);
        WebElement title = findElementById(TITLE_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && description.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickRemoveFromPopUp() {
        findElementById(REMOVE_ID).click();
    }

    public void clickCancelFromPopUp() {
        findElementById(CANCEL_ID).click();
    }

    public void clickCancelFromBottomRight() {
        findElementById(CANCEL_BUTTON_BOTTOM_RIGHT).click();
    }

    public boolean isAbandonButtonDisplayed() {
        return findElementById(ABANDON_BUTTON_ID).isDisplayed();
    }

    public void pressAbandonButton() {
        findElementById(ABANDON_BUTTON_ID).click();
    }

    public boolean isAddALinkedTestVisible() {
        return findElementById(ADD_LINKED_TEST_TYPE_BUTTON_ID).isDisplayed();
    }

    public void addALinkedTestType() {
        findElementById(ADD_LINKED_TEST_TYPE_BUTTON_ID).click();
    }

    public void clickOdometerReading() {
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains("Odometer reading")) {
                button.click();
                break;
            }
        }
    }

    public boolean isOdometerButtonIndicativeDisplayed(OdometerUnitIndicatives odometerUnitIndicatives) {
        boolean status;
        switch (odometerUnitIndicatives) {
            case ENTER:
                status = findElementById("Odometer reading " + odometerUnitIndicatives.getValue() + " arrow forward").isDisplayed();
                break;
            default:
                status = findElementById("Odometer reading " + getOdometerValue() + " " + odometerUnitIndicatives.getValue() + " checkmark").isDisplayed();
                break;
        }
        return status;
    }

    public String getOdometerValue() {
        String value = "";
        waitUntilPageIsLoaded();
        List<WebElement> buttonList = findElementsByClassName(PAGE_ALL_BUTTONS_CLASS_NAME);
        for (WebElement button : buttonList) {
            if (button.getAttribute("name").contains("Odometer reading")) {
                String[] stringArray = button.getAttribute("name").split(" ");
                value = stringArray[2];
                break;
            }
        }
        return value;
    }

    public boolean isTestNotCompleteDisplayed() {
        return findElementByAccessibilityId(TEST_NOT_COMPLETE_TITLE).isDisplayed() && findElementByAccessibilityId(TEST_NOT_COMPLETE_INFO).isDisplayed();
    }

    public void clickReviewAndConfirm() {
        findElementById(REVIEW_AND_CONFIRM_BUTTON_ID).click();
    }

    public boolean buttonOkIsClickable() {
        return findElementByAccessibilityId(OK_BUTTON).isEnabled() && findElementByAccessibilityId(OK_BUTTON).isDisplayed();
    }

    public void clickOkButton() {
        findElementByAccessibilityId(OK_BUTTON).click();
    }
}

