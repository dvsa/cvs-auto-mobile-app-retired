package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ATFDetailsPage;

public class ATFDetailsSteps extends ScenarioSteps {
    ATFDetailsPage atfDetailsPage;

    @Step
    public void startVisit() {
        atfDetailsPage.waitUntilPageIsLoaded();
        atfDetailsPage.clickStartVisit();
        atfDetailsPage.selectYes();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        atfDetailsPage.waitUntilPageIsLoaded();
    }
}
