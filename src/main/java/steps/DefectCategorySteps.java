package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectCategoryPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectCategorySteps extends ScenarioSteps {

    DefectCategoryPage defectCategoryPage;


    @Step
    public void selectDefectFromList(String itemName) {
        defectCategoryPage.selectItemFromList(itemName);
    }

    @Step
    public void checkListOfDefects(String... defectList) {
        defectCategoryPage.waitUntilPageIsLoaded();
        assertThat(defectCategoryPage.getElementsNumberFromList(defectList)).isGreaterThan(0);

    }

    @Step
    public void clickBack() {
        defectCategoryPage.waitUntilPageIsLoaded();
        defectCategoryPage.clickBack();
    }

    @Step
    public void searchForDefect(String defectName) {
        defectCategoryPage.searchForDefect(defectName);
    }

    @Step
    public void checkExpectedPresentDefects(int expectedIdentifierNumber, String... defectList) {
        assertThat(defectCategoryPage.getElementsNumberFromList(defectList)).isEqualTo(expectedIdentifierNumber);
    }

    @Step
    public void selectItemFromSearchList(String itemName) {
        defectCategoryPage.selectItemFromList(itemName);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        defectCategoryPage.waitByElement("No results found", 2);
        List<String> actualData = defectCategoryPage.findAllLabelsByClassName();
        assertThat(actualData).contains("No results found", "Try searching for a different term or", "picking from the list");
    }

    @Step
    public void clearSearch() {
        defectCategoryPage.clearSearch();
    }
}
