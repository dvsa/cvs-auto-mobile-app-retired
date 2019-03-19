package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitSubmittedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteVisitSubmittedSteps extends ScenarioSteps {

    SiteVisitSubmittedPage siteVisitSubmittedPage;

    @Step
    public void pressDone() {
        siteVisitSubmittedPage.clickDone();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        siteVisitSubmittedPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkDetailsByAtf(String atfName) {
        assertThat(siteVisitSubmittedPage.isElementDisplayed(atfName)).isTrue();
    }
}
