package testresults.CVSB_9644;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CountryOfRegistrationNonMandatory_CVSB_9644 extends BaseTestClass {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    SearchForAnATFSteps searchForAnATFSteps;

    @Steps
    ATFDetailsSteps atfDetailsSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Title("CVSB-9644 - AC1 - Country of registration is null")
    @Test
    public void testCountryOfRegistrationNull() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("220222");
        trailerDetailsSteps.scrollTheDetailPage();
        trailerDetailsSteps.selectTrailerTestHistory();
        testHistorySteps.selectTestTypeRecord("First test");
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkElementValue("TEST TYPE", "First Test");
        testHistoryDetailsSteps.checkElementValue("Test result", "PASS");
        testHistoryDetailsSteps.scrollDown();
        testHistoryDetailsSteps.checkElementValue("Country of registration", "EU vehicle category");
    }

    @Title("CVSB-9644 - AC2 - Country of registration is not present")
    @Test
    public void testCountryOfRegistrationMissing() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("220223");
        vehicleDetailsSteps.scrollTheDetailPage();
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.selectTestTypeRecord("With linked test");
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkElementValue("TEST TYPE", "Low Emissions Certificate (LEC) With Annual Test");
        testHistoryDetailsSteps.checkElementValue("Test result", "FAIL");
        testHistoryDetailsSteps.scrollDown();
        testHistoryDetailsSteps.checkElementValue("Country of registration", "EU vehicle category");
    }
}
