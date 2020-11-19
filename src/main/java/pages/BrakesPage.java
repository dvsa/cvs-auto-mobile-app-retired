package pages;

import com.gargoylesoftware.htmlunit.html.DomNode;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrakesPage extends BasePage {

    private static final String BACK_BUTTON_ID = "arrow back Vehicle details";
    private static final String PAGE_TITLE_ID = "Brakes";
    private static final String PAGE_ALL_TEXT_CLASS_NAME = "XCUIElementTypeStaticText";

    // Offsets for field location, relative to each axle.
    private static final int OFFSET_BRAKE_ACTUATOR = 1;
    private static final int OFFSET_LEVER_LENGTH = 3;
    private static final int OFFSET_SPRING_BRAKE_PARKING = 5;

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
        return getAttributeForAxle(axle, OFFSET_BRAKE_ACTUATOR);
    }

    public WebElement getLeverLengthForAxle(String axle) {
        return getAttributeForAxle(axle, OFFSET_LEVER_LENGTH);
    }

    public WebElement getSpringBrakeParkingForAxle(String axle) {
        return getAttributeForAxle(axle, OFFSET_SPRING_BRAKE_PARKING);
    }

    private WebElement getAttributeForAxle(String axle, int fieldOffset) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);

        // Verify the expected field name.
        String expectedName = "";
        switch (fieldOffset) {
            case OFFSET_BRAKE_ACTUATOR:
                expectedName = "Brake actuator";
                break;
            case OFFSET_LEVER_LENGTH:
                expectedName = "Lever length";
                break;
            case OFFSET_SPRING_BRAKE_PARKING:
                expectedName = "Spring brake parking";
                break;
        }

        // Get the correct field value, which is relative to the supplied axle.
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(axle)){
                WebElement springBrakeParking = webElementList.get(webElementList.indexOf(element)+fieldOffset);
                logger.info("Searching for attribute '" + expectedName + "' for axle: " + axle);

                String foundName = springBrakeParking.getAttribute("name");
                logger.info("Found: " + foundName);
                assert (foundName.equals(expectedName));

                return springBrakeParking;
            }
        }
        logger.info("- NOT found");
        return null;
    }

    public WebElement getLoadSensingValve() {
        return getBrakeAttribute("Load sensing valve");
    }

    public WebElement getAntilockBrakingSystem() {
        return getBrakeAttribute("Antilock braking system");
    }

    private WebElement getBrakeAttribute(String requiredAttribute) {

        logger.info("Searching for attribute: " + requiredAttribute);
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        for(WebElement element : webElementList){
            if(element.getAttribute("name").equals(requiredAttribute)) {
                logger.info("Found");
                return element;
            }
        }
        logger.info("- NOT found");
        return null;
    }
}
