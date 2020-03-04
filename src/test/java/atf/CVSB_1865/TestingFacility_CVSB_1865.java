package atf.CVSB_1865;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;


@RunWith(SerenityRunner.class)
public class TestingFacility_CVSB_1865 extends BaseTestClass {

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
    public void testSitesList() {

        launchSteps.clickGetStarted();
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

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1856 - AC3 - Select testing facility")
    public void testTestingFacilities() {

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressPhoneNumber(atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.checkCallPopUp(atfService.getAtfByIndex(0).getAtfContactNumber());
    }

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1865 - AC4 - VSA is able to return to the Testing facilities search results")
    public void testTestingFacilitiesSearchResults() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressBackButton();
        searchForAnATFSteps.checkAtfPageDisplay();
    }

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1865 - AC5 - VSA is able to confirm the selected testing facility")
    public void testTestingFacilitiesConfirmedByVsa() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
        siteVisitSteps.checkSiteVisitPage();
    }

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1865 - AC6 - VSA is able to confirm and proceed with the visit ")
    public void testTestingFacilitiesConfirmedAndProceededByVsa() {
        launchSteps.clickGetStarted();
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

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1865 - AC7 - VSA is able to confirm that the site is not suitable for testing ")
    public void testTestingFacilitiesNotSuitableForTesting() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressStartVisit();
        atfDetailsSteps.pressReportIssueInStartVisitPopUp();
        atfDetailsSteps.checkReportIssuePopUp();
    }

    @Ignore("ignore until ticket is merged in develop")
    @Title("CVSB - 1865 - AC8 - Submit a test - test certificate and history fields ")
    public void testSubmitTestAndViewCertificateAndHistory() {
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");
        vehicleDetailsSteps.selectVehicleTestHistory();
        testHistorySteps.selectTestAtPosition("Annual test", 0);
        testHistoryDetailsSteps.checkDetails("TEST TYPE", "NOTES", "Abshire-Kub", "09-4129632", "Great Britain and Northern Ireland", "Cvs.automation4@Dvsagov.onmicrosoft.com");
    }
}
