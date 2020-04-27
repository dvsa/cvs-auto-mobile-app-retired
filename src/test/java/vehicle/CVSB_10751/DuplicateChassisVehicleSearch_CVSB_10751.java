package vehicle.CVSB_10751;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;



@RunWith(SerenityRunner.class)
public class DuplicateChassisVehicleSearch_CVSB_10751 extends BaseTestClass {
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
    SelectVehicleSteps selectVehicleSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
   TestHistorySteps testHistorySteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB - 10751 - AC1 Single vehicle retrieved, access vehicle details")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testSingleVehicleDetails(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("000000");
        vehicleDetailsSteps.checkPageTitle();
        selectVehicleSteps.checkBackCta("arrow back Identify vehicle");
        selectVehicleSteps.pressBackCta();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
    }

    @Title("CVSB - 10752 - AC2 Single vehicle retrieved - go back from vehicle details")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testGoBackToSingleVehicleList(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("000000");
        vehicleDetailsSteps.checkPageTitle();
        selectVehicleSteps.checkBackCta("arrow back Identify vehicle");
    }

    @Title("CVSB - 10751 - AC3 Multiple vehicles retrieved, access vehicle list")
    @Test
    public void testMultipleVehicleAccessList() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("484009");
        selectVehicleSteps.waitUntilPageIsLoaded();
        selectVehicleSteps.multipleVehicleDisplayed();
        selectVehicleSteps.checkPageTitle();
        selectVehicleSteps.checkVehicleDetails();
        selectVehicleSteps.checkBackCta("arrow back Identify vehicle");
        selectVehicleSteps.selectTrailer();
        trailerDetailsSteps.waitUntilPageIsLoaded();
        trailerDetailsSteps.checkPageTitle();
        trailerDetailsSteps.selectTrailerTestHistory();
        testHistorySteps.checkNoTestHistoryIsDisplayed();
    }

    @Title("CVSB - 10751 - AC4 Multiple vehicles retrieved, access vehicle details & AC5 Multiple vehicles retrieved - go back from vehicle details")
    @Test
    public void testMultipleVehicleDetails(){

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("484009");
        selectVehicleSteps.waitUntilPageIsLoaded();
        selectVehicleSteps.checkPageTitle();
        selectVehicleSteps.multipleVehicleDisplayed();
        selectVehicleSteps.checkVehicleDetails();
        selectVehicleSteps.selectTrailer();
        trailerDetailsSteps.checkPageTitle();
        trailerDetailsSteps.checkSelectVehicleCta("arrow back Select vehicle");
        trailerDetailsSteps.pressSelectVehicleCta();
        selectVehicleSteps.multipleVehicleDisplayed();
        selectVehicleSteps.checkPageTitle();
        selectVehicleSteps.checkVehicleDetails();
        selectVehicleSteps.selectPsv();
    }

    @Title("CVSB - 10751 - AC6 Multiple vehicles retrieved - go back from vehicle list")
    @Test
    public void testGoBackToMultipleVehicleList(){

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("484009");
        selectVehicleSteps.waitUntilPageIsLoaded();
        selectVehicleSteps.multipleVehicleDisplayed();
        selectVehicleSteps.checkPageTitle();
        selectVehicleSteps.checkVehicleDetails();
        selectVehicleSteps.checkBackCta("arrow back Identify vehicle");
        selectVehicleSteps.pressBackCta();
        identifyVehicleSteps.checkIdentifyVehicleTitleIsDisplayed();
        identifyVehicleSteps.checkSearchBoxIsDisplayed();
    }
}
