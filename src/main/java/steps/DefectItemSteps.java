package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectItemPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectItemSteps extends ScenarioSteps {

    DefectItemPage defectItemPage;

    @Step
    public void selectDefectFromList(String itemName) {
        defectItemPage.waitUntilPageIsLoaded();
        defectItemPage.selectItemFromList(itemName);
    }

    @Step
    public void checkItemsArePresent(String... items) {
        defectItemPage.waitUntilPageIsLoaded();
        for (String item: items) {
            assertThat(defectItemPage.findItemInList(item).isDisplayed()).isTrue();
        }
    }

    @Step
    public void clickBack() {
        defectItemPage.waitUntilPageIsLoaded();
        defectItemPage.clickBack();
    }

    @Step
    public void searchForDefect(String defectName) {
        defectItemPage.searchForDefect(defectName);
    }

    @Step
    public void checkExpectedPresentDefects(int expectedIdentifierNumber, String... defectList) {
        assertThat(defectItemPage.getElementsNumberFromList(defectList)).isEqualTo(expectedIdentifierNumber);
    }

    @Step
    public void selectItemFromSearchList(String itemName) {
        defectItemPage.selectItemFromList(itemName);
    }

    @Step
    public void clearSearch() {
        defectItemPage.clearSearch();
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        defectItemPage.waitByElement("No results found", 2);
        List<String> actualData = defectItemPage.findAllLabelsByClassName();
        assertThat(actualData).contains("No results found", "Try searching for a different term or", "picking from the list");
    }
}
