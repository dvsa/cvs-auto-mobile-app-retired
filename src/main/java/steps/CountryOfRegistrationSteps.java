package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CountryOfRegistrationPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CountryOfRegistrationSteps extends ScenarioSteps {

    CountryOfRegistrationPage countryOfRegistrationPage;

    @Step
    public void saveRegistrationCountry() {
        countryOfRegistrationPage.waitUntilPageIsLoaded();
        countryOfRegistrationPage.clickSaveButton();
    }

    @Step
    public void selectNotKnownOption() {
        countryOfRegistrationPage.selectNotKnown();
    }

    @Step
    public void checkAllCountriesAreDisplayed() {
        countryOfRegistrationPage.checkAllElementsAreDisplayed();
    }

    @Step
    public void checkCountriesAreOrdered() {
        assertThat(countryOfRegistrationPage.checkListOfCountriesIsOrdered()).isTrue();
    }

    @Step
    public void searchForCountry(String country) {
        countryOfRegistrationPage.searchForCountry(country);
    }

    @Step
    public void selectACountry(String country) {
        countryOfRegistrationPage.selectACountry(country);
    }

    @Step
    public void noResultsFoundIsDisplayed() {
        assertThat(countryOfRegistrationPage.checkNoResultFoundMessageIsDisplayed()).isTrue();
    }

    @Step
    public void scrollThroughList() {
        countryOfRegistrationPage.scrollThroughList();
    }

    @Step
    public void optionsAreDisplayedAtTopAndBottomAfterSearch(String country) {
        countryOfRegistrationPage.optionsAreDisplayedAtTopAndBottomAfterSearch(country);
    }

    @Step
    public void cancelSearchAction(){
        countryOfRegistrationPage.cancelSearch();
    }

    @Step
    public void checkListIsFilteredByCriteria(String searchString) {
        countryOfRegistrationPage.checkListOfCountryIsFiltered(searchString);
    }

    @Step
    public void optionsRemainAtBottomAndTop(String country) {
        countryOfRegistrationPage.optionsAreDisplayedAtTopAndBottomAfterSearch(country);
    }
}
