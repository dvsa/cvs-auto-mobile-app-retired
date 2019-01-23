package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ErrorPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ErrorSteps extends ScenarioSteps {
    ErrorPage errorPage;

    @Step
    public void checkAllGenericErrorMessageElementsAreDisplayed() {
        errorPage.waitUntilPageIsLoaded();
        assertThat(errorPage.getTitleName().isDisplayed()).isTrue();
        assertThat(errorPage.getSubTitle().isDisplayed()).isTrue();
        assertThat(errorPage.getSettings().isDisplayed()).isTrue();
        assertThat(errorPage.getCallTechSupport().isDisplayed()).isTrue();
        assertThat(errorPage.getTryAgain().isDisplayed()).isTrue();

    }

    @Step
    public void clickCallTechSupport() {
        errorPage.waitUntilPageIsLoaded();
        errorPage.clickCallTechSupport();
    }

    @Step
    public void clickSettings() {
        errorPage.waitUntilPageIsLoaded();
        errorPage.clickSettings();
    }

    @Step
    public void checkSettingsWindow() {
        errorPage.waitUntilSettingsAppIsDisplayed();
    }

    @Step
    public void clickTryAgain() {
        errorPage.waitUntilPageIsLoaded();
        errorPage.clickTryAgain();
    }

    @Step
    public void checkLoadingIsDisplayed() {
        assertThat(errorPage.waitUntilLoadingIsDisplayed()).isTrue();
    }

}
