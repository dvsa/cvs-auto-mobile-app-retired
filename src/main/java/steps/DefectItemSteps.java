package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectItemPage;

public class DefectItemSteps extends ScenarioSteps {

    DefectItemPage defectItemPage;

    @Step
    public void selectDefectFromList(String itemName) {
        defectItemPage.waitUntilPageIsLoaded();
        defectItemPage.selectItemFromList(itemName);
    }
}
