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
    private static final String PAGE_ALL_BUTTONS_XPATH = "//XCUIElementTypeButton";
    private static final String ADD_LINKED_TEST_TYPE_BUTTON_ID = "Add a linked test add circle-outline";
    private static final String REVIEW_AND_CONFIRM_BUTTON_ID = "Review & Confirm";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String CANCEL_BUTTON_BOTTOM_RIGHT = "Cancel";

    private static final String CANCEL_ID = "Cancel";
    private static final String REMOVE_ID = "Remove";
    private static final String DESCRIPTION_ID = "This action will remove this test from the vehicle.";
    private static final String TITLE_ID = "Remove test";
    private static final String ABANDON_BUTTON_ID = "Abandon";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void addTestType() {
        findElementById(ADD_TEST_TYPE_BUTTON_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(SELECT_PREPARER_PAGE_TITLE).isDisplayed();
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate) {
        return findElementByXpath("//XCUIElementTypeButton[@name='" + regPlate + " (PSV) 1B7GG36N12S678410 Details arrow forward']").isDisplayed();
    }

    public boolean isAddATestTypeButtonDisplayed() {
        return findElementById(ADD_TEST_TYPE_BUTTON_ID).isDisplayed();
    }

    public List<String> findAllTestTypesFromListByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_BUTTONS_XPATH);
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
}
