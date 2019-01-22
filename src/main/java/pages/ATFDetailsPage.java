package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ATFDetailsPage extends BasePage {

    private static final String START_VISIT_ID = "Start visit";
    private static final String YES_ID = "Yes";
    private static final String PAGE_ALL_TEXT_XPATH = "//XCUIElementTypeStaticText";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(START_VISIT_ID);
    }

    public void clickStartVisit() {
        findElementById(START_VISIT_ID).click();
    }

    public void selectYes() {
        findElementById(YES_ID).click();
    }

    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(PAGE_ALL_TEXT_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("value"));
        }

        return listOfData;
    }
}
