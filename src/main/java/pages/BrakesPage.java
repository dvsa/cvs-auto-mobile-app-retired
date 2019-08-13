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

    public WebElement getBrakeActuatorForAxle(String axle) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                WebElement brakeActuator = webElementList.get(webElementList.indexOf(element)+1);
                return brakeActuator.getAttribute("name").equals("Brake actuator")? brakeActuator:null;
            }
        }
        return null;
    }

    public WebElement getLeverLengthForAxle(String axle) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                WebElement leverLength = webElementList.get(webElementList.indexOf(element)+2);
                return leverLength.getAttribute("name").equals("Lever length")? leverLength:null;
            }
        }
        return null;
    }

    public WebElement getSpringBrakeParkingForAxle(String axle) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                WebElement springBrakeParking = webElementList.get(webElementList.indexOf(element)+3);
                return springBrakeParking.getAttribute("name").equals("Spring brake parking")? springBrakeParking:null;
            }
        }
        return null;
    }

    public WebElement getLoadSensingValve() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("Load sensing valve")){
                return element;
            }
        }
        return null;
    }

        public WebElement getAntilockBrakingSystem() {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals("Antilock braking system")){
                return element;
            }
        }
        return null;
    }


}
