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
public class CaptureTestInformation_CVSB_1557 extends BaseTestClass {

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

    @Title("CVSB-440 - AC4A - VSA views a test record")
    @Test
    public void testVsaViewsATestRecordA() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("LEC");
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.sendCertificateNumber("12345");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.clickLastTestByTestType("Technical test");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("TEST TYPE", "Low Emissions Certificate (LEC) With Annual Test");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Test result", "PASS");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Certificate number", "LP12345");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("DEFECTS", "Not entered");
        testHistoryDetailsSteps.scroll();
        testHistoryDetailsSteps.checkElementValueIsDisplayed("NOTES", "None");
    }
}
