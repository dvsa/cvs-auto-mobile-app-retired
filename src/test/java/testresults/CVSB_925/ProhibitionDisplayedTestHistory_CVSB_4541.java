package testresults.CVSB_925;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ProhibitionDisplayedTestHistory_CVSB_4541 extends BaseTestClass {

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Title("CVSB-925 - TCD - AC2 - Prohibition displayed on test history details at a defect level")
    @Test
    public void prohibitionDisplayedOnTestHistoryDetailsAtDefectLevel() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(), "Voluntary Test");
        testTypeCategorySteps.selectFromTestTypeList("Brake Test");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("1");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("fail");
        testTypeDetailsSteps.enablePRS();
        testTypeDetailsSteps.pressSave();
        testSteps.reviewActionAndScroll();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.clickLastTestByTestResult("PROHIBITION");
        testHistoryDetailsSteps.checkElementIsPresent("Prohibition issued");
        testHistoryDetailsSteps.checkElementIsPresent("Yes");
    }
}


