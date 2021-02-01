package testresults.CVSB_18974;

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
public class TestResultForFreeLoadedTestsForTrl_CVSB_18974 extends BaseTestClass {

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
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetails;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-18974 - Verify that Free loaded tests can be submitted for a TRL " +
            "+ CVSB-17868 - Free loaded retest has a pre-existing test type id")
    @Test
    public void testResultsForFreeLoadedTestsForTrl() {

        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("765432", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("O2");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test retest");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Annual test retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Free loaded retest");
        testSteps.selectTestType("Retest",TestPage.TestTypeStatuses.EDIT);
        testTypeDetails.clickAddDefect();
        defectCategorySteps.selectDefectFromList("6. Road Wheels and Hubs");
        defectItemSteps.selectDefectFromList("1. A tyre retaining ring:");
        defectDescriptionSteps.selectDefect("6.1 (a) * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetails.addNotes("for testing CVSB-17868");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.checkTestStatus("Free loaded retest", "FAIL");
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
    }
}
