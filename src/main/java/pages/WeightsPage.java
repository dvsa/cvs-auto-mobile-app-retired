package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightsPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";
    private static final String PAGE_TITLE_ID = "Weights";
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

    public HashMap<String, String> getDataSetCategory(String category) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        HashMap<String, String> mapOfData = new HashMap<>();
        for (WebElement webElement : webElementList) {
            String elementName = webElement.getAttribute("name");
            if(elementName.equals(category)){
                logger.info("Category: " + category);
                String gbValue;
                String designValue;
                try {
                    gbValue = webElementList.get(webElementList.indexOf(webElement) + 2).getAttribute("name");
                    logger.info("gbValue: " + gbValue);
                }
                catch (IndexOutOfBoundsException e){
                    gbValue = null;
                    logger.info("I was here");
                }

                try {
                    designValue = webElementList.get(webElementList.indexOf(webElement) +4).getAttribute("name");
                    logger.info("designValue: " + designValue);
                }
                catch (IndexOutOfBoundsException e){
                    designValue = null;
                    logger.info("I was here as well");
                }
                mapOfData.put("GB" , isNumeric(gbValue) ? gbValue : "0");
                mapOfData.put("Design" , isNumeric(designValue) ? designValue : "0");
            }
        }
        logger.info("All mapped data: " + mapOfData.values());
        return mapOfData;
    }

    public void clickOnBack() {
        findElementById(BACK_BUTTON_ID).click();
    }

    public boolean isFieldListed(String fieldName) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element: webElementList){
            if(element.getAttribute("name").equals(fieldName)){
                return true;
            }
        }
        return false;
    }

    public String getFieldValue(String fieldName) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for (WebElement element : webElementList) {
            if (element.getAttribute("name").equals(fieldName)) {
                try {
                    return webElementList.get(webElementList.indexOf(element) + 1).getAttribute("name");
                } catch (NoSuchElementException e) {
                    return null;
                }
            }
        }
        return null;
    }

    public String getGrossGb() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element: webElementList){
            if(element.getAttribute("name").equals("GROSS")){
                return webElementList.get(webElementList.indexOf(element) + 1).getAttribute("name");
            }
        }
        return null;
    }

    public String getGrossDesign() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element: webElementList){
            if(element.getAttribute("name").equals("GROSS")){
                return webElementList.get(webElementList.indexOf(element) + 2).getAttribute("name");
            }
        }
        return null;
    }
}
