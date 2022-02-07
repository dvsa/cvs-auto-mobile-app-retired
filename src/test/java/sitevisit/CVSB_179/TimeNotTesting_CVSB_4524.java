package sitevisit.CVSB_179;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.SiteVisitComp;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@WithTag("In_test")
@RunWith(SerenityRunner.class)
public class TimeNotTesting_CVSB_4524 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    SiteVisitComp siteVisitComp;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    SiteVisitSelectReasonSteps selectReasonSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-179 - AC1 - Remains inactive for more than 5 minutes")
    @Test
    public void test5minInactivity() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        siteVisitComp.goToSiteVisit(super.username);
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.waitUntilTimeNotTesting();
        siteVisitSteps.checkTimeNotTesting();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.pressSave();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkTimeNotTestingPopUp();
        siteVisitSteps.pressOkInTimeNotTestingPopUp();
        siteVisitSteps.clickTimeNotTesting();
        selectReasonSteps.waitUntilPageIsLoaded();
        selectReasonSteps.checkSelectionForEachReason();
        selectReasonSteps.pressSave();
        selectReasonSteps.checkPopUp();
        selectReasonSteps.pressOkInPopUp();
        selectReasonSteps.typeNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nis");
        selectReasonSteps.pressSave();
        siteVisitSteps.checkAddedReasons("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nis");
        siteVisitSteps.clickStartTest();
        testSteps.selectOdometerReading();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.waitUntilPageIsLoaded();
        //cancel test
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("Reason");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();


    }
}
