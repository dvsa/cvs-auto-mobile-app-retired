package sitevisit.CVSB_179;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.SiteVisitComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;


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
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SelectVehicleSteps selectVehicleSteps;

    @Steps
    CarDetailsSteps carDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;


    @Ignore("Wait times functionality switched off")
    @Title("CVSB-179 - AC1 - Remains inactive for more than 5 minutes, VTA-302 - check time not testing reasons, check type note allows 200 characters, activity after time not testing")
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
        // input up to 200 characters
        selectReasonSteps.typeNote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nis");
        selectReasonSteps.pressSave();
        siteVisitSteps.checkAddedReasons("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nis");
        siteVisitSteps.clickStartTest();
        identifyVehicleSteps.searchForVehicle("CO79ERT");
        identifyVehicleSteps.pressSearch();
        carDetailsSteps.waitUntilPageIsLoaded();
        carDetailsSteps.selectConfirmButtonTopRight();
        carDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        //cancel test activity after time not testing
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("Reason");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();

    }
}
