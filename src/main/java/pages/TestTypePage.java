package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTypePage extends BasePage {

    private static final String VEHICLE_DETAILS = "Vehicle details";
    private static final String ADD_DEFECT_ID = "Add defect";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String POP_UP_CANCEL_ID = "Cancel";
    private static final String POP_UP_REMOVE_ID = "Remove";
    private static final String POP_UP_TEXT_ID = "This action wil remove this defect.";
    private static final String POP_UP_TITLE_ID = "Remove defect";


    public int checkResultIsPresent(String result) {
        return findElementsByXpath("//*[@name='" + result + "']").size();
    }

    public WebElement checkVehicleDetailsIsPresent() {
        return findElementById(VEHICLE_DETAILS);
    }


    public WebElement getAddDefectElement() {
        return findElementById(ADD_DEFECT_ID);
    }


    public void waitUntilPageIsLoaded(String testName) {
        waitUntilPageIsLoadedByXpath("//*[@name='" + testName + "']");
    }

    public WebElement checkDefectIsPresent(String defect) {
        return findElementByXpath("//*[contains(@label, '" + defect + "')]");
    }


    public List<WebElement> checkElementIsNotPresent(String item) {
        return findElementsByXpath("//*[@name='" + item + "']");
    }

    public boolean isDefectVisible(String defect) {
        WebElement defectElement = null;
        try {
            defectElement = findElementById(defect);
        } catch (Exception e) {
        }
        if (defectElement != null) {
            return defectElement.isDisplayed();
        } else
            return false;
    }

    public WebElement getElementById(String id) {
        return findElementById(id);
    }

    public WebElement getElementByLabel(String label) {
        return findElementByXpath("//*[@label='" + label + "']");
    }

    public int getPRMSLabels() {
        return findElementsByXpath("//*[@label='PRS']").size();
    }

    public void clickOnDefect(String recordDefect, String defectItem) {
        if(checkDefectIsPresent(defectItem) != null) {
            findElementByXpath("//*[contains(@label, '" + recordDefect + "')]").click();
        }
    }

    public void swipeLeftOnDefect(String defectId) {
        WebElement defectToSwipe = findElementById(defectId);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "left");
        params.put("element", ((RemoteWebElement) defectToSwipe).getId());
        js.executeScript("mobile: swipe", params);
    }

    public void clickOnRemoveButton() {
        findElementById(REMOVE_BUTTON_ID).click();
    }

    public boolean isDefectRemovalPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(POP_UP_CANCEL_ID);
        WebElement removeButton = findElementById(POP_UP_REMOVE_ID);
        WebElement text = findElementById(POP_UP_TEXT_ID);
        WebElement title = findElementById(POP_UP_TITLE_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickRemoveInPopUp() {
        findElementById(POP_UP_REMOVE_ID).click();
    }

    public void clickCancelInPopUp() {
        findElementById(POP_UP_CANCEL_ID).click();
    }
}
