package pages;

import org.joda.time.LocalDateTime;
import org.openqa.selenium.*;

import java.text.DateFormatSymbols;

public class TestTypeDetailsPage extends BasePage {

    private static final String TEST_DETAILS_PAGE_TITLE_ID = "Test type details";
    private static final String CARRIED_OUT_YES_OPTION_ID = "Yes";
    private static final String CARRIED_OUT_NO_OPTION_ID = "No";
    private static final String CARRIED_OUT_CANCEL_OPTION_ID = "Cancel";
    private static final String SEATBEALT_INSTALLATION_CHECK_INPUT_FIELD = "//XCUIElementTypeTextField";
    private static final String SEATBEALT_INSTALLATION_CHECK_DONE_BUTTON_ID = "Done";
    private static final String SEATBEALT_INSTALLATION_CHECK_CANCELED_BUTTON_ID = "Cancel";
    private static final String MOST_RECENT_INSTALLATION_CHECK_DONE_BUTTON_ID = "Done";
    private static final String MOST_RECENT_INSTALLATION_CHECK_CANCEL_BUTTON_ID = "Cancel";
    private static final String SEATBELT_TITLE_ID = "Seatbelt installation check";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String TEST_RESULT_ID = "Test result Select arrow forward";
    private static final String SET_LEC_TEST_TO_PASS_ID = "Pass";
    private static final String SET_LEC_TEST_TO_FAIL_ID = "Fail";
    private static final String CANCEL_LEC_TEST_ID = "Cancel";
    private static final String CERTIFICATE_NUMBER_LABEL_ID = "CERTIFICATE NUMBER";
    private static final String LP_LABEL_ID = "LP";
    private static final String CERTIFICATE_NUMBER_INPUT_FIELD_XPATH = "//XCUIElementTypeTextField";
    private static final String TECHNICAL_TEST_EDIT_ID = "Technical test Edit checkmark";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_DETAILS_PAGE_TITLE_ID);
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

    public void selectIsCarriedOut() {
        findElementById(CARRIED_OUT_YES_OPTION_ID).click();
    }

    public void selectIsNotCarriedOut() {
        findElementById(CARRIED_OUT_NO_OPTION_ID).click();
    }

    public void cancelIsCarriedOut() {
        findElementById(CARRIED_OUT_CANCEL_OPTION_ID).click();
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
        LocalDateTime ldt = LocalDateTime.now();
        Integer dayOfSystem = ldt.getDayOfMonth() + 1;
        int monthOfSystem = ldt.getMonthOfYear();
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

    public boolean isTestTypeDetailsTitleDisplayed() {
        return findElementById(TEST_DETAILS_PAGE_TITLE_ID).isDisplayed();
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
        findElementById(TEST_DETAILS_PAGE_TITLE_ID).click();
        return findElementByXpath(CERTIFICATE_NUMBER_INPUT_FIELD_XPATH).getText();
    }
}
