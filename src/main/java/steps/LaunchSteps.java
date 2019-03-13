package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LaunchPage;
import pages.LoginPage;
import pages.SignaturePage;

import static org.assertj.core.api.Assertions.assertThat;

public class LaunchSteps extends ScenarioSteps {
    LaunchPage launchPage;
    LoginPage loginPage;
    SignaturePage signaturePage;

    @Step()
    public void clickGetStarted() {
        launchPage.clickGetStarted(loginPage, signaturePage);
    }

    @Step()
    public void waitUntilPageIsLoaded() {
        launchPage.waitUntilPageIsLoaded();
    }

    @Step
    public void clickStartButton() {
        launchPage.clickStartButton();
    }


    @Step
    public void resetAppAndWaitUntilPageIsLoaded() {
//        TODO: this will need to be continued once services are down and automation can be written
    }

    @Step
    public void checkLaunchPageDisplay() {
        launchPage.waitUntilPageIsLoaded();
        assertThat(launchPage.checkIfBetaTextIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfGetStartedButtonIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfSubTitleIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfTitle1IsDisplayed()).isTrue();
        assertThat(launchPage.checkIfTitle2IsDisplayed()).isTrue();
        assertThat(launchPage.checkIfLaunchImageIsDisplayed()).isTrue();
    }

    @Step
    public void clickToEnableOrDisable() {
        launchPage.clickToEnableOrDisable();
    }
}

