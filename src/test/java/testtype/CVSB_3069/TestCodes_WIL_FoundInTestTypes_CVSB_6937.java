package testtype.CVSB_3069;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestCodes_WIL_FoundInTestTypes_CVSB_6937 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6937,CVSB-6939 and CVSB-6941- AC1,AC2 and AC3 - Codes added are reflected in the selection of test types, recorded against the test and reviewed")
    public void testTestCodeWIL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestTypeUsingSpecificVin(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),"012356",super.username);
        testTypeCategorySteps.selectFromTestTypeList("Prohibition Clearance");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A (seatbelt installation check)");
        testTypeCategorySteps.selectFromTestTypeList("PG9 Retest");
        testSteps.checkSelectedTestTypes("Prohibition clearance In progress arrow forward");
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("44");
        odometerReadingSteps.checkReadingValue("44");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("2");
        testTypeDetailsSteps.selectAddDefect("Prohibition clearance (retest with Class 6A seatbelt installation check)");
        defectCategorySteps.selectDefectFromList("10. Spare Wheel & Carrier");
        defectItemSteps.checkItemsArePresent("1. A spare wheel carrier:", "2. A spare wheel:");
        defectItemSteps.selectDefectFromList("1. A spare wheel carrier:");
        defectDescriptionSteps.selectDefect("not in proper condition.");
        defectDetailsSteps.tapDone();

        testTypeDetailsSteps.selectAddDefect("Prohibition clearance (retest with Class 6A seatbelt installation check)");
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("7. Engine MIL");
        defectDescriptionSteps.selectDefect("inoperative or indicating a malfunction.");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);

        testTypeDetailsSteps.swipeDefect("5. Exhaust Emissions");
        testTypeDetailsSteps.pressRemove();
        testTypeDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.checkDefectRemoved("5. Exhaust Emissions");
        testTypeDetailsSteps.pressSave();

        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkPageTitleIsDisplayed();
        testReviewSteps.checkElementIsDisplayed("X71LTA (PSV)");
        testReviewSteps.checkElementValue("Odometer reading","44");
        testReviewSteps.checkElementValue("Prohibition clearance (retest with Class 6A seatbelt installation check)","PASS");
        testReviewSteps.checkElementValue("Seatbelt installation check","Yes");
        testReviewSteps.checkElementValue("Number of seatbelts fitted","2");
        testReviewSteps.scrollDown();
        testReviewSteps.checkElementIsDisplayed("Defects");
        testReviewSteps.checkElementIsDisplayed("10.1 (i) MINOR");
        testReviewSteps.checkElementIsDisplayed("10. Spare Wheel & Carrier");
        testReviewSteps.checkElementIsDisplayed("1. A spare wheel carrier:");
        testReviewSteps.checkElementIsDisplayed("(i) not in proper condition.");
    }
}
