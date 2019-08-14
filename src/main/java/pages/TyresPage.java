package pages;

import model.vehicles.Axles;
import model.vehicles.Weights;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TyresPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";
    private static final String PAGE_TITLE_ID = "Tyres";
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

    public List<WebElement> getAxleData(String axle){
        List<WebElement> webElements = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        int indexOfAxle;
        for(WebElement element : webElements){
            if(element.getAttribute("name").equals(axle)){
                indexOfAxle = webElements.indexOf(element);
                System.out.println("axle: " + axle);
        System.out.println("Data of " + axle + ": " + webElements.subList(indexOfAxle,indexOfAxle + 10));
        return webElements.subList(indexOfAxle+2,indexOfAxle + 11);
            }
        }
        return null;
    }

//    public String getAxleDetailValue(String axle, String detail){
//        List<WebElement> allDetails = getAxleData(axle);
//        return allDetails.get(allDetails.indexOf(detail)+1).getAttribute("name");
//    }

    public void clickOnBack() {
        findElementById(BACK_BUTTON_ID).click();
    }

    public WebElement getTyreUseCodeValue(){
        List<WebElement> webElements = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElements){
            if(element.getAttribute("name").equals("Tyre use code")){
                return webElements.get(webElements.indexOf(element)+1);
            }
        }
        return null;
    }

}
