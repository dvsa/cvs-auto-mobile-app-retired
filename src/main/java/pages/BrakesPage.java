package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrakesPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";
    private static final String PAGE_TITLE_ID = "Brakes";
    private static final String PAGE_ALL_TEXT_CLASS_NAME = "XCUIElementTypeStaticText";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public List<String> getDataSetBetweenTitles(String dataSetStartText, String dataSetEndText) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        List<String> listOfData = new ArrayList<>();
        boolean isInInterval = false;
        for (WebElement webElement : webElementList) {
            if (webElement.getAttribute("name").equalsIgnoreCase(dataSetStartText)){
                isInInterval = true;
            }
            if (isInInterval) {
                listOfData.add(webElement.getAttribute("value"));
            }
            if (webElement.getAttribute("name").equalsIgnoreCase(dataSetEndText)) {
                isInInterval = false;
            }
        }

        return listOfData;
    }

    public void clickOnBack() {
        findElementById(BACK_BUTTON_ID).click();
    }
}
