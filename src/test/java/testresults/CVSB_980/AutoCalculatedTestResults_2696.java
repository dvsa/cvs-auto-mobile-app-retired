package testresults.CVSB_980;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class AutoCalculatedTestResults_2696 extends BaseTestClass {

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
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB_980 - AC1 - Fail criteria (At least 1 Major + no PRS)")
    @Test
    public void failCriticalOneMajorNoPRS() {
        testTypeCategoryComp.goToTestPage("TC7524","Avello Edinburgh Ltd");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("5");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("3");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.changeDetails();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        HashMap<String, String> map = new HashMap<>();
        map.put("Vertical", "Upper");
        map.put("Lateral", "Nearside");
        map.put("Row Number", "4");
        map.put("Seat Number", "4");
        defectDetailsSteps.selectOptionsAndTapAddDefect(map);
        testTypeDetailsSteps.pressSave();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }
}
