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
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerComp preparerComp;

    @Step
    public void goToInitialTestTypeCategoryList() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("aa12bcd");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
        testSteps.addTestType();
    }

    @Step
    public void goToTestPage() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
    }
}
