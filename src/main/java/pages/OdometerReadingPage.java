package pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class OdometerReadingPage extends BasePage {

    private static final String ODOMETER_READING_PAGE_TITLE = "Odometer reading";
    private static final String READING_TITLE = "READING";
    private static final String UNIT_TITLE = "UNIT";
    private static final String READING_FIELD_CLASS_NAME = "XCUIElementTypeTextField";
    private static final String BUTTONS_CLASS_NAME = "XCUIElementTypeButton";

    private static final String SAVE_BUTTON_ID = "Save";
    private static final String KILOMETRES_OPTION_ID = "Kilometres";
    private static final String MILES_OPTION_ID = "Miles";
    private static final String CANCEL_OPTION_ID = "Cancel";


    public boolean isUnitDisplayed(UnitOptions unitOptions) {
        boolean status = false;
        switch (unitOptions) {
            case KILOMETRES:
                status = findElementById(getActualUnit() + " Edit").isDisplayed();
                break;
            case MILES:
                status = findElementById(getActualUnit() + " Edit").isDisplayed();
                break;
        }
        return status;
    }

    public enum Units { KILOMETRES, MILES }
    public enum UnitOptions { KILOMETRES, MILES, CANCEL }


    public boolean isKilometresOptionDisplayed() {
        return findElementById(KILOMETRES_OPTION_ID).isDisplayed();
    }

    public boolean isMilesOptionDisplayed() {
        return findElementById(MILES_OPTION_ID).isDisplayed();
    }


    public boolean isCancelOptionDisplayed() {
        return findElementById(CANCEL_OPTION_ID).isDisplayed();
    }


    public String getExpectedUnit(Units unit) {
        String expectedUnit = "";
        switch (unit) {
            case KILOMETRES:
                expectedUnit = "Kilometres";
                break;
            case MILES:
                expectedUnit = "Miles";
                break;
        }
        return expectedUnit;
    }

    public void clickUnitOption(UnitOptions unitOptions) {
        switch (unitOptions) {
            case MILES:
                findElementById(MILES_OPTION_ID).click();
                break;
            case KILOMETRES:
                findElementById(KILOMETRES_OPTION_ID).click();
                break;
            case CANCEL:
                findElementById(CANCEL_OPTION_ID).click();
                break;
        }
    }

    public String getActualUnit() {
        waitUntilPageIsLoaded();
        List<WebElement> buttons = findElementsByClassName(BUTTONS_CLASS_NAME);
        String actualUnit = "";
        for (WebElement element : buttons) {
            if (element.getAttribute("name").contains("Edit")) {
                String[] stringArray = element.getAttribute("name").split(" ");
                actualUnit = stringArray[0];
                break;
            }
        }
        return actualUnit;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(ODOMETER_READING_PAGE_TITLE);
    }

    public void clickSave() {
        findElementById(SAVE_BUTTON_ID).click();
    }


    public void typeInReadingField(String text) {
        WebElement readingField = findElementByClassName(READING_FIELD_CLASS_NAME);
        readingField.clear();
        readingField.sendKeys(text);
    }

    public boolean isReadingTitleDisplayed() {
        return findElementById(READING_TITLE).isDisplayed();
    }

    public boolean isUnitTitleDisplayed() {
        return findElementById(UNIT_TITLE).isDisplayed();
    }

    public String getReadingValue() {
        return findElementByClassName(READING_FIELD_CLASS_NAME).getAttribute("value");
    }

    public void clickEditUnit() {
        waitUntilPageIsLoaded();
        List<WebElement> buttons = findElementsByClassName(BUTTONS_CLASS_NAME);
        for (WebElement button : buttons) {
            if (button.getAttribute("name").contains("Edit")) {
                button.click();
                break;
            }
        }
    }

}

