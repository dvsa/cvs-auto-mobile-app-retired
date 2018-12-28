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
    private static final String REVIEW_AND_CONFIRM_BUTTON_ID = "Review & Confirm";
    private static final String REMOVE_BUTTON_ID = "Remove";

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
        boolean status = false;
        if (findElementById(SELECT_PREPARER_PAGE_TITLE).isDisplayed())
            status = true;
        return status;
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate) {
        boolean status = false;
        if (findElementByXpath("//XCUIElementTypeStaticText[@name='" + regPlate + "']").isDisplayed()) {
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

    public void clickOnTest(String testName) {
        findElementById(testName + " Not complete").click();
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
}
