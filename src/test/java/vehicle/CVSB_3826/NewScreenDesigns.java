package vehicle.CVSB_3826;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class NewScreenDesigns extends BaseTestClass {

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

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;


    @Title("CVSB-6170 - AC2 New screen design for adding a vehicle after confirming a HGV")
    @Test
    public void testNewDesignIdentifyTrailerForHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012938");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("GH389BH", "P012301012938");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyTrailerSteps.checkSearchBoxAndText("Enter trailer ID or VIN");
        identifyTrailerSteps.clickCancel();
    }

    @Title("CVSB-6176 - AC3 Negative test - screen should remain the same following the confirmation of a Trailer")
    @Test
    public void testNewDesignIdentifyTrailerForTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.checkAddAVehicleButtonVisibility();
        testSteps.clickAddAVehicleButton();
        identifyVehicleSteps.checkIdentitfyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxAndText("Enter registration number, trailer ID or VIN");
        identifyVehicleSteps.clickCancel();
    }
}