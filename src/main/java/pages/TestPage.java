package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestPage extends BasePage {

    private static final String SELECT_PREPARER_PAGE_TITLE = "Test";
    private static final String ADD_TEST_TYPE_BUTTON_ID = "Add a test type add circle-outline";
    private static final String PAGE_ALL_BUTTONS_XPATH = "//XCUIElementTypeButton";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    public void addTestType() {
        findElementById(ADD_TEST_TYPE_BUTTON_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
            if(findElementById(SELECT_PREPARER_PAGE_TITLE).isDisplayed())
                status = true;
        return status;
    }

    public boolean isVehicleRegistrationPlateDisplayed(String regPlate) {
        boolean status = false;
        if(findElementByXpath("//XCUIElementTypeStaticText[@name='" + regPlate + "']").isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isAddATestTypeButtonDisplayed() {
        boolean status = false;
        if(findElementById(ADD_TEST_TYPE_BUTTON_ID).isDisplayed())
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
}
