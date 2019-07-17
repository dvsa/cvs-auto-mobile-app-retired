package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.FindAnATFPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAnATFSteps extends ScenarioSteps {
    FindAnATFPage findAnATFPage;

    @Step
    public void checkATFSearchButtonAndList(String... idOrLetter) {
        findAnATFPage.waitUntilPageIsLoaded();

        for (String element : idOrLetter) {
            findAnATFPage.elementFromListIsDisplayed(element);
        }
        assertThat(findAnATFPage.isSearchFieldPresent()).isTrue();
    }

    @Step
    public void searchForInvalidAtf() {
        findAnATFPage.waitUntilPageIsLoaded();
        String randomData = RandomStringUtils.randomAlphanumeric(15);
        findAnATFPage.searchForAtf(randomData);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        findAnATFPage.waitByElement("No results found", 2);
        List<String> actualData = findAnATFPage.findAllLabelsByXpath();
        assertThat(actualData).contains("No results found", "You can search for an ATF by typing in", "it's name, address or P-number");
    }

    @Step
    public void searchForValidPNumberOrAddress(String searchValue) {
        findAnATFPage.waitUntilPageIsLoaded();
        findAnATFPage.searchForAtf(searchValue);
    }

    @Step
    public void checkAddressAndPNumberIsFiltered(String addressAndPNumber, String initial) {
        findAnATFPage.waitUntilFilterIsCompleted(1);
        assertThat(findAnATFPage.elementFromListIsDisplayed(addressAndPNumber)).isTrue();
        assertThat(findAnATFPage.elementFromListIsDisplayed(initial)).isTrue();
    }

    @Step
    public void waitForPageToLoadAndSelectAnAtf(String atfName) {
        findAnATFPage.waitUntilPageIsLoaded();
        findAnATFPage.clickOnAtf(atfName);
    }

    @Step
    public void checkListIsScrollableByElement(String element) {
        findAnATFPage.waitUntilPageIsLoaded();
        assertThat(findAnATFPage.elementFromListIsDisplayed(element)).isTrue();
        int oldYPosition = findAnATFPage.getYPositionForElement(element);
        findAnATFPage.swipeDown();
        assertThat(findAnATFPage.elementFromListIsDisplayed(element)).isFalse();
        int newYPosition = findAnATFPage.getYPositionForElement(element);
        assertThat(oldYPosition).isNotEqualTo(newYPosition);
    }

    @Step
    public void checkListIsAlphabeticallyOrdered() {
        findAnATFPage.waitUntilPageIsLoaded();
        List<String> actualList = findAnATFPage.findAllLabelsByXpath();

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
        findAnATFPage.searchForAtf(randomData);
        assertThat(findAnATFPage.elementInSearchIsPresent(randomData)).isTrue();
    }

    @Step
    public void checkAtfPageDisplay() {
        findAnATFPage.waitUntilPageIsLoaded();
        assertThat(findAnATFPage.isSearchFieldPresent()).isTrue();
        assertThat(findAnATFPage.isTitleDisplayed()).isTrue();
        assertThat(findAnATFPage.isBackButtonPresent()).isTrue();
        checkListIsAlphabeticallyOrdered();
    }

    @Step
    public void clickBackButton() {
        findAnATFPage.waitUntilPageIsLoaded();
        findAnATFPage.clickBack();
    }
}
