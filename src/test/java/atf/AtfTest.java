package atf;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;

@RunWith(SerenityRunner.class)
public class AtfTest {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Managed
    WebDriver webdriver;


    @Title("CVSB-165 / CVSB-677 - AC1 - ATF's scrollable list")
    @Test
    public void testAtfListScrollable() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkListIsScrollableByElement("Abshire-Kub");
    }

    @Title("CVSB-165 / CVSB-678 - AC2 - Select an ATF from the list in alphabetical order")
    @Test
    public void testAtfListAlphabeticallyOrdered() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkListIsAlphabeticallyOrdered();
        searchForAnATFSteps.selectAnAtf("Abshire-Kub");
        atfDetailsSteps.waitUntilPageIsLoaded();
    }

    @Title("CVSB-165 / CVSB-679 - AC3 - No search results")
    @Test
    public void testNoSearchResults() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForInvalidAtf();
        searchForAnATFSteps.checkNoResultsFoundAndSuggestion();
    }


    @Title("CVSB-165 / CVSB-685 TCD - Search field -pNumber")
    @Test
    public void testSearchFieldpNumber() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForValidPNumberOrAddress("00-3024646");
        searchForAnATFSteps.checkAddressAndPNumberIsFiltered("Nienow-Wunsch", "00-3024646");
    }

    @Title("CVSB-165 / CVSB-686 - TCD - Search field - Address")
    @Test
    public void testSearchFieldAddress() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchForValidPNumberOrAddress("Larson, Nader and Okuneva");
        searchForAnATFSteps.checkAddressAndPNumberIsFiltered("Larson, Nader and Okuneva", "84-926821");

    }

    @Title("CVSB-165 / CVSB-764 - Search field - properties")
    @Test
    public void searchFieldProperties(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.searchAndVerifyForLongAlphanumericNumber();
    }

    @Title("CVSB-165 / CVSB-769 - Search for ATF option and list of ATFs")
    @Test
    public void testAtfListAndSearchOption() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.checkATFSearchButtonAndList();
    }



}
