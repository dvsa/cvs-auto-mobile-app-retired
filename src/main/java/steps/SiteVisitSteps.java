package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteVisitSteps extends ScenarioSteps {

    SiteVisitPage siteVisitPage;

    @Step
    public void createNewTest() {
        siteVisitPage.waitUntilPageIsLoaded();
        siteVisitPage.clickCreateNewTest();
    }

    @Step
    public void waitUntillPageIsLoaded(){
        siteVisitPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSiteVisitPage() {
        siteVisitPage.waitUntilPageIsLoaded();
        assertThat(siteVisitPage.isPageTitleDisplayed()).isTrue();
    }

    public void checkTestStatus() {
        assertThat(siteVisitPage.isFailStatusDisplayed()).isTrue();
    }
}
