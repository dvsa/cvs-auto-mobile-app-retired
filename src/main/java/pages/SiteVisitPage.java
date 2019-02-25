package pages;

import org.openqa.selenium.WebElement;
import util.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SiteVisitPage extends BasePage {

    private static final String PAGE_TITLE = "Site Visit";
    private static final String CREATE_TEST_ID = "Create test";
    private static final String END_VISIT_ID = "End visit";
    private static final String OK_MODAL_ID = "Confirm";
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        EnvironmentType envType = TypeLoader.getType();
        String clientSystemDate;
        switch (envType) {
            case LOCAL_SIMULATOR:
                clientSystemDate = dateTimeFormatter.format(LocalDateTime.now());
                break;

            case LOCAL_REAL_DEVICE:
                clientSystemDate = dateTimeFormatter.format(LocalDateTime.now(ZoneId.of(LoaderlLocalRealDeviceImpl.getTimezone())));
                break;
            default:
                clientSystemDate =dateTimeFormatter.format(LocalDateTime.now(Clock.systemUTC()));
                break;
        }
        return findElementByAccessibilityId(clientSystemDate).isDisplayed();
    }

    public boolean isCurrentTimeDisplayed() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h:mm a");
        EnvironmentType envType = TypeLoader.getType();
        String clientSystemTime;
        switch (envType) {
            case LOCAL_SIMULATOR:
                clientSystemTime = dateTimeFormatter.format(LocalDateTime.now());
                break;

            case LOCAL_REAL_DEVICE:
                clientSystemTime = dateTimeFormatter.format(LocalDateTime.now(ZoneId.of(LoaderlLocalRealDeviceImpl.getTimezone())));
                break;
            default:
                clientSystemTime =dateTimeFormatter.format(LocalDateTime.now(Clock.systemUTC()));
                break;
        }

        return findElementByXpath("//XCUIElementTypeButton[contains(@name,'" + clientSystemTime + "')]").isDisplayed();
    }

    public boolean isEndVisitPopUpDisplayed() {
        return findElementByXpath(END_VISIT_POP_UP_TITLE).isDisplayed() && findElementById(OK_MODAL_ID).isDisplayed();
    }
}
