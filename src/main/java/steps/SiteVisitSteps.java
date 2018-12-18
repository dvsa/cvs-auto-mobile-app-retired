package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitPage;

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
}
