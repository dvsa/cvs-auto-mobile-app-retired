package vehicle.CVSB_3827;

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
public class NewScreenDesignsHgv extends BaseTestClass {

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
    @Test
    public void testNewDesignSearchForHgv() {
        launchSteps.clickGetStarted();
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
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
        identifyVehicleSteps.typeInSearchField("P012301012938");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
    }

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-6411 - AC 4 Search for vehicle (registration number)")
    @Test
    public void testNewDesignSearchForHgvRegistration() {
        launchSteps.clickGetStarted();
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
    @Test
    public void testNewDesignVehicleDetailsHgv() {
        launchSteps.clickGetStarted();
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