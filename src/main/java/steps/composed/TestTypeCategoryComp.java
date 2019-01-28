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
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerComp preparerComp;

    @Step
    public void addTestType() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
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

    @Step()
    public void completeAddTestType() {
        addTestType();
        testTypeCategorySteps.selectFromTestTypeList("annual test");
    }
}
