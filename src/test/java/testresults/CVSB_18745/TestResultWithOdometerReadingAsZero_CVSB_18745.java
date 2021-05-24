package testresults.CVSB_18745;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestResultWithOdometerReadingAsZero_CVSB_18745 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-18745 - AC1 - Submitting value as '0' - HGV ")
    @Test
    public void TestResultWithOdometerReadingAsZeroHgv() {

        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("N3");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("0");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.completeEndVisit();
    }

    @Title("CVSB-18745 - AC1 - Submitting value as '0' - PSV ")
    @Test
    public void TestResultWithOdometerReadingAsZeroPsv() {

        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("M3");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("0");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.completeEndVisit();
    }
}
