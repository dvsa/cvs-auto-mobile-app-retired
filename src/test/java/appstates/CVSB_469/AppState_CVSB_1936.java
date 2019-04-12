package appstates.CVSB_469;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AppState_CVSB_1936 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    CommonSteps commonSteps;

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
    TestSteps testSteps;



    @Title("CVSB-469 - AC1 Reopen the app from the background (ex. open another app, press the home button, lock the device)")
    @Test
    public void testAppStateReopenFromBackground() {
        launchSteps.clickGetStarted();
        commonSteps.getPage().runAppInBackground();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        commonSteps.getPage().runAppInBackground();
        atfDetailsSteps.startVisit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commonSteps.getPage().runAppInBackground();
        siteVisitSteps.createNewTest();
        commonSteps.getPage().runAppInBackground();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.waitUntilPageIsLoaded();
        commonSteps.getPage().runAppInBackground();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        commonSteps.getPage().runAppInBackground();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        commonSteps.getPage().runAppInBackground();
        selectPreparerSteps.selectPreparerAndConfirm(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        commonSteps.getPage().runAppInBackground();
        testSteps.addTestType();
        commonSteps.getPage().runAppInBackground();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");

    }
}
