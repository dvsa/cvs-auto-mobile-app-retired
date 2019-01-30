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

    public enum Units {
        KILOMETRES("Kilometres"), MILES("Miles");

        private String value;

        Units(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return value;
        }

    }
    public enum UnitOptions {
        KILOMETRES("Kilometres"), MILES("Miles"), CANCEL("Cancel");

        private String value;

        UnitOptions(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }


    public boolean isUnitDisplayed(UnitOptions unitOptions) {
        return findElementById(unitOptions.getValue() + " Edit").isDisplayed();
    }

    public boolean isOptionDisplayed(UnitOptions unitOptions) {
        return findElementById(unitOptions.getValue()).isDisplayed();

    }


    public String getExpectedUnit(Units unit) {
        return unit.getValue();
    }

    public void clickUnitOption(UnitOptions unitOptions) {
                findElementById(unitOptions.getValue()).click();
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

