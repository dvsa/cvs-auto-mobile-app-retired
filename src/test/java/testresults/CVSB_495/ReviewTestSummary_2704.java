package testresults.CVSB_495;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ReviewTestSummary_2704 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Ignore("[CVSB-8289] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-495 - AC4 - VSA can change details of individual test types")
    public void editingTestTypeResultAndGoingBackToTestReviewScreen() {
        //Adding a test type and making it a non progress one
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.pressSave();

        //remove test type from change details screen
        testSteps.clickReviewAndSubmit();
        testReviewSteps.changeDetails();
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testSteps.pressRemoveInPopUp();

        //add a new test type
        testReviewSteps.goToTestPage();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("8");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.changeDetails();

        //edit the test type
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("16");

        //Add defect from change details screen
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.selectOptionsAndTapAddDefect(defectDetailsSteps.inputSeatbeltDefect());

        //Abandon test type from change details screen
        testTypeDetailsSteps.addNotes("Test");
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
    }
}
