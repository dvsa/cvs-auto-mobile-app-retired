package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import util.EnvironmentType;
import util.LoaderlLocalRealDeviceImpl;
import util.TypeLoader;

import java.text.DateFormatSymbols;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTypeDetailsPage extends BasePage {

    private static final String TEST_TYPE_DETAILS = "Test type details";
    private static final String CARRIED_OUT_YES_OPTION_ID = "Yes";
    private static final String CARRIED_OUT_NO_OPTION_ID = "No";
    private static final String CARRIED_OUT_CANCEL_OPTION_ID = "Cancel";
    private static final String SEATBEALT_INSTALLATION_CHECK_INPUT_FIELD = "//XCUIElementTypeTextField";
    private static final String SEATBEALT_INSTALLATION_CHECK_DONE_BUTTON_ID = "Done";
    private static final String SEATBEALT_INSTALLATION_CHECK_CANCELED_BUTTON_ID = "Cancel";
    private static final String MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID = "Done";
    private static final String MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID = "Cancel";
    private static final String SEATBELT_TITLE_ID = "SEATBELT INSTALLATION CHECK";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String TEST_RESULT_ID = "Test result Select arrow forward";
    private static final String SET_LEC_TEST_TO_PASS_ID = "Pass";
    private static final String SET_LEC_TEST_TO_FAIL_ID = "Fail";
    private static final String CANCEL_LEC_TEST_ID = "Cancel";
    private static final String CERTIFICATE_NUMBER_LABEL_ID = "CERTIFICATE NUMBER";
    private static final String LP_LABEL_ID = "LP";
    private static final String CERTIFICATE_NUMBER_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String TECHNICAL_TEST_EDIT_ID = "Technical test Edit checkmark";
    private static final String CERTIFICATE_NUMBER_GUIDANCE_ID = "After conducting the test, complete the Low Emissions Certificate and enter the certificate number.";
    private static final String NOTES_INPUT_FIELD_CLASS_NAME = "XCUIElementTypeTextView";
    private static final String ADD_DEFECT_ID = "Add defect";
    private static final String REMOVE_BUTTON_ID = "Remove";
    private static final String POP_UP_CANCEL_ID = "Cancel";
    private static final String POP_UP_REMOVE_XPATH = "(//XCUIElementTypeButton[@name='Remove'])[2]";
    private static final String POP_UP_TEXT_ID = "This action will remove this defect.";
    private static final String POP_UP_TITLE_ID = "Remove defect";
    private static final String ABANDON_TEST_TYPE="Abandon test type";
    private static final String REMOVE_TEST_TYPE="Remove test type";
    private static final String POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID = "Cancel";
    private static final String POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID = "Remove";
    private static final String POP_UP_TEST_TYOE_REMOVAL_TEXT_ID = "This action will remove this test type from the vehicle.";
    private static final String POP_UP_TEST_TYPE_REMOVAL_TITLE_XPATH = "//XCUIElementTypeStaticText[@name=\"Remove test type\"]";

    public int checkResultIsPresent(String result) {
        return findElementsByXpath("//*[@name='" + result + "']").size();
    }

    public WebElement getTestTypeDetails() {
        return findElementById(TEST_TYPE_DETAILS);
    }

    public WebElement getAddDefectElement() {
        return findElementById(ADD_DEFECT_ID);
    }


    public void waitUntilPageIsLoadedByTestType(String testName) {
        waitUntilPageIsLoadedByXpath("//*[@name='" + testName + "']");
    }

    public WebElement checkDefectIsPresent(String defect) {
        return findElementByXpath("//*[contains(@label, '" + defect + "')]");
    }


    public List<WebElement> checkElementIsNotPresent(String item) {
        return findElementsByXpath("//*[@name='" + item + "']");
    }

    public boolean isDefectVisible(String defect) {
        try {
            return findElementById(defect).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
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
        if (checkDefectIsPresent(defectItem) != null) {
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
        WebElement removeButton = findElementByXpath(POP_UP_REMOVE_XPATH);
        WebElement text = findElementById(POP_UP_TEXT_ID);
        WebElement title = findElementById(POP_UP_TITLE_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isTestTypeRemovalPopUpVisible() {
        boolean status = false;
        WebElement cancelButton = findElementById(POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID);
        WebElement removeButton = findElementById(POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID);
        WebElement text = findElementByXpath(POP_UP_TEST_TYPE_REMOVAL_TITLE_XPATH);
        WebElement title = findElementById(POP_UP_TEST_TYOE_REMOVAL_TEXT_ID);
        if (cancelButton.isDisplayed() && removeButton.isDisplayed() && text.isDisplayed() && title.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public void clickRemoveInPopUp() {
        findElementByXpath(POP_UP_REMOVE_XPATH).click();
    }

    public void clickCancelInTestTypePopUp() {
        findElementById(POP_UP_TEST_TYPE_REMOVAL_CANCEL_ID).click();
    }

    public void clickRemoveInTestTypePopUp() {
        findElementById(POP_UP_TEST_TYPE_REMOVAL_REMOVE_ID).click();
    }

    public void clickCancelInPopUp() {
        findElementById(POP_UP_CANCEL_ID).click();
    }

    private static final String NO_SEATBELTS_ENTERED_POP_UP_TITLE_XPATH = "//XCUIElementTypeStaticText[@name=\"No seatbelts entered\"]";
    private static final String NO_SEATBELTS_ENTERED_POP_UP_MESSAGE_XPATH = "//XCUIElementTypeStaticText[@name=\"The number of seatbelts fitted must be greater than zero (0) to carry out an installation check.\"]";
    private static final String NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH = "//XCUIElementTypeButton[@name=\"OK\"]";

    public boolean checkSeatbeltPopUpTitle() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_TITLE_XPATH).isDisplayed();
    }

    public boolean checkSeatbeltPopUpMessage() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_MESSAGE_XPATH).isDisplayed();
    }

    public boolean checkSeatbeltPopUpOkButton() {
        return findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH).isDisplayed();
    }

    public void clickOkButtonForSeatbeltPopUp() {
        findElementByXpath(NO_SEATBELTS_ENTERED_POP_UP_OK_BUTTON_XPATH).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_TYPE_DETAILS);
    }

    public void clickSaveButton() {
        findElementById(SAVE_BUTTON_ID).click();
    }

    public void clickTechnicalTestEdited() {
        findElementById(TECHNICAL_TEST_EDIT_ID).click();
    }

    public void selectCarriedOutOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Carried out during this test')]").click();
    }

    public boolean checkIsCarriedOutValue(String yesOrNo) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Carried out during this test " + yesOrNo + " arrow forward')]").isDisplayed();
    }

    public boolean checkIsCarriedOutDisplayed() {
        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Carried out during this test')]").isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void selectIsCarriedOut() {
        findElementById(CARRIED_OUT_YES_OPTION_ID).click();
    }

    public void selectIsNotCarriedOut() {
        findElementById(CARRIED_OUT_NO_OPTION_ID).click();
    }

    public void cancelIsCarriedOut() {
        findElementById(CARRIED_OUT_CANCEL_OPTION_ID).click();
    }

    public boolean isCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_YES_OPTION_ID).isDisplayed();
    }

    public boolean isNotCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_NO_OPTION_ID).isDisplayed();
    }

    public boolean isCancelCarriedOutDisplayed() {
        return findElementById(CARRIED_OUT_CANCEL_OPTION_ID).isDisplayed();
    }

    public void selectSeatbeltsNumberOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Number of seatbelts fitted')]").click();
    }

    public void setSetbealtNumber(String seatbeltNumber) {
        WebElement input = findElementByXpath(SEATBEALT_INSTALLATION_CHECK_INPUT_FIELD);
        input.clear();
        input.sendKeys(seatbeltNumber);
    }

    public void doneSeatbeltInstallationCheck() {
        findElementById(SEATBEALT_INSTALLATION_CHECK_DONE_BUTTON_ID).click();
    }

    public boolean isCancelOptionDisplayedForSeatbeltNumber() {
        return findElementById(SEATBEALT_INSTALLATION_CHECK_CANCELED_BUTTON_ID).isDisplayed();
    }

    public boolean isDoneOptionDisplayedForSeatbeltNumber() {
        return findElementById(SEATBEALT_INSTALLATION_CHECK_DONE_BUTTON_ID).isDisplayed();
    }

    public boolean checkSetbealtNumber(String seatbeltNumber) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Number of seatbelts fitted " + seatbeltNumber + "')]").isDisplayed();
    }

    public boolean isSeatbeltTitleDisplayed() {
        return findElementById(SEATBELT_TITLE_ID).isDisplayed();
    }

    public boolean isSeatbetlInputFieldDisplayed() {
        return findElementById(SEATBEALT_INSTALLATION_CHECK_INPUT_FIELD).isDisplayed();
    }

    public void cancelSeatbeltInstallationCheck() {
        findElementById(SEATBEALT_INSTALLATION_CHECK_CANCELED_BUTTON_ID).click();
    }

    public void selectRecentInstallationCheckOption() {
        findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check')]").click();
    }

    public void cancelMostRecentInstallationCheck() {
        findElementById(MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID).click();
    }

    public void doneMostRecentInstallationCheck() {
        findElementById(MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID).click();
    }

    public void setRecentInstallationDateCheckOneUnit() {
        findElementByXpath("//XCUIElementTypeOther[@name=\"web dialog\"]/XCUIElementTypeOther[3]").click();
        scrollOneDayDown();
        scrollOneMonthDown();
        scrollOneYearDown();
        doneMostRecentInstallationCheck();
    }

    public boolean verifyMostRecentInstallationDate() {
        EnvironmentType envType = TypeLoader.getType();
        LocalDateTime ldt;
        switch (envType) {
            case LOCAL_SIMULATOR:
                ldt = LocalDateTime.now();
                break;
            case LOCAL_REAL_DEVICE:
                ldt = LocalDateTime.now(ZoneId.of(LoaderlLocalRealDeviceImpl.getTimezone()));
                break;
            default:
                ldt = LocalDateTime.now(Clock.systemUTC());
                break;
        }

        Integer dayOfSystem = ldt.getDayOfMonth() + 1;
        int monthOfSystem = ldt.getMonthValue();
        Integer yearOfSystem = ldt.getYear() - 1;

        String day = dayOfSystem.toString();
        String month = new DateFormatSymbols().getMonths()[monthOfSystem].substring(0, 3);
        String year = yearOfSystem.toString();

        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check " + day + " " + month + " " + year + "')]");
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isMostInstallationCheckButtonDisplayed() {
        try {
            findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Most recent installation check')]");
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDateCalendarPickerDisplayed() {
        return findElementByXpath("//XCUIElementTypeOther[@name=\"web dialog\"]/XCUIElementTypeOther[3]").isDisplayed();
    }

    public boolean isCancelOptionDisplayedForDatePicker() {
        return findElementById(MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID).isDisplayed();
    }

    public boolean isDoneOptionDisplayedForDatePicker() {
        return findElementById(MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID).isDisplayed();
    }

    public boolean isTestTypeDetailsTitleDisplayed() {
        return findElementById(TEST_TYPE_DETAILS).isDisplayed();
    }

    public void scrollOneDayDown() {
        scroll(95, 594, 95, 580);
    }

    public void scrollOneMonthDown() {
        scroll(178, 594, 178, 580);
    }

    public void scrollOneYearDown() {
        scroll(243, 594, 243, 580);
    }

    public void clickSave() {
        findElementById(SAVE_BUTTON_ID).click();
    }

    public void clickSetTestResul() {
        findElementById(TEST_RESULT_ID).click();
    }

    public void passLecTest() {
        findElementById(SET_LEC_TEST_TO_PASS_ID).click();
    }

    public void failLecTest() {
        findElementById(SET_LEC_TEST_TO_FAIL_ID).click();
    }

    public void cancelLecTest() {
        findElementById(CANCEL_LEC_TEST_ID).click();
    }

    public boolean checkPassTestOptionIsPresent() {
        return findElementById(SET_LEC_TEST_TO_PASS_ID).isDisplayed();
    }

    public boolean checkFailTestOptionIsPresent() {
        return findElementById(SET_LEC_TEST_TO_FAIL_ID).isDisplayed();
    }

    public boolean checkTestStatus(String status) {
        return findElementById("Test result " + status).isDisplayed();
    }

    public void clickPassedTest() {
        findElementById("Test result Pass").click();
    }

    public boolean checkCancelTestOptionIsPresent() {
        return findElementById(CANCEL_LEC_TEST_ID).isDisplayed();
    }

    public boolean checkLPLabelIsPresent() {
        return findElementById(LP_LABEL_ID).isDisplayed();
    }

    public boolean checkCertificateNumberInputFIedIsPresent() {
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).isDisplayed();
    }

    public boolean checkCertificateNumberLabelIsPresent() {
        return findElementById(CERTIFICATE_NUMBER_LABEL_ID).isDisplayed();
    }

    public void sendCertificateNumber(String certificateNumber) {
        WebElement inputField = findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH);
        inputField.clear();
        inputField.sendKeys(certificateNumber);
        clickSaveButton();
    }

    public String getCertificateNumber() {
        clickTechnicalTestEdited();
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).getText();
    }

    public String cancelInputCertificateNumber() {
        findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).click();
        findElementById(TEST_TYPE_DETAILS).click();
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).getText();
    }

    public boolean isCertificateGuidanceDisplayed() {
        return findElementById(CERTIFICATE_NUMBER_GUIDANCE_ID).isDisplayed();
    }

    public void clickNotes() {
        findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME).click();
    }

    public void typeIntoNotesField(String text) {
        WebElement inputField = findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public boolean isTextDisplayedInNotes(String text) {
        return findElementByClassName(NOTES_INPUT_FIELD_CLASS_NAME).getAttribute("value").contains(text);
    }

    public void clickAddDefectButton() {
        findElementById(ADD_DEFECT_ID).click();
    }

    public void scrollDetailPage() {
        scrollDownTo(500, -100);
    }

    public void pressTestTypeAbandonButton(){
        findElementById(ABANDON_TEST_TYPE).click();
    }

    public void pressTestTypeRemoveButton(){
        findElementById(REMOVE_TEST_TYPE).click();
    }
}

