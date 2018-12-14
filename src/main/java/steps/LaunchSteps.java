package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LaunchPage;

public class LaunchSteps extends ScenarioSteps {
    LaunchPage launchPage;


    @Step()
    public void clickGetStarted() {
        launchPage.clickGetStarted();
    }

}
