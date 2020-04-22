package pages;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.WebElement;

import javax.management.DynamicMBean;
import java.util.ArrayList;
import java.util.List;

public class AdditionalVehicleDetailsPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";
    private static final String PAGE_TITLE_ID = "Additional details";
    private static final String PAGE_ALL_TEXT_CLASS_NAME = "XCUIElementTypeStaticText";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean elementFromListIsDisplayed(String element) {
        try {
            return findElementById(element).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
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

    public WebElement getDetailValue(String detail) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(detail)){
                return webElementList.get(webElementList.indexOf(element)+1);
            }
        }
        return null;
    }

    public WebElement getDetailAxleMinValue(String axle) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                return webElementList.get(webElementList.indexOf(element)+2);
            }
        }
        return null;
    }

    public WebElement getDetailAxleMaxValue(String axle) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                return webElementList.get(webElementList.indexOf(element)+4);
            }
        }
        return null;
    }

    public WebElement getNotes() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("NOTES")){
                return webElementList.get(webElementList.indexOf(element)+1);
            }
        }
        return null;
    }

    public WebElement getVehicleType() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("Vehicle Type")){
                return webElementList.get(webElementList.indexOf(element)+1);
            }
        }
        return null;
    }


    public WebElement getCountryOfRegistration() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("Country of registration")){
                return webElementList.get(webElementList.indexOf(element)+1);
            }
        }
        return null;
    }

    public boolean isEuVehicleCategory() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("EU Vehicle Category")){
                return true;
            }
        }
        return false;
    }

    public WebElement getMinOfElement(String detailName) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(detailName)){
                try{
                    return webElementList.get(webElementList.indexOf(element)+2);
                }
                catch (ElementNotFoundException e){
                    return null;
                }

            }
        }
        return null;
    }

    public WebElement getMaxOfElement(String detailName) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(detailName)){
                try{
                    return webElementList.get(webElementList.indexOf(element)+4);
                }
                catch (ElementNotFoundException e){
                    return null;
                }

            }
        }
        return null;
    }

    public boolean isDetailDisplayed(String notes) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(notes)){
                return true;
            }
        }
        return false;
    }
}
