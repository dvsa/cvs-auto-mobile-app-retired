package sitevisit.CVSB_179;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SiteVisitSelectReasonSteps;
import steps.SiteVisitSteps;
import steps.composed.SiteVisitComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TimeNotTesting_CVSB_4524 extends BaseTestClass {

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    SiteVisitSelectReasonSteps selectReasonSteps;

    @Title("CVSB-179 - AC1 - Remains inactive for more than 5 minutes")
    @Test
    public void test5minInactivity() {
        siteVisitComp.goToSiteVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.waitUntilTimeNotTesting();
        siteVisitSteps.checkTimeNotTesting();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.pressSave();
        siteVisitSteps.createNewTest();
        siteVisitSteps.checkTimeNotTestingPopUp();
        siteVisitSteps.pressOkInTimeNotTestingPopUp();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.checkSelectionForEachReason();
        selectReasonSteps.pressSave();
        selectReasonSteps.checkPopUp();
        selectReasonSteps.pressOkInPopUp();
        selectReasonSteps.typeNote("I fell asleep ...");
        selectReasonSteps.pressSave();


    }
}
