package pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectVehiclePage extends BasePage {

    private static final String SELECT_VEHICLE_PAGE_TITLE = "Select Vehicle";
    private static final String MULTIPLE_VEHICLES_FOUND_XPATH = "(//XCUIElementTypeStaticText[@name='Multiple vehicles found matching this search'])";
    private static final String BACK_BUTTON_XPATH = "(//XCUIElementTypeButton[@name='arrow back Identify vehicle'])";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_VEHICLE_PAGE_TITLE);
    }

    public void isMultipleVehiclesDisplayed(){
        findElementByXpath(MULTIPLE_VEHICLES_FOUND_XPATH).isDisplayed();
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if (findElementById(SELECT_VEHICLE_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public String getBackCtaText() {
        return findElementByXpath(BACK_BUTTON_XPATH).getText();
    }

    public boolean isBackCtaDisplayed() {
        return findElementByXpath(BACK_BUTTON_XPATH).isDisplayed();
    }

    public void clickBackCta(){
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public boolean isVehicleDetailsPresent(String make, String year, String model){
        String searchString = make+" "+year+","+" "+model;
        boolean status = false;
        if(findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").isDisplayed()){
            status = true;
        }
        return status;
    }

    public void clickOnVehicle(String make, String year, String model){
        String searchString = make+" "+year+","+" "+model;
        findElementByXpath("//XCUIElementTypeButton[@name=\""+searchString+"\"]").click();
    }
}

