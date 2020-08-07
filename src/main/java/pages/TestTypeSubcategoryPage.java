package pages;

import exceptions.AutomationException;
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
        listOfData.remove(0);
        return listOfData;
    }

    public void selectTestTypeFromListByXpath(String testType) {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        int i = 0;
        for (WebElement webElement : webElementList) {
            if(webElement.getAttribute("name").equalsIgnoreCase(testType)) {
                webElement.click();
                break;
            }
            i++;
            if (i == webElementList.size()) {
                throw new AutomationException("The " + testType + " test type is not present in the page");
            }
        }


    }

    public List<WebElement> findAllTestTypesWebElements() {
        return findElementsByXpath(PAGE_ALL_TEXT_XPATH);
    }

    public void selectBack() {
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }
}
