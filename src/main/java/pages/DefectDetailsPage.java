package pages;

import org.openqa.selenium.WebElement;

public class DefectDetailsPage extends BasePage {

    private static final String DEFECT_DETAILS_PAGE_ID = "Defect details";
    private static final String DEFECT_ITEM_LABEL_ID = "DEFECT ITEM";
    private static final String LOCATION_LABEL_ID = "LOCATION";
    private static final String NOTES_LABEL_ID = "NOTES";
    private static final String PASSED_AFTER_RECTIFICATION_AT_STATION_LABEL_ID = "PRS";
    private static final String SELECT_OPTION = "Select";
    private static final String ADDITIONAL_INFORMATION_VERTICAL = "Vertical";
    private static final String ADDITIONAL_INFORMATION_LATERAL = "Lateral";
    private static final String ADDITIONAL_INFORMATION_ROW_NUMBER = "Row Number";
    private static final String ADDITIONAL_INFORMATION_SEAT_NUMBER = "Seat Number";
    private static final String ADD_DEFECT_BUTTON_ID = "Add Defect";
    private static final String DONE_BUTTON_ID = "Done";
    private static final String PRS_ENABLE = "Defect repaired during test";
    private static final String ADD_NOTES = "Add notes";
    private static final String BACK_BUTTON_ID = "arrow back Back";

    public WebElement getDefectLabel() {
        return findElementById(DEFECT_ITEM_LABEL_ID);
    }

    public WebElement getLocationLabel() {
        return findElementById(LOCATION_LABEL_ID);
    }

    public WebElement getNotesLabel() {
        return findElementById(NOTES_LABEL_ID);
    }

    public WebElement getPRSLabel() {
        return findElementById(PASSED_AFTER_RECTIFICATION_AT_STATION_LABEL_ID);
    }

    public WebElement getVertical() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_VERTICAL + "']").get(1);
    }

    public WebElement getLateral() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_LATERAL + "']").get(1);
    }

    public WebElement getRowNumber() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_ROW_NUMBER + "']").get(1);
    }

    public WebElement getSeatNumber() {
        return findElementsByXpath("//*[@label='" + ADDITIONAL_INFORMATION_SEAT_NUMBER + "']").get(1);
    }

    public int getSelectOptionElementNumber() {
        return findElementsByXpath("//*[@label='" + SELECT_OPTION + "']").size();
    }

    public WebElement getElementById(String id) {
        return findElementById(id);
    }

    public WebElement getElementByLabel(String label) {
        return findElementByXpath("//*[@label='" + label + "']");
    }

    public void selectVerticalValue(String id) {
        getVertical().click();
        findElementById(id).click();
    }

    public void selectLateralValue(String id) {
        getLateral().click();
        findElementById(id).click();
    }

    public void selectRowNumberValue(String id) {
        getRowNumber().click();
        findElementById(id).click();
    }

    public void selectSeatNumberValue(String id) {
        getSeatNumber().click();
        findElementById(id).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(DEFECT_DETAILS_PAGE_ID);
    }

    public void clickAddDefect() {
        findElementById(ADD_DEFECT_BUTTON_ID).click();
    }

    public void clickDone() {
        findElementById(DONE_BUTTON_ID).click();
    }

    public void enablePRS() {
        tap(findElementsByXpath("//*[@label='" + PRS_ENABLE + "']").get(1));
    }

    public int getPRSElementNumber() {
        return findElementsByXpath("//*[@label='PRS']").size();
    }

    public void sendNotes(String data) {
        findElementByXpath("//*[@value='" + ADD_NOTES + "']").sendKeys(data);
    }

    public int checkIfTextIsPresent(String data) {
        return findElementsByXpath("//*[@value='" + data + "']").size();
    }

    public void clickBack() {
        findElementByAccessibilityIdId(BACK_BUTTON_ID).click();
    }
}
