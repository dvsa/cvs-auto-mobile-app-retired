package pages;


import org.openqa.selenium.WebElement;

public class TestTypePage extends BasePage {

    private static final String VEHICLE_DETAILS = "Vehicle details";
    private static final String ADD_DEFECT_ID = "Add defect add circle-outline";


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

}
