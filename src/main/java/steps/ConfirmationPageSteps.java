package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ConfirmationPage;

public class ConfirmationPageSteps extends ScenarioSteps {

    ConfirmationPage confirmationPage;


    @Step
    public void pressDone() {
        confirmationPage.waitUntilPageIsLoaded();
        confirmationPage.clickDoneButton();
    }
}
