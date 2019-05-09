package appstates.CVSB_469;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;
import util.TestHandler;

@RunWith(SerenityRunner.class)
public class AppState_CVSB_1939  extends BaseTestClass {

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
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    CancelTestSteps cancelTestSteps;

    @Before
    public void goEnable() {
        TestHandler.testTypeEnabledCached().set(true);
    }

    @After
    public void tearDown() {
        TestHandler.testTypeEnabledCached().set(false);
    }

    @Title( "CVSB-469 - AC4 Reopen the app after it was closed - redirected to test screen (ex. app closed by the user, app closed by the device, device turned off)")
    @Test
    public void testAppStateCloseAtTestPage() {

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf(atfService.getUniqueIdentifier(0));
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.selectAndConfirmPreparerId(preparerService.getPreparerByIndex(0).getPreparerId());
        testSteps.waitUntilPageIsLoaded();
        commonSteps.getPage().closeAndLaunchApp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");

        testSteps.waitUntilPageIsLoaded();
        testSteps.pressCancelBottomRight();
        cancelTestSteps.checkPageDetails();
        cancelTestSteps.addReasonForCancellation("Automation Test");
        cancelTestSteps.pressSubmit();
        cancelTestSteps.pressSubmitInPopUp();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.completeEndVisit();

    }

}
