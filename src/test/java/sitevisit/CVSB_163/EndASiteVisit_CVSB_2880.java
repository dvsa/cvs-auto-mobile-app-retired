package sitevisit.CVSB_163;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EndASiteVisit_CVSB_2880 extends BaseTestClass {

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    FindAnATFSteps findAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSubmittedSteps siteVisitSubmittedSteps;

    @Title("CVSB-163 - AC6 Data loaded")
    @Test
    public void testDataLoaded() {
        launchSteps.clickGetStarted();
        findAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkEndVisitPopUp();
        siteVisitSteps.clickOkInEndVisitPopUp();
        siteVisitSubmittedSteps.waitUntilPageIsLoaded();
        siteVisitSubmittedSteps.checkDetailsByAtf("Abshire-Kub");

    }
}
