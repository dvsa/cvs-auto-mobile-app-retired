package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CountryOfRegistrationPage extends BasePage {

    private static final String PAGE_TITLE_ID = "Country of registration";
    private static final String SAVE_BUTTON_ID = "Save";
    private static final String SEARCH_FIELD_XPATH = "//XCUIElementTypeSearchField";
    private static final String CANCEL_OPTION_ID = "Cancel";
    private static final String NO_RESULTS_MESSAGE_XPATH = "//XCUIElementTypeStaticText[@name=\"No results found\"]";

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public void clickSaveButton() {
        waitUntilPageIsLoaded();
        findElementById(SAVE_BUTTON_ID).click();
    }

    public enum Countries {
        GB("Great Britain and Northern Ireland - GB"),
        GBA("Alderney - GBA"),
        A("Austria - A"),
        B("Belgium - B"),
        BIH("Bosnia and Herzegovina - BIH"),
        BG("Bulgaria - BG"),
        HR("Croatia - HR"),
        CY("Cyprus - CY"),
        CZ("Czech Republic - CZ"),
        DK("Denmark - DK"),
        EST("Estonia - EST"),
        FIN("Finland - FIN"),
        F("France - F"),
        D("Germany - D"),
        GBZ("Gibraltar - GBZ"),
        GR("Greece - GR"),
        GBG("Guernsey - GBG"),
        H("Hungary - H"),
        IRL("Ireland - IRL"),
        GBM("Isle of Man - GBM"),
        I("Italy - I"),
        GBJ("Jersey - GBJ"),
        LV("Latvia - LV"),
        LT("Lithuania - LT"),
        L("Luxembourg - L"),
        M("Malta - M"),
        NL("Netherlands - NL"),
        N("Norway - N"),
        PL("Poland - PL"),
        P("Portugal - P"),
        RO("Romania - RO"),
        SK("Slovakia - SK"),
        SLO("Slovenia - SLO"),
        E("Spain - E"),
        S("Sweden - S"),
        CH("Switzerland - CH"),
        NONEU("Non EU"),
        NOTKNOWN("Country Not Known");

        private String value;

        Countries(String _value) {
            this.value = _value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public void checkAllElementsAreDisplayed() {
        List<String> expectedCountries = new ArrayList<>();
        for (Countries c : Countries.values()) {
            expectedCountries.add(c.getValue());
        }

        List<String> filteredExpectedCountries = expectedCountries.stream()
                .filter(line -> !"Great Britain and Northern Ireland - GB".equals(line))
                .filter(line -> !"Non EU".equals(line))
                .filter(line -> !"Country Not Known".equals(line))
                .collect(Collectors.toList());

        List<WebElement> actualButtonsXpaths;
        actualButtonsXpaths = findElementsByXpath("//XCUIElementTypeButton");

        List<String> actualButtonsValues = new ArrayList<>();
        for (WebElement we : actualButtonsXpaths) {
            actualButtonsValues.add(we.getAttribute("name"));
        }

        List<String> filteredActualButtonsXpathByCountry = eliminateUnwantedButtonsDisplayed(actualButtonsValues);
        assertThat(filteredActualButtonsXpathByCountry.equals(filteredExpectedCountries)).isTrue();
    }

    public boolean checkListOfCountriesIsOrdered() {
        List<String> countriesDisplayed = new ArrayList<>();
        for (Countries c : Countries.values()) {
            WebElement we = findElementByXpath("//XCUIElementTypeButton[starts-with(@name,\"" + c.getValue() + "\")]");
            countriesDisplayed.add(we.getText());
        }

        List<String> filteredList = countriesDisplayed.stream()
                .filter(line -> !"Great Britain and Northern Ireland - GB checkmark".equals(line))
                .filter(line -> !"Non EU".equals(line))
                .filter(line -> !"Country Not Known".equals(line))
                .collect(Collectors.toList());
        return Ordering.natural().isOrdered(filteredList);
    }

    public void searchForCountry(String country) {
        WebElement we = findElementByXpath(SEARCH_FIELD_XPATH);
        we.clear();
        we.sendKeys(country);
    }

    public void checkListOfCountryIsFiltered(String filterString) {
        waitUntilPageIsLoaded();
        List<WebElement> elementsBeforeFilter = findElementsByXpath("//XCUIElementTypeButton");
        List<String> countriesDisplayedTextBeforeFilter = new ArrayList<>();
        for (WebElement we : elementsBeforeFilter) {
            if (we.isDisplayed() && we.isEnabled()) {
                countriesDisplayedTextBeforeFilter.add(we.getText());
            }
        }

        List<String> cleanBeforeList = eliminateUnwantedButtonsDisplayed(countriesDisplayedTextBeforeFilter);
        for (String s : cleanBeforeList) {
            assertThat(!s.contains(filterString)).isTrue();
        }

        searchForCountry(filterString);

        List<WebElement> elementsAfterFilter = findElementsByXpath("//XCUIElementTypeButton");
        List<String> countriesDisplayedTextAfterFilter = new ArrayList<>();
        for (WebElement we : elementsAfterFilter) {
            if (we.isDisplayed() && we.isEnabled()) {
                countriesDisplayedTextAfterFilter.add(we.getText());
            }
        }

        List<String> cleanAfterList = eliminateUnwantedButtonsDisplayed(countriesDisplayedTextAfterFilter);
        for (String s : cleanAfterList) {
            logger.info("Countries are: " + s);
            assertThat(s.contains(filterString)).isTrue();
        }
        assertThat(Ordering.natural().isOrdered(cleanAfterList)).isTrue();
    }

    public List<String> eliminateUnwantedButtonsDisplayed(List<String> list) {
        return list.stream()
                .filter(line -> !"Review and submit".equals(line))
                .filter(line -> !"BQ91YHQ (PSV) 1B7GG36N12S678410 Details arrow forward".equals(line))
                .filter(line -> !"EU vehicle category M3 checkmark".equals(line))
                .filter(line -> !"EU vehicle category Select arrow forward".equals(line))
                .filter(line -> !"Add a test type".equals(line))
                .filter(line -> !"Add a trailer".equals(line))
                .filter(line -> !"Cancel test".equals(line))
                .filter(line -> !"Cancel".equals(line))
                .filter(line -> !"Great Britain and Northern Ireland - GB checkmark".equals(line))
                .filter(line -> !"Non EU".equals(line))
                .filter(line -> !"Country Not Known".equals(line))
                .filter(line -> !"1".equals(line))
                .filter(line -> !"Emoji".equals(line))
                .filter(line -> !"Dictate".equals(line))
                .filter(line -> !"return".equals(line))
                .filter(line -> !"Save".equals(line))
                .filter(line -> !"Country of registration Great Britain and Northern Ireland arrow forward".equals(line))
                .filter(line -> !"Odometer reading Enter arrow forward".equals(line))
                .filter(line -> !"English (UK)".equals(line))
                .filter(line -> !"Français (Canada)".equals(line))
                .filter(line -> !"Español (España)".equals(line))
                .filter(line -> !"Return".equals(line))
                .filter(line -> !"clear".equals(line))
                .filter(line -> !line.isEmpty())
                .filter(line -> !"Not applicable".equals(line))
                .collect(Collectors.toList());
    }

    public void cancelSearch() {
        findElementById(CANCEL_OPTION_ID).click();
        assertThat(findElementByXpath(SEARCH_FIELD_XPATH).getText().equals("")).isTrue();
    }

    public void selectACountry(String country) {
        searchForCountry(country);
        for(Countries definedCountry : Countries.values()){
            if (definedCountry.getValue().contains(country)){
                findElementByXpath("//XCUIElementTypeButton[contains(@name,'"+definedCountry.getValue()+ "')]").click();
            }
        }

        clickSaveButton();
    }

    public void selectNotKnown() {
        searchForCountry("Norway");
        findElementByXpath("//XCUIElementTypeButton[contains(@name,'Country Not Known')]").click();
        clickSaveButton();
    }

    public void selectNotApplicable() {
        searchForCountry("Norway");
        findElementByXpath("//XCUIElementTypeButton[contains(@name,'Not applicable')]").click();
        clickSaveButton();
    }

    public boolean checkNoResultFoundMessageIsDisplayed() {
        return findElementByXpath(NO_RESULTS_MESSAGE_XPATH).isDisplayed();
    }

    public void scrollThroughList() {
        WebElement we = findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Great Britain and Northern Ireland - GB')]");
        scroll(we.getLocation().x, we.getLocation().y, we.getLocation().x, we.getLocation().y - 150);
    }

    public void optionsAreDisplayedAtTopAndBottomAfterSearch(String country) {
        searchForCountry(country);
        List<WebElement> countries = findElementsByXpath("//XCUIElementTypeButton[contains(@name,'" + country + "')]");

        int ukElement = findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Great Britain and Northern Ireland - GB')]").getLocation().y;
        int nonEU = findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Non EU')]").getLocation().y;
        int notKnown = findElementByXpath("//XCUIElementTypeButton[starts-with(@name,'Country Not Known')]").getLocation().y;

        for (WebElement we : countries) {
            assertThat(we.getLocation().y > ukElement).isTrue();
            assertThat(we.getLocation().y < nonEU).isTrue();
            assertThat(we.getLocation().y < notKnown).isTrue();
        }
    }
}
