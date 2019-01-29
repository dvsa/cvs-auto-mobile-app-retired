package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectItemLevelThreePage;

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
}