package testtype.CVSB_440;

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
public class CaptureTestInformation_CVSB_1561 extends BaseTestClass {

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    TestHistorySteps testHistorySteps;


    @Title("CVSB-440 - AC6 - VSA cannot update Vehicle test history")
    @Test
    public void testCannotUpdateTestHistory() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("123");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.clickLastTestByTestType("Annual test");
        testHistoryDetailsSteps.checkAllElementsAreNoteditable();
    }
}
