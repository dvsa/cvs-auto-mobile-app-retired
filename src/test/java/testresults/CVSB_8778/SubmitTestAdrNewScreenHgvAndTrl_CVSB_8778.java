package testresults.CVSB_8778;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SubmitTestAdrNewScreenHgvAndTrl_CVSB_8778 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    AdrDetailsStep adrDetailsStep;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Title("CVSB-8778 - AC1 - Rule for dynamic 'Battery list' fields - TC3 - AC3 - Field 'Applicable' = Yes")
    @Test
    public void testAdrDetailsFieldsSemiTrailerBatteryApplicable() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777776");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C777776", "ABCDEFGH777776");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectAdrDetails();
        adrDetailsStep.waitUntilPageIsLoaded();
        adrDetailsStep.checkThePageTitleIs("ADR details");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADR DETAILS");
        adrDetailsStep.checkAdrDetailHasValue("Vehicle type", "semi trailer battery");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("BATTERY LIST");
        adrDetailsStep.checkAdrDetailSectionContains("BATTERY LIST", "Applicable");
        adrDetailsStep.checkAdrDetailHasValue("Applicable", "Yes");
        adrDetailsStep.checkAdrDetailSectionContains("BATTERY LIST", "Reference number");
        adrDetailsStep.checkAdrDetailHasValue("Reference number", "Not entered");
    }

    @Title("CVSB-8778 - AC1 - Rule for dynamic 'Battery list' fields - TC2 - AC2 - Field 'Applicable' = No")
    @Test
    public void testAdrDetailsFieldsRigidBatteryApplicableNo() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777775");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C777775", "ABCDEFGH777775");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectAdrDetails();
        adrDetailsStep.waitUntilPageIsLoaded();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADR DETAILS");
        adrDetailsStep.checkAdrDetailHasValue("Vehicle type", "rigid battery tank");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("BATTERY LIST");
        adrDetailsStep.checkAdrDetailSectionContains("BATTERY LIST", "Applicable");
        adrDetailsStep.checkAdrDetailHasValue("Applicable", "No");
        adrDetailsStep.checkAdrDetailSectionNotContains("BATTERY LIST", "Reference number");
    }


    @Title("CVSB-8778 - AC1 - Rule for dynamic 'Battery list' fields - Trl - Non semi trailer battery - not displayed")
    @Test
    public void testAdrDetailsFieldsNonSemiTrailerBattery() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777777");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C108802", "ABCDEFGH777777");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectAdrDetails();
        adrDetailsStep.waitUntilPageIsLoaded();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADR DETAILS");
        adrDetailsStep.checkAdrDetailHasValue("Vehicle type", "Centre axle tank");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsNotDisplayed("BATTERY LIST");
    }

    @Title("CVSB-9663 - TC - AC1 - View ADR tech record - AC2 - Subsequent tank inspections - AC3 - Substances permitted section")
    @Test
    public void testAdrDetailsFields() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777778");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C777778", "ABCDEFGH777778");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectAdrDetails();
        adrDetailsStep.waitUntilPageIsLoaded();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADR DETAILS");
        adrDetailsStep.checkAdrDetailHasValue("Vehicle type", "semi trailer battery");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("PERMITTED DANGEROUS GOODS");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("TANK DETAILS");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("SUBSTANCES PERMITTED");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSTANCES PERMITTED", "Substances (class UN number and if necessary packing group and proper shipping name) may be carried");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSTANCES PERMITTED", "Statement reference number");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSTANCES PERMITTED", "Product list reference number");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSTANCES PERMITTED", "UN number");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSTANCES PERMITTED", "Additional product list details");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("INITIAL TANK INSPECTION");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("SUBSEQUENT TANK INSPECTION");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSEQUENT TANK INSPECTION", "Inspection type");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSEQUENT TANK INSPECTION", "Certificate number");
        adrDetailsStep.checkAdrDetailSectionContains("SUBSEQUENT TANK INSPECTION", "Expiry Date");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("MEMO 07/09 (3 MONTH EXTENSION)");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("BATTERY LIST");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("CERTIFICATE");
        adrDetailsStep.scrollTheAdrDetailPage();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADDITIONAL ADR DETAILS");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("APPLICANT DETAILS");
    }

    @Title("CVSB-9663 - TC - AC5 - Field not selected in source - AC6 - Fields with no data which are still displayed")
    @Test
    public void testAdrDetailsFieldsNotDisplayed() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("777776");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C777776", "ABCDEFGH777776");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectAdrDetails();
        adrDetailsStep.waitUntilPageIsLoaded();
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("ADR DETAILS");
        adrDetailsStep.checkAdrDetailHasValue("Vehicle type", "semi trailer battery");
        adrDetailsStep.checkAdrDetailSectionIsDisplayed("PERMITTED DANGEROUS GOODS");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "FP &lt;61 (FL)");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "AT");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Class 5.1 Hydrogen Peroxide (OX)");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "MEMU");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Carbon Disulphide");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Hydrogen");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Explosives (type 2)");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Explosives (type 3)");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Compatibility group J");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Statement reference number");
        adrDetailsStep.checkAdrDetailSectionNotContains("PERMITTED DANGEROUS GOODS", "Additional product list details");
        adrDetailsStep.checkAdrDetailSectionIsNotDisplayed("SUBSEQUENT TANK INSPECTION");
        adrDetailsStep.checkAdrDetailHasValue("Name", "Not entered");
        adrDetailsStep.checkAdrDetailHasValue("Street", "Not entered");
        adrDetailsStep.checkAdrDetailHasValue("Town", "Not entered");
        adrDetailsStep.checkAdrDetailHasValue("City", "Not entered");
        adrDetailsStep.checkAdrDetailHasValue("Postcode", "Not entered");
    }

}