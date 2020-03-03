package sitevisit.CVSB_163;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ATFDetailsSteps;
import steps.LaunchSteps;
import steps.SearchForAnATFSteps;
import steps.SiteVisitSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EndASiteVisit_CVSB_2884 extends BaseTestClass {

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-163 - AC1 - Start visit")
    public void testStartVisit() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkCreateTestButton();
        siteVisitSteps.checkEndVisitButton();

    }
}
