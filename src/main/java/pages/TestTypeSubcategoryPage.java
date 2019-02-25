package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestTypeSubcategoryPage extends BasePage {
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";
    private static final String BACK_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'arrow back')]";


    public void waitUntilPageIsLoaded(String testTypeSubcategory) {
        waitUntilNumberOfElementsToBe(By.id(testTypeSubcategory), 1);
    }

    public boolean isPageTitleDisplayed(String testTypeSubcategory) {
        boolean status = false;
        if(findElementById(testTypeSubcategory).isDisplayed())
            status = true;
        return status;
    }

    public List<String> findAllTestTypesFromListByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }

        return listOfData;
    }

    public void selectTestTypeFromListByXpath(String testType) {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        for (WebElement webElement : webElementList) {
            if(webElement.getAttribute("name").equalsIgnoreCase(testType)) {
                webElement.click();
                break;
            }
        }

    }

    public void selectBack() {
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }
}
