package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import steps.*;

public class TestTypeCategoryComp extends ScenarioSteps {

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
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Step
    public void goToTestType(String preparerId, String preparerName, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        // identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        identifyVehicleSteps.searchForVehicle("678410");
        identifyVehicleSteps.checkVehicleNotFoundPopUpNotShown();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerId);
        testSteps.addTestType();
    }

    @Step
    public void goToTestTypeUsingSpecificVin(String preparerId, String preparerName, String vin, String username) {
        launchSteps.clickGetStarted(username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle(vin);
        identifyVehicleSteps.checkVehicleNotFoundPopUpNotShown();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerId);
        testSteps.addTestType();
    }

    @Step
    public void goToTestPage(String preparerId, String preparerName, String username) {
        preparerComp.goToSelectPreparer(username);
        preparerSteps.selectAndConfirmPreparerId(preparerId);
    }

    @Step
    public void goToTestPageBySelectingASpecificVehicle(String vehiclePartialVin, String username) {
        preparerComp.goToSelectPreparerForASpecificVehicle(vehiclePartialVin, username);
    }

    @Step
    public void goToTestPageBySelectingASpecificTrailer(String trailerPartialVin, String username) {
        preparerComp.goToSelectPreparerForASpecificTrailer(trailerPartialVin, username);
    }

    @Step
    public void completeAddTestType(String preparerId, String preparerName, String username) {
        goToTestType(preparerId, preparerName, username);
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
    }

    @Step
    public void completeAddTestType(String preparerId, String preparerName,String testType, String username) {
        goToTestType(preparerId, preparerName, username);
        testTypeCategorySteps.selectFromTestTypeList(testType);
    }

    @Step
    public void goToTestPageBySelectingASpecificCar(String vehiclePartialVin, String username) {
        preparerComp.goToSelectPreparerForASpecificCar(vehiclePartialVin, username);
    }

    @Step
    public void waitUntilPageIsLoaded() {
        testTypeCategorySteps.waitUntilPageIsLoaded();
    }
}
