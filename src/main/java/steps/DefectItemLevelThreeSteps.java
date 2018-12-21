package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.DefectItemLevelThreePage;

public class DefectItemLevelThreeSteps extends ScenarioSteps {

    DefectItemLevelThreePage defectItemLevelThreePage;

    @Step
    public void tapAddAnAdvisoryNote() {
        defectItemLevelThreePage.waitUntillPageIsLoaded();
        defectItemLevelThreePage.clickAddAdvisoryNote();
    }

    @Step
    public void selectDefect(String defectId) {
        defectItemLevelThreePage.waitUntillPageIsLoaded();
        defectItemLevelThreePage.selectById(defectId);
    }
}