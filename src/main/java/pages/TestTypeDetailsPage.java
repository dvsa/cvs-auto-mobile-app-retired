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

    public void setRecentInstallationDateCheck() {
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
        System.out.println(day);
        String month = new DateFormatSymbols().getMonths()[monthOfSystem].substring(0, 3);
        System.out.println(month);
        String year = yearOfSystem.toString();
        System.out.println(year);

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
}
