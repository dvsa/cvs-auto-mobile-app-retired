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
    private static final String ADD_TEST_TYPE_BUTTON_ID = "Add a test type add circle-outline";
    private static final String PAGE_ALL_BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String ADD_LINKED_TEST_TYPE_BUTTON_ID = "Add a linked test add circle-outline";
    private static final String REVIEW_AND_CONFIRM_BUTTON_ID = "Review & Confirm";
    private static final String REMOVE_BUTTON_ID = "Remove";

    private static final String CANCEL_ID = "Cancel";
    private static final String REMOVE_ID = "Remove";
    private static final String DESCRIPTION_ID = "This action will remove this test from the vehicle.";
    private static final String TITLE_ID = "Remove test";
    private static final String ABANDON_BUTTON_ID = "Abandon";

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

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void addTestType() {
        findElementById(ADD_TEST_TYPE_BUTTON_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if (findElementById(SELECT_PREPARER_PAGE_TITLE).isDisplayed())
            status = true;
        return status;
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate) {
        boolean status = false;
        if (findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (PSV) 1B7GG36N12S678410 Details arrow forward']").isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isAddATestTypeButtonDisplayed() {
        boolean status = false;
        if (findElementById(ADD_TEST_TYPE_BUTTON_ID).isDisplayed())
            status = true;
        return status;
    }

    public List<String> findAllTestTypesFromListByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_BUTTONS_CLASS_NAME);
        List<String> listOfButtons = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfButtons.add(webElement.getAttribute("name"));
        }

        return listOfButtons;
    }

    public int checkDataByLabelValueAndName(String... values) {
        return findAllDataByComposedXpath(values).size();

    }

    public void clickOnNotCompleteTest(String testName) {
        findElementByAccessibilityIdId(testName + " In progress arrow forward").click();
    }

    public void clickOnAbandonedTest(String testName) {
         findElementByXpath("//XCUIElementTypeButton[@name='" + testName + "']").click();
    }

    public boolean isSubmitButtonAvailable() {
        boolean status = false;
        if (findElementById(REVIEW_AND_CONFIRM_BUTTON_ID).isDisplayed())
            status = true;
        return status;
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
        boolean status = false;
        if (findElementById(REMOVE_BUTTON_ID).isDisplayed())
            status = true;
        return status;
    }

    public void clickOnRedRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isRemovePopUpDisplayed() {
        boolean status = false ;
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

    public boolean isAbandonButtonDisplayed() {
        boolean status = false;
        if (findElementById(ABANDON_BUTTON_ID).isDisplayed())
            status = true;
        return status;
    }

    public void pressAbandonButton() {
        findElementById(ABANDON_BUTTON_ID).click();
    }

    public boolean isAddALinkedTestVisible() {
        boolean status = false;
        if (findElementById(ADD_LINKED_TEST_TYPE_BUTTON_ID).isDisplayed())
            status = true;
        return status;
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
        boolean status = false;
        switch (odometerUnitIndicatives) {
            case ENTER:
                status = findElementById("Odometer reading " + odometerUnitIndicatives.getValue() + " arrow forward").isDisplayed();
                break;
            case KM:
                status = findElementById("Odometer reading " + getOdometerValue() + " " + odometerUnitIndicatives.getValue() + " checkmark").isDisplayed();
                break;
            case MI:
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
}

