package testtype.CVSB_15775;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class UpdateTestTypeNames_CVSB_15775 extends BaseTestClass {
    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SelectVehicleSteps selectVehicleSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB-15775 - AC1 - Clearer test type names for PSV AC3 - Removal of Vitesse 100")
    @Test
    public void testTypeNamesForPsvHgvTrl(){
        // for PSV
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("678410",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Any PSV retest", "Class 6A retest (seatbelt installation check)");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeSubcategorySteps.selectFromTestTypeList("Part paid retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Any PSV retest");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Brake test", "Headlamp aim test", "Smoke test", "Multi - check", "Speed limiter check", "Tempo 100");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.goBackToTestOverview();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.addReasonForCancellation("Other");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        // for HGV
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("230123");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Annual test retest", "TIR retest", "ADR retest", "Roadworthiness retest", "First test retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeSubcategorySteps.selectFromTestTypeList("TIR retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeSubcategorySteps.selectFromTestTypeList("ADR retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Free retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeSubcategorySteps.selectFromTestTypeList("Roadworthiness retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part Paid retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeSubcategorySteps.selectFromTestTypeList("First test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.goBackToTestOverview();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.addReasonForCancellation("Other");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        // for TRL with one axle
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("341237");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeSubcategorySteps.selectFromTestTypeList("Roadworthiness retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part Paid retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeCategorySteps.selectFromTestTypeList("First test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest");
        testTypeSubcategorySteps.goBackToCategory();
        testTypeSubcategorySteps.goBackToCategory();
        testTypeCategorySteps.goBackToTestOverview();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.addReasonForCancellation("Other");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        // for TRL with three axles
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("765432");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest", "Free loaded retest");
        testTypeSubcategorySteps.goBackToCategory();

        testTypeCategorySteps.selectFromTestTypeList("First test retest");
        testTypeSubcategorySteps.checkTestTypeListOnlyContainsTestTypes("Paid retest", "Part paid retest", "Free retest");
    }
}
