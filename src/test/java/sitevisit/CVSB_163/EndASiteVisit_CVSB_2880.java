package sitevisit.CVSB_163;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.*;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class EndASiteVisit_CVSB_2880 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSubmittedSteps siteVisitSubmittedSteps;

    @Ignore("[CVSB-8416] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-163 - AC6 Data loaded")
    public void testDataLoaded() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkEndVisitPopUp();
        siteVisitSteps.clickOkInEndVisitPopUp();
        siteVisitSubmittedSteps.waitUntilPageIsLoaded();
        siteVisitSubmittedSteps.checkDetailsByAtf("Abshire-Kub");

    }
}
