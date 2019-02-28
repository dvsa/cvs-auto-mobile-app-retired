package testresults.CVBS_495;

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
public class ReviewTestSummary_2702 extends BaseTestClass {

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-495 - AC2 - VSA cannot edit review screen")
    @Test
    public void canNotEditReviewScreen() {
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
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (a) MAJOR");
        defectDetailsSteps.selectOptionsAndTapAddDefect("Upper", "Offside", "5", "4");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.checkElementIsNotEditable("Annual test");
        testReviewSteps.checkElementIsNotEditable("FAIL");
        testReviewSteps.checkElementIsNotEditable("Seatbelt installation check");
        testReviewSteps.checkElementIsNotEditable("Yes");
        testReviewSteps.checkElementIsNotEditable("Number of seatbelts fitted");
        testReviewSteps.checkElementIsNotEditable("4");
        testReviewSteps.checkElementIsNotEditable("Most recent seatbelt check");
        testReviewSteps.checkElementIsNotEditable("MAJOR");
        testReviewSteps.checkElementIsNotEditable("3.1.a MAJOR");
        testReviewSteps.checkElementIsNotEditable("3. Seat Belts & Supplementary Restraint Systems");
        testReviewSteps.checkElementIsNotEditable("1. Obligatory Seat Belt:");
        testReviewSteps.checkElementIsNotEditable("(a). missing.");
    }
}
