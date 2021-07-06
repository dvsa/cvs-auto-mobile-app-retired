package atf.CVSB_1865;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.util.UtilSteps;
import utils.BaseTestClass;


@RunWith(SerenityRunner.class)
public class TestingFacility_CVSB_1865 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;

    @Title("CVSB - 1865 - AC1 - Sites list + AC2 - No search results")
    @Test
    public void testSitesList() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.checkAtfPageDisplay();
        searchForAnATFSteps.checkListIsScrollableByElement(atfService.getUniqueIdentifier(0));
        searchForAnATFSteps.searchForValidPNumberOrAddress("09-4129632");
        searchForAnATFSteps.isTestingFacilityPresentPNumberAndName();
        searchForAnATFSteps.searchForValidPNumberOrAddress("Abshire-Kub");
        searchForAnATFSteps.isTestingFacilityPresentPNumberAndName();
        searchForAnATFSteps.searchForValidPNumberOrAddress("5 Lukken Lane");
        searchForAnATFSteps.isTestingFacilityPresentAddress();
        searchForAnATFSteps.searchAndVerifyForLongAlphanumericNumber();
        searchForAnATFSteps.checkNoResultsFoundAndSuggestion();
    }

    @Title("CVSB - 1856 - AC3 - Select testing facility")
    @Test
    public void testTestingFacilities() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressPhoneNumber(atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.checkCallPopUp(atfService.getAtfByIndex(0).getAtfContactNumber());
    }

    @Title("CVSB - 1865 - AC4 - VSA is able to return to the Testing facilities search results")
    @Test
    public void testTestingFacilitiesSearchResults() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressBackButton();
        searchForAnATFSteps.checkAtfPageDisplay();
    }

    @Title("CVSB - 1865 - AC5 - VSA is able to confirm the selected testing facility")
    @Test
    public void testTestingFacilitiesConfirmedByVsa() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkSiteVisitPage();
    }

    @Title("CVSB - 1865 - AC6 - VSA is able to confirm and proceed with the visit ")
    @Test
    public void testTestingFacilitiesConfirmedAndProceededByVsa() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkSiteVisitPage();
        siteVisitSteps.checkEndVisitButton();
        siteVisitSteps.selectEndVisit();
        siteVisitSteps.checkEndVisitPopUp();
    }

    @Title("CVSB - 1865 - AC7 - VSA is able to confirm that the site is not suitable for testing ")
    @Test
    public void testTestingFacilitiesNotSuitableForTesting() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.pressReportIssueInStartVisitPopUp();
        atfDetailsSteps.checkReportIssuePopUp();
    }

    @Title("CVSB - 1865 - AC8 - Submit a test - test certificate and history fields ")
    @Test
    public void testSubmitTestAndViewCertificateAndHistory() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("T12111000");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.selectTestAtPosition("First test", 0);
        testHistoryDetailsSteps.checkDetails("TEST TYPE", "NOTES", "Abshire-Kub", "09-4129632", "Austria");
    }
}
