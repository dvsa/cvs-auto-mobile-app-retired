package pages;

import org.joda.time.LocalDateTime;
import org.openqa.selenium.WebElement;

import java.text.DateFormatSymbols;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site Visit";
    private static final String CREATE_TEST_ID = "Create test";
    private static final String END_VISIT_ID = "End visit";
    private static final String OK_MODAL_ID = "OK";
    private static final String BUTTONS_CLASS_NAME = "XCUIElementTypeButton";
    private static final String END_VISIT_POP_UP_TITLE = "//XCUIElementTypeStaticText[@name='CVSMobile']";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(CREATE_TEST_ID);
    }

    public void clickCreateNewTest() {
        findElementById(CREATE_TEST_ID).click();
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE).isDisplayed();
    }

    public boolean isCanceledTestDisplayed(String registrationPlate) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'Test (" + registrationPlate + ") CANCELLED')]").isDisplayed();
    }


    public void clickEndVisit(){
        findElementByAccessibilityId(END_VISIT_ID).click();
    }

    public void clickOk() {
        waitUntilPageIsLoadedByAccessibilityId(OK_MODAL_ID).click();
    }

    public boolean isBackButtonAvailable() {
        boolean status = false;
        List<WebElement> listOfButtons = findElementsByClassName(BUTTONS_CLASS_NAME);
        for (WebElement button : listOfButtons) {
            if (button.getText().contains("arrow back")) {
                status = true;
                break;
            }
        }
        return status;
    }

    public boolean isCreateTestButtonDisplayed() {
        return findElementById(CREATE_TEST_ID).isDisplayed();
    }

    public boolean isEndVisitButtonDisplayed() {
        return findElementById(END_VISIT_ID).isDisplayed();
    }

    public boolean isAtfRowDisplayed(String atfName) {
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + atfName + " Started site visit')]").isDisplayed();
    }

    public boolean isCurrentDateDisplayed() {
        LocalDateTime ldt = LocalDateTime.now();

        Integer dayOfSystem = ldt.getDayOfMonth();
        int monthOfSystem = ldt.getMonthOfYear();
        Integer yearOfSystem = ldt.getYear();

        String day = dayOfSystem.toString();
        String month = new DateFormatSymbols().getMonths()[monthOfSystem - 1];
        String year = yearOfSystem.toString();

        return findElementByAccessibilityId(day + " " + month + " " + year).isDisplayed();
    }

    public boolean isCurrentTimeDisplayed() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        String systemTime = dateTimeFormatter.format(LocalTime.now());
        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + systemTime + "')]").isDisplayed();
    }

    public boolean isEndVisitPopUpDisplayed() {
        return findElementByXpath(END_VISIT_POP_UP_TITLE).isDisplayed() && findElementById(OK_MODAL_ID).isDisplayed();
    }
}
