package testtype.CVSB_3911;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestPageFieldsDisplayed_CVSB_6768 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    HgvDetailsSteps hgvDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-6768 - AC1 - Fields displayed on test screen - HGV (fields shown)")
    @WithTag("Smoke_2")
    @Test
    public void testFieldsDisplayedForHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkCountryOfRegistrationOptionIsDisplayed();
        testSteps.checkEUVehicleCategoryOptionIsDisplayed();
        testSteps.checkOdometerOptionIsDisplayed();
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.checkAddATrailerButtonVisibility();

    }

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6771 - AC1 - Fields displayed on test screen - HGV (test history)")
    @Test
    public void testFieldsDisplayedTestHistoryForHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.selectVehicleDetails();
        hgvDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.checkPage();
        testHistorySteps.checkRegPlate("CT70 VRL");
        testHistorySteps.checkNoTestHistoryIsDisplayed();
        testHistorySteps.pressBackButton();
        hgvDetailsSteps.selectWeights();
        weightsSteps.checkFieldIsListed("AXLE 1");
        weightsSteps.checkFieldIsListed("AXLE 2");
        weightsSteps.checkFieldIsListed("TRAIN");
        weightsSteps.checkFieldIsListed("GROSS");
        weightsSteps.checkContentCategories("AXLE 1", "1400", "1800");
        weightsSteps.checkContentCategories("AXLE 2", "1600", "1900");
        weightsSteps.checkContentCategories("TRAIN", "1500", "2000");
        weightsSteps.checkContentCategories("GROSS", "0", "0");
        weightsSteps.pressBackButton();
    }

    @Title("CVSB-6776 - AC1 - Fields displayed on test screen - HGV (select a test type)")
    @Test
    public void testFieldsDisplayedAddTestsForHgv() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ Fee");
        testTypeSubcategorySteps.selectFromTestTypeList("With certification");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.checkTestTypeStatus("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Paid prohibition clearance (full inspection with certification)");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.checkAddDefectIsPresent();
        testTypeDetailsSteps.checkTestTypeAbandonButton();
        testTypeDetailsSteps.checkTestTypeRemoveButton();
    }

}
