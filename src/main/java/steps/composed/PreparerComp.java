package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.*;

public class PreparerComp extends ScenarioSteps {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    CarDetailsSteps carDetailsSteps;

     @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Step
    public void goToSelectPreparer(String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
    }

    @Step
    public void goToSelectPreparerForASpecificVehicle(String vin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle(vin);
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
    }

    @Step
    public void goToSelectPreparerForASpecificVehicleUsingPartialVin(String partialVin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.setSearchCriteria("Partial VIN (last 6 characters)");
        identifyVehicleSteps.searchForVehicle(partialVin);
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
    }

    @Step
    public void goToSelectPreparerForASpecificTrailer(String partialVin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle(partialVin);
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
    }

    @Step
    public void goToSelectPreparerForASpecificCar(String carPartialVin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle(carPartialVin);
        carDetailsSteps.selectConfirmButtonTopRight();
        carDetailsSteps.selectConfirmFromPopUp();
    }
}
