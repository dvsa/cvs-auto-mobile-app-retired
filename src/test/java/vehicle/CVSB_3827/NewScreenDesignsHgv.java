package vehicle.CVSB_3827;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.composed.VehicleComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class NewScreenDesignsHgv extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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


    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-6409 - AC 4 Search for vehicle (last six digits of the VIN)")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testNewDesignSearchForHgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("230123");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
    }

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-6410 - AC 4 Search for vehicle (full VIN)")
    @Test
    public void testNewDesignSearchForHgvFullVin() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("P012301012938");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
    }

    @Title("CVSB-6411 - AC 4 Search for vehicle (registration number)")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testNewDesignSearchForHgvRegistration() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("CT70VRL");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
    }


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-6406 - AC1 New screen design for first vehicle")
    public void testNewDesignVehicleDetailsHgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("012938");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
        hgvDetailsSteps.waitUntilPageIsLoaded();
        hgvDetailsSteps.checkVinChassisNumberIs("P012301012938");
        hgvDetailsSteps.checkMakeIs("Isuzu");
        hgvDetailsSteps.checkModelIs("FM");
        hgvDetailsSteps.checkBodyTypeIs("tipper");
        hgvDetailsSteps.checkFunctionCodeIs("A");
        hgvDetailsSteps.checkYearOfManufactureIs("2018");
        hgvDetailsSteps.checkDateOfFirstRegistrationIs("24/06/2019");
        hgvDetailsSteps.checkAxleIs("3");
        hgvDetailsSteps.checkDtpIs("178202");
        hgvDetailsSteps.checkVehicleTestHistoryIsDisplayed();
        hgvDetailsSteps.checkWeightsIsDisplayed();
        hgvDetailsSteps.checkTyresIsDisplayed();
        hgvDetailsSteps.checkAdditionalVehicleDetailsIsDisplayed();
    }

}