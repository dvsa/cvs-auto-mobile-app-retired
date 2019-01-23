package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LaunchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LaunchSteps extends ScenarioSteps {
    LaunchPage launchPage;


    @Step()
    public void clickGetStarted() {
        launchPage.clickGetStarted();
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
    public void resetAppAndWaitUntillPageIsLoaded() {
//        launchPage.resetAppAndWaitUntillPageIsLoaded();
    }

    @Step
    public void checkLaunchPageDisplay() {
        launchPage.waitUntilPageIsLoaded();
        assertThat(launchPage.checkIfBetaTextIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfGetStartedButttonIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfSubTitleIsDisplayed()).isTrue();
        assertThat(launchPage.checkIfTitle1IsDisplayed()).isTrue();
        assertThat(launchPage.checkIfTitle2IsDisplayed()).isTrue();
        assertThat(launchPage.checkIfLaunchImageIsDisplayed()).isTrue();
    }
}

