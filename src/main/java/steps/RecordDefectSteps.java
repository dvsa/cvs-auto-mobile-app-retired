package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.RecordDefectPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordDefectSteps extends ScenarioSteps {

    RecordDefectPage recordDefectPage;


    @Step
    public void selectDefectFromList(String itemName) {
        recordDefectPage.waitUntilPageIsLoaded();
        recordDefectPage.selectItemFromList(itemName);
    }

    @Step
    public void checkLevelOneListOfDefects(String... defectList) {
        recordDefectPage.waitUntilPageIsLoaded();
        assertThat(recordDefectPage.getElementsNumberFromList(defectList)).isGreaterThan(0);

    }

    @Step
    public void clickBack() {
        recordDefectPage.waitUntilPageIsLoaded();
        recordDefectPage.clickBack();
    }

    @Step
    public void searchForDefect(String defectName) {
        recordDefectPage.searchForDefect(defectName);
    }

    @Step
    public void checkExpectedPresentDefects(int expectedIdentifierNumber, String... defectList) {
        assertThat(recordDefectPage.getElementsNumberFromList(defectList)).isEqualTo(expectedIdentifierNumber);
    }

    @Step
    public void selectItemFromSearchList(String itemName) {
        recordDefectPage.selectItemFromList(itemName);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        recordDefectPage.waitByElement("No results found", 2);
        List<String> actualData = recordDefectPage.findAllLabelsByClassName();
        assertThat(actualData).contains("No results found", "Try searching for a different term or", "picking from the list");
    }

    @Step
    public void clearSearch() {
        recordDefectPage.clearSearch();
    }
}
