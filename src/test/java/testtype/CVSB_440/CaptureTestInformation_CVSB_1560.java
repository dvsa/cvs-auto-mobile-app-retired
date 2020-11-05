package testtype.CVSB_440;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1560 extends BaseTestClass {

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

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-440 - AC5B - Fields displayed in the app (e.g Defect details) are contextually sensitive," +
            " based on the data received for each test type from the database")
    public void testFieldsDisplayed() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
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
        testTypeDetailsSteps.addNotes("Test");
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("123");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("7. Engine MIL");
        defectDescriptionSteps.selectDefect("5.7 MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.reviewActionAndScroll();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.clickLastTestByTestType("Annual test");
        testHistoryDetailsSteps.waitUntilPageIsLoaded();
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Test result", "FAIL");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("5.7");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("MAJOR");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("5. Exhaust Emissions");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("7. Engine MIL");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("inoperative or indicating a malfunction.");
        testHistoryDetailsSteps.scroll();
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Odometer reading", "123 km");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Carried out during inspection", "Yes");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Number of seatbelts", "123");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Name", "Abshire-Kub");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("P-number", "09-4129632");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("Name", "Staff ID");
        testHistoryDetailsSteps.checkElementValueIsDisplayed("NOTES", "Test");
    }
}
