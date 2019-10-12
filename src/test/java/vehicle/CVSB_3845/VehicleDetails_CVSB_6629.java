package vehicle.CVSB_3845;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_6629 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    HgvDetailsSteps hgvDetailsSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    VehicleComp vehicleComp;

    @Steps
    TyresSteps tyresSteps;

    @Steps
    AdditionalVehicleDetailsSteps additionalVehicleDetailsSteps;

    @Steps
    BrakesSteps brakesSteps;

    @Title("CVSB-6629 - AC1 - Trailer ID display")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testTrailerIdDisplayed() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("T12341237");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000002", "T12341237");
    }

    @Title("CVSB-6638 - AC2 VSA can see all fields listed (HGV)")
    @Test
    public void testAllDetailsHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.selectHgvDetails();
        hgvDetailsSteps.checkMakeIs("Isuzu");
        hgvDetailsSteps.checkModelIs("FM");
        hgvDetailsSteps.checkBodyTypeIs("tipper");
        hgvDetailsSteps.checkFunctionCodeIs("A");
        hgvDetailsSteps.checkYearOfManufactureIs("2018");
        hgvDetailsSteps.checkDateOfFirstRegistrationIs("24/06/2019");
        hgvDetailsSteps.checkAxleIs("3");
        hgvDetailsSteps.checkDtpIs("178202");

    }

    @Title("CVSB-6630 - AC2 VSA can see all fields listed (TRL)")
    @Test
    public void testAllDetailsTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341237");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000002", "T12341237");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.checkVinChassisNumberIs("T12341237");
        trailerDetailsSteps.checkMakeIs("Isuzu");
        trailerDetailsSteps.checkModelIs("F06");
        trailerDetailsSteps.checkBodyTypeIs("skeletal");
        trailerDetailsSteps.checkYearOfManufactureIs("2018");
        trailerDetailsSteps.checkDateOfFirstUseIs("24/06/2019");
        trailerDetailsSteps.checkAxleIs("1");
        trailerDetailsSteps.checkDtpIs("178202");
    }

    @Title("CVSB-6632 - AC 3 Action fields navigate to the correct pages (HGV Weights Screen)")
    @Test
    public void testHgvWeightsScreen() {
        vehicleComp.goToVehicleDetails("012938");
        hgvDetailsSteps.scrollTheDetailPage("VIN / Chassis number");
        hgvDetailsSteps.selectWeights();
        weightsSteps.checkFieldIsListed("AXLE 1");
        weightsSteps.checkFieldIsListed("AXLE 2");
        weightsSteps.checkFieldIsListed("AXLE 3");
        weightsSteps.checkFieldIsListed("TRAIN");
        weightsSteps.checkFieldIsListed("MAX TRAIN");
        weightsSteps.checkFieldIsListed("GROSS");
        weightsSteps.checkContentCategories("AXLE 1", "1400", "1800");
        weightsSteps.checkContentCategories("AXLE 2", "1600", "1900");
        weightsSteps.checkContentCategories("AXLE 3", "1600", "1900");
        weightsSteps.checkContentCategories("TRAIN", "1500", "2000");
        weightsSteps.checkContentCategories("MAX TRAIN", "1000", "500");
        weightsSteps.checkContentCategories("GROSS", "0", "0");
        weightsSteps.pressBackButton();
    }


    @Title("CVSB-6632 - AC 3 Action fields navigate to the correct pages (HGV Tyres Screen)")
    @Test
    public void testHgvTyresScreen() {
        vehicleComp.goToVehicleDetails("012938");
        hgvDetailsSteps.scrollTheDetailPage("VIN / Chassis number");
        hgvDetailsSteps.selectTyres();
        tyresSteps.checkDetailsOfAxle("AXLE 1", "9.23648E+11","AB", "single", "345", "1234");
        tyresSteps.checkDetailsOfAxle("AXLE 2", "9.23648E+11","AB", "single", "345", "5678");
        tyresSteps.checkDetailsOfAxle("AXLE 3", "9.23648E+11","AB", "single", "345", "5678");
        tyresSteps.checkTyreUseCode("2B");
        tyresSteps.pressBackButton();

    }

    @Title("CVSB-6990 - AC 3 Action fields navigate to the correct pages (HGV Additional Vehicle Details Screen)")
    @Test
    public void testHgvAdditionalVehicleDetailsScreen() {
        vehicleComp.goToVehicleDetails("012938");
        hgvDetailsSteps.scrollTheDetailPage("VIN / Chassis number");
        hgvDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkNtaNumberIs("123456");
        additionalVehicleDetailsSteps.checkConversionNumberIs("7891234");
        additionalVehicleDetailsSteps.checkSpeedLimiterIs("Yes");
        additionalVehicleDetailsSteps.checkTachoExemptIs("Yes");
        additionalVehicleDetailsSteps.checkRoadFriendlyIs("Yes");
        additionalVehicleDetailsSteps.checkDrawbarCouplingFittedIs("Yes");
        additionalVehicleDetailsSteps.checkEuroStandardIs("7");
        additionalVehicleDetailsSteps.checkDimensionLengthIs("7500");
        additionalVehicleDetailsSteps.checkDimensionWidthIs("2200");
        additionalVehicleDetailsSteps.scrollTheDetailPage("NTA number");
        additionalVehicleDetailsSteps.checkAxleMinIs("FRONT AXLE TO 5TH WHEEL", "1200");
        additionalVehicleDetailsSteps.checkAxleMaxIs("FRONT AXLE TO 5TH WHEEL", "1500");
        additionalVehicleDetailsSteps.checkAxleMinIs("FRONT AXLE TO 5TH WHEEL COUPLING", "1700");
        additionalVehicleDetailsSteps.checkAxleMaxIs("FRONT AXLE TO 5TH WHEEL COUPLING", "1900");
        additionalVehicleDetailsSteps.checkNotesAre("test note");
        additionalVehicleDetailsSteps.checkVehicleTypeIs("hgv");
        additionalVehicleDetailsSteps.checkEuVehicleCategoryIsDisplayed();
        additionalVehicleDetailsSteps.checkCountryOfRegistration("gb");
        additionalVehicleDetailsSteps.pressBackButton();

    }

    @Title("CVSB-6640 - AC 3 Action fields navigate to the correct pages (TRL Brakes Screen)")
    @Test
    public void testTrlBrakesScreen() {

        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341237");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000002", "T12341237");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage("Make");
        trailerDetailsSteps.selectBrakes();
        brakesSteps.checkBrakeActuatorIsDisplayedForAxle("AXLE 1");
        brakesSteps.checkLeverLengthIsDisplayedForAxle("AXLE 1");
        brakesSteps.checkSpringBrakeParkingIsDisplayedForAxle("AXLE 1");
        brakesSteps.checkLoadSensingValveIsDisplayed();
        brakesSteps.checkAntilockBrakingSystemIsDisplayed();
        brakesSteps.pressBackButton();
    }

    @Title("CVSB-6641 - AC 3 Action fields navigate to the correct pages (TRL Weights Screen)")
    @Test
    public void testTrlWeightsScreen() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage("Make");
        trailerDetailsSteps.selectWeights();
        weightsSteps.checkFieldIsListed("AXLE 1");
        weightsSteps.checkFieldIsListed("AXLE 2");
        weightsSteps.checkFieldIsListed("GROSS");
        weightsSteps.checkContentCategories("AXLE 1", "1400", "1800");
        weightsSteps.checkContentCategories("AXLE 2", "1600", "1900");
        weightsSteps.checkGrossIsDisplayed();
        weightsSteps.checkFieldHasValue("Max load on coupling", "7000");
        weightsSteps.pressBackButton();
    }

    @Title("CVSB-6642 - AC 3 Action fields navigate to the correct pages (TRL Tyres Screen)")
    @Test
    public void testTrlTyresScreen() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage("Make");
        trailerDetailsSteps.selectTyres();
        tyresSteps.checkDetailsOfAxle("AXLE 1", "9.23648E+11","AB", "single", "345", "1234");
        tyresSteps.checkDetailsOfAxle("AXLE 2", "9.23648E+11","AB", "single", "345", "5678");
        tyresSteps.checkTyreUseCode("2B");
        tyresSteps.pressBackButton();

    }

    @Title("CVSB-6990 - AC 3 Action fields navigate to the correct pages (HGV Additional Vehicle Details Screen)")
    @Test
    public void tesTrlAdditionalVehicleDetailsScreen() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.selectTrailerDetails();
        trailerDetailsSteps.scrollTheDetailPage("Make");
        trailerDetailsSteps.selectAdditionalDetails();
        additionalVehicleDetailsSteps.checkNtaNumberIs("123456");
        additionalVehicleDetailsSteps.checkConversionNumberIs("7891234");
        additionalVehicleDetailsSteps.checkRoadFriendlyIs("Yes");
        additionalVehicleDetailsSteps.checkDrawbarCouplingFittedIs("Yes");
        additionalVehicleDetailsSteps.checkSuspensionTypeIs("Y");
        additionalVehicleDetailsSteps.checkCouplingTypeIs("F");
        additionalVehicleDetailsSteps.checkDimensionLengthIs("7500");
        additionalVehicleDetailsSteps.checkDimensionWidthIs("2200");
        additionalVehicleDetailsSteps.checkOneTwoIs("1200");
        additionalVehicleDetailsSteps.checkFrontAxleCentreToRearIs("1700");
        additionalVehicleDetailsSteps.checkRearAxleCentreToRearIs("400");
        additionalVehicleDetailsSteps.checkCouplingCentreToRearAxleMinIs("1000");
        additionalVehicleDetailsSteps.checkCouplingCentreToRearAxleMaxIs("900");
        additionalVehicleDetailsSteps.checkCouplingCentreToRearMinIs("800");
        additionalVehicleDetailsSteps.checkCouplingCentreToRearMaxIs("700");
        additionalVehicleDetailsSteps.checkNotesIsDisplayed();
        additionalVehicleDetailsSteps.checkVehicleTypeIs("trl");
        additionalVehicleDetailsSteps.scrollTheDetailPage("1-2");
        additionalVehicleDetailsSteps.checkEuVehicleCategoryIsDisplayed();
        additionalVehicleDetailsSteps.checkCountryOfRegistration("gb");
        additionalVehicleDetailsSteps.pressBackButton();

    }
}
