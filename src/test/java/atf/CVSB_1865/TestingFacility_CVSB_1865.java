package atf.CVSB_1865;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
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

    @Title("CVSB - 1865 - AC1 - Sites list + AC2 - No search results")
    @Test
    public void testSitesList(){

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

    @Title("CVSB - 1856 - AC3 - Select testing facility")
    @Test
    public void testTestingFacilities(){

        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.pressPhoneNumber(atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.checkCallPopUp(atfService.getAtfByIndex(0).getAtfContactNumber());
    }

    @Title("CVSB - 1865 - AC4 - VSA is able to return to the Testing facilities search results")
    @Test
    public void testTestingFacilitiesSearchResults(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        searchForAnATFSteps.clickBackButton();
        searchForAnATFSteps.checkAtfPageDisplay();
    }

    @Title("CVSB - 1865 - AC5 - VSA is able to confirm the selected testing facility")
    @Test public void testTestingFacilitiesConfirmedByVsa(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.checkTestFacilitiesDetailsPageDisplayed();
        atfDetailsSteps.checkAtfDetails(atfService.getAtfByIndex(0).getAtfName(), atfService.getAtfByIndex(0).getAtfNumber(),
                atfService.getAtfByIndex(0).getAtfAddress(), atfService.getAtfByIndex(0).getAtfContactNumber());
        atfDetailsSteps.startVisit();
    }

    @Title("CVSB - 1865 - AC6 - VSA is able to confirm and proceed with the visit ")
    @Test public void testTestingFacilitiesConfirmedAndProceededByVsa(){
        launchSteps.clickGetStarted();
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
    }




}
