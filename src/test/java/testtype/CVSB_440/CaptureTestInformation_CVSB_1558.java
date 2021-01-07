package testtype.CVSB_440;

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
public class CaptureTestInformation_CVSB_1558 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    PreparerSteps preparerSteps;


    @Title("CVSB-440 - AC4B - VSA views a test record")
    @Test
    public void testVsaViewsATestRecordB() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("021430",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("M2");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("123");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewActionAndScroll();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("AA34BCD");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.selectTestAtPosition("Annual test",0);
        testHistoryDetailsSteps.waitUntilPageIsLoaded();
        testHistoryDetailsSteps.checkElementIsPresent("Test date");
        testHistoryDetailsSteps.checkElementIsPresent("Test time");
        testHistoryDetailsSteps.checkElementIsPresent("Test expiry");
        testHistoryDetailsSteps.waitUntilPageIsLoaded();
        testHistoryDetailsSteps.checkDate();
        testHistoryDetailsSteps.checkTime();
    }
}

