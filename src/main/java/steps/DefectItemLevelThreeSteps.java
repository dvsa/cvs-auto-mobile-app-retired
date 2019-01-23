package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectItemLevelThreePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectItemLevelThreeSteps extends ScenarioSteps {

    DefectItemLevelThreePage defectItemLevelThreePage;

    @Step
    public void tapAddAnAdvisoryNote() {
        defectItemLevelThreePage.waitUntilPageIsLoaded();
        defectItemLevelThreePage.clickAddAdvisoryNote();
    }

    @Step
    public void selectDefect(String defectId) {
        defectItemLevelThreePage.waitUntilPageIsLoaded();
        defectItemLevelThreePage.selectById(defectId);
    }


    @Step
    public void checkPageIsLoaded() {
        defectItemLevelThreePage.waitUntilPageIsLoaded();
    }

    @Step
    public void clickBack() {
        defectItemLevelThreePage.clickBack();
    }

    @Step
    public void searchForDefect(String defectName) {
        defectItemLevelThreePage.searchForDefect(defectName);
    }

    @Step
    public void checkItemsArePresent(String... items) {
        defectItemLevelThreePage.waitUntilPageIsLoaded();
        for (String item: items) {
            assertThat(defectItemLevelThreePage.findItemInList(item).isDisplayed()).isTrue();
        }
    }

    @Step
    public void checkExpectedPresentDefects(int expectedIdentifierNumber, String... defectList) {
        assertThat(defectItemLevelThreePage.getElementsNumberFromList(defectList)).isEqualTo(expectedIdentifierNumber);
    }


    @Step
    public void selectItemFromSearchList(String itemName) {
        defectItemLevelThreePage.selectById(itemName);
    }

    @Step
    public void checkNoResultsFoundAndSuggestion() {
        defectItemLevelThreePage.waitByElement("No results found", 2);
        List<String> actualData = defectItemLevelThreePage.findAllLabelsByClassName();
        assertThat(actualData).contains("No results found", "Try searching for a different term or", "picking from the list");
    }
}