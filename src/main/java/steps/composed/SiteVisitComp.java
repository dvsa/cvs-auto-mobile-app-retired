package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.*;

import java.util.Date;

public class SiteVisitComp extends ScenarioSteps {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Step
    public Date goToSiteVisit(String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        Date startVisitDate = atfDetailsSteps.startVisit();
        return startVisitDate;
    }
}
