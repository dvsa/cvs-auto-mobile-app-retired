package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.BasePage;

public class CommonSteps extends ScenarioSteps {

    BasePage basePage;

    @Step
    public BasePage getPage() {
        return basePage;
    }
}
