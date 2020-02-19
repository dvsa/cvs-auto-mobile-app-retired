package vehicle.CVSB_3826;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class NewScreenDesignsTrl extends BaseTestClass {

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

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Title("CVSB-6170 - CVSB-6407 - CVSB-6520 - AC2 New screen design for adding a vehicle after confirming a HGV")
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

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6176 - AC3 Negative test - screen should remain the same following the confirmation of a Trailer")
    @Test
    public void testNewDesignIdentifyTrailerForTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("341234");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTrailerTestDetails("C000001", "T12341234");
        testSteps.checkAddAVehicleButtonVisibility();
        testSteps.clickAddAVehicleButton();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxAndText("Enter registration number, trailer ID or VIN");
        identifyVehicleSteps.clickCancel();
    }

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-6185 - CVSB-6186 - AC 5 Search for vehicle (Trailer ID)")
    @Test
    public void testNewDesignSearchForATrailer() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("341234");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
    }

    @Title("CVSB-6189 - CVSB-6186 - AC 6.1 Vehicle found in system (tech-record details screen)")
    @Test
    public void testNewDesignVehicleDetails() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("341234");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
        trailerDetailsSteps.waitUntilPageIsLoaded();
        trailerDetailsSteps.checkVinChassisNumberIs("T12341234");
        trailerDetailsSteps.checkMakeIs("Isuzu");
        trailerDetailsSteps.checkModelIs("F06");
        trailerDetailsSteps.checkBodyTypeIs("petrol/oil tanker");
        trailerDetailsSteps.checkYearOfManufactureIs("2018");
        trailerDetailsSteps.checkDateOfFirstUseIs("24/06/2019");
        trailerDetailsSteps.checkAxleIs("2");
        trailerDetailsSteps.checkDtpIs("sdsdg");
        trailerDetailsSteps.checkTrailerTestHistoryIsDisplayed();
        trailerDetailsSteps.checkWeightsIsDisplayed();
        trailerDetailsSteps.checkTyresIsDisplayed();
        trailerDetailsSteps.checkAdditionalVehicleDetailsIsDisplayed();
        trailerDetailsSteps.checkBrakesIsDisplayed();
    }

    @Title("CVSB-6190 - CVSB-6191 - AC 6.2 Vehicle not found in system (pop-up shown) (press OK)")
    @Test
    public void testNewDesignVehicleNotFound() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.searchForVehicle("012930");
        identifyVehicleSteps.checkLoadingScreen();
        identifyVehicleSteps.checkVehicleNotFoundPopUp();
        identifyVehicleSteps.pressOkInPopUp();

    }

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6192 - AC 6.3 Multiple vehicles found (pop-up shown)")
    @Test
    public void testNewDesignMultipleVehicleFound() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.searchForVehicle("0123");
        identifyVehicleSteps.checkLoadingScreen();
        identifyVehicleSteps.checkVehicleNotFoundPopUp();
        identifyVehicleSteps.pressOkInPopUp();

    }

}