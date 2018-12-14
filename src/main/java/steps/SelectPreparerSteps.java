package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectPreparerPage;

public class SelectPreparerSteps extends ScenarioSteps {
    SelectPreparerPage selectPreparerPage;

    @Step
    public void selectPreparerAndConfirm(String id, String name) {
        selectPreparerPage.waitUntilPageIsLoaded();
        selectPreparerPage.selectPreparer(id, name);
        selectPreparerPage.confirm();
    }
}
