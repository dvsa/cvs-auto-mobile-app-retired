package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.SearchForAnATFPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchForAnATFSteps extends ScenarioSteps {
    SearchForAnATFPage searchForAnATFPage;

    @Step
    public void checkATFSearchButtonAndList(String... idOrLetter) {
        searchForAnATFPage.waitUntilPageIsLoaded();

        for (String element : idOrLetter) {
            searchForAnATFPage.elementFromListIsDisplayed(element);
        }
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
        searchForAnATFPage.waitByElement("No results found", 2);
        List<String> actualData = searchForAnATFPage.findAllLabelsByXpath();
        assertThat(actualData).contains("No results found", "You can search by test facility number,", "name or address");
    }

    @Step
    public void searchForValidPNumberOrAddress(String searchValue) {
        searchForAnATFPage.waitUntilPageIsLoaded();
        searchForAnATFPage.searchForAtf(searchValue);
    }

    @Step
    public void checkAddressAndPNumberIsFiltered(String addressAndPNumber, String initial) {
        searchForAnATFPage.waitUntilFilterIsCompleted(1);
        assertThat(searchForAnATFPage.elementFromListIsDisplayed(addressAndPNumber)).isTrue();
        assertThat(searchForAnATFPage.elementFromListIsDisplayed(initial)).isTrue();
    }

    @Step
    public void waitForPageToLoadAndSelectAnAtf(String atfName) {
        searchForAnATFPage.waitUntilPageIsLoaded();
        searchForAnATFPage.clickOnAtf(atfName);
    }

    @Step
    public void checkListIsScrollableByElement(String element) {
        searchForAnATFPage.waitUntilPageIsLoaded();
        assertThat(searchForAnATFPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = searchForAnATFPage.getYPositionForElement(element);
        searchForAnATFPage.swipeDown();
        assertThat(searchForAnATFPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = searchForAnATFPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void checkListIsAlphabeticallyOrdered() {
        searchForAnATFPage.waitUntilPageIsLoaded();
        List<String> actualList = searchForAnATFPage.findAllLabelsByXpath();

        actualList.remove(0);
        List<String> sortedList = new ArrayList<>(actualList);
        Collections.sort(sortedList);

        List<String> itemsToRemoveFromList = new ArrayList<>(sortedList.subList(0,sortedList.indexOf("A")));
        actualList.removeAll(itemsToRemoveFromList);
        sortedList.removeAll(itemsToRemoveFromList);

        assertThat(actualList.equals(sortedList)).isTrue();

    }

    @Step
    public void searchAndVerifyForLongAlphanumericNumber() {
        String randomData = RandomStringUtils.randomAlphanumeric(150);
        searchForAnATFPage.searchForAtf(randomData);
        assertThat(searchForAnATFPage.elementInSearchIsPresent(randomData)).isTrue();
    }

    @Step
    public void checkAtfPageDisplay() {
        searchForAnATFPage.waitUntilPageIsLoaded();
        assertThat(searchForAnATFPage.isSearchFieldPresent()).isTrue();
        assertThat(searchForAnATFPage.isTitleDisplayed()).isTrue();
        assertThat(searchForAnATFPage.isBackButtonPresent()).isTrue();
        checkListIsAlphabeticallyOrdered();
    }

    @Step
    public void clickBackButton() {
        searchForAnATFPage.waitUntilPageIsLoaded();
        searchForAnATFPage.clickBack();
    }

    @Step
    public void isTestingFacilityPresentPNumberAndName(){
        assertThat(searchForAnATFPage.isSearchedTestingFacilityPresent("Abshire-Kub", "09-4129632"));
        searchForAnATFPage.clickCancel();
    }

    @Step
    public void isTestingFacilityPresentAddress(){
        assertThat(searchForAnATFPage.isSearchedTestingFacilityPresent("Abshire-Kub", "5 Lukken Lane"));
        searchForAnATFPage.clickCancel();
    }
}
