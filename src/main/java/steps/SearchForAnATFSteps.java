package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.SearchForAnATFPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchForAnATFSteps extends ScenarioSteps {
    SearchForAnATFPage searchForAnATFPage;

    @Step
    public void checkATFSearchButtonAndList() {
        searchForAnATFPage.waitUntilPageIsLoaded();

        List<String> actualData = searchForAnATFPage.findAllLabelsByXpath();
        assertThat(actualData).contains("Abshire-Kub", "09-4129632", "Bergnaum Group", "Jacobson and Sons");
        assertThat(searchForAnATFPage.isSearchFieldPresent()).isTrue();
    }

    @Step
    public void searchForInvalidAtf() {
        searchForAnATFPage.waitUntilPageIsLoaded();
        String randomData = RandomStringUtils.randomAlphanumeric(15);
        searchForAnATFPage.searchForAtf(randomData);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        List<String> actualData = searchForAnATFPage.findAllLabelsByXpath();
        assertThat(actualData).contains("No results found", "You can search for an ATF by typing in", "it's name, address or P-number");
    }

    @Step
    public void searchForValidpNumberOrAddress(String searchValue) {
        searchForAnATFPage.waitUntilPageIsLoaded();
        searchForAnATFPage.searchForAtf(searchValue);
    }


    @Step
    public void checkAddressAndpNumberIsFiltered(String address, String pNumber) {
        searchForAnATFPage.waitUntilFilterIsCompleted(3);
        List<String> actualData = searchForAnATFPage.findAllLabelsByXpath();
        assertThat(actualData).contains(address, pNumber);
    }

    @Step
    public void selectAnAtf(String atfName) {
        searchForAnATFPage.waitUntilPageIsLoaded();
        searchForAnATFPage.clickOnAtf(atfName);
    }
}
