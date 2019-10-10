package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ConfirmationPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfirmationPageSteps extends ScenarioSteps {

    ConfirmationPage confirmationPage;


    @Step
    public void pressDone() {
        confirmationPage.waitUntilPageIsLoaded();
        confirmationPage.clickDoneButton();
    }

    @Step
    public void checkElementContainingStringIsDisplayed(String string){
        confirmationPage.waitUntilPageIsLoaded();
        assertThat(confirmationPage.checkElementContainingStringIsDisplayed(string)).isTrue();
    }

    @Step
    public void waitUntilPageIsLoaded(){
        confirmationPage.waitUntilPageIsLoaded();
    }
}
