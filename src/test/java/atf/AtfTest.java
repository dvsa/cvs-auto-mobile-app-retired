package atf;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;

@RunWith(SerenityRunner.class)
public class AtfTest {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Managed
    WebDriver webdriver;


    @Test
    public void testAtfListAndSearchOption() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkATFSearchButtonAndList();
    }

    @Test
    public void testNoSearchResults() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForInvalidAtf();
        searchForAnATFSteps.checkNoResultsFoundAndSuggestion();
    }

    @Test
    public void testSearchFieldpNumber() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForValidpNumberOrAddress("00-3024646");
        searchForAnATFSteps.checkAddressAndpNumberIsFiltered("Nienow-Wunsch", "00-3024646");
    }

    @Test
    public void testSearchFieldAddress() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForValidpNumberOrAddress("Larson, Nader and Okuneva");
        searchForAnATFSteps.checkAddressAndpNumberIsFiltered("Larson, Nader and Okuneva", "84-926821");

    }


}
