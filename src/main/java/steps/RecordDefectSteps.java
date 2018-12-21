package steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.RecordDefectPage;

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
}
