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
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
    }

    @Step
    public void goToSelectPreparerForASpecificVehicle(String vin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.waitUntilPageIsLoaded();
        identifyVehicleSteps.searchForVehicle(vin);
        vehicleDetailsSteps.waitUntilPageIsLoaded();
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
        vehicleDetailsSteps.waitUntilPageIsLoaded();
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
        trailerDetailsSteps.waitUntilPageIsLoaded();
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
        carDetailsSteps.waitUntilPageIsLoaded();
        carDetailsSteps.selectConfirmButtonTopRight();
        carDetailsSteps.selectConfirmFromPopUp();
    }
}
