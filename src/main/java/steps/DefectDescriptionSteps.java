package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectDescriptionPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectDescriptionSteps extends ScenarioSteps {

    DefectDescriptionPage defectDescriptionPage;

    @Step
    public void tapAddAnAdvisoryNote() {
        defectDescriptionPage.waitUntilPageIsLoaded();
        defectDescriptionPage.clickAddAdvisoryNote();
    }

    @Step
    public void selectDefect(String defectId) {
        defectDescriptionPage.waitUntilPageIsLoaded();
        defectDescriptionPage.selectById(defectId);
    }


    @Step
    public void checkPageIsLoaded() {
        defectDescriptionPage.waitUntilPageIsLoaded();
    }

    @Step
    public void clickBack() {
        defectDescriptionPage.clickBack();
    }

    @Step
    public void searchForDefect(String defectName) {
        defectDescriptionPage.searchForDefect(defectName);
    }

    @Step
    public void checkItemsArePresent(String... items) {
        defectDescriptionPage.waitUntilPageIsLoaded();
        for (String item: items) {
            assertThat(defectDescriptionPage.findItemInList(item).isDisplayed()).isTrue();
        }
    }

    @Step
    public void checkExpectedPresentDefects(int expectedIdentifierNumber, String... defectList) {
        assertThat(defectDescriptionPage.getElementsNumberFromList(defectList)).isEqualTo(expectedIdentifierNumber);
    }


    @Step
    public void selectItemFromSearchList(String itemName) {
        defectDescriptionPage.selectById(itemName);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        defectDescriptionPage.waitByElement("No results found", 2);
        List<String> actualData = defectDescriptionPage.findAllLabelsByClassName();
        assertThat(actualData).contains("No results found", "Try searching for a different term or", "picking from the list");
    }

    @Step
    public void clearSearch() {
        defectDescriptionPage.clearSearch();
    }
}