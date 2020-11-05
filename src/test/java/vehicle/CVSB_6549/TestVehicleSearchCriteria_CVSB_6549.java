package vehicle.CVSB_6549;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;
import data.util.SearchCriteria;

@RunWith(SerenityRunner.class)
public class TestVehicleSearchCriteria_CVSB_6549 extends BaseTestClass {

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
    SearchCriteriaSteps searchCriteriaSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Title("CVSB-6549 - AC1 Search criteria selector displayed on the search vehicle screen")
    @Test
    public void testVehicleSearchCriteria() {
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.checkSearchCriteriaSectionIsDisplayed();
        identifyVehicleSteps.checkSearchCriteriaButtonIsSelected(SearchCriteria.ALL);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.ALL);

        identifyVehicleSteps.clickSearchCriteriaButton();
        searchCriteriaSteps.checkTitleIsDisplayed();
        searchCriteriaSteps.checkSearchCriteriaOptionsAreDisplayed();
        searchCriteriaSteps.selectSearchCriteria(SearchCriteria.PARTIAL_VIN);
        identifyVehicleSteps.checkSearchCriteriaButtonIsSelected(SearchCriteria.PARTIAL_VIN);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.PARTIAL_VIN);
        identifyVehicleSteps.searchForVehicle("293847");
        vehicleDetailsSteps.checkVinChassisNumber("P012301293847");
        vehicleDetailsSteps.pressBackButton();

        identifyVehicleSteps.clickSearchCriteriaButton();
        searchCriteriaSteps.selectSearchCriteria(SearchCriteria.REGISTRATION_NUMBER);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.REGISTRATION_NUMBER);
        identifyVehicleSteps.searchForVehicle("CO79ERT");
        vehicleDetailsSteps.checkRegistrationNumber("CO79 ERT");
        vehicleDetailsSteps.checkVinChassisNumber("P012301293847");
        vehicleDetailsSteps.pressBackButton();

        identifyVehicleSteps.clickSearchCriteriaButton();
        searchCriteriaSteps.selectSearchCriteria(SearchCriteria.FULL_VIN);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.FULL_VIN);
        identifyVehicleSteps.searchForVehicle("P012301000000");
        vehicleDetailsSteps.checkRegistrationNumber("AA00 AAA");
        vehicleDetailsSteps.pressBackButton();

        identifyVehicleSteps.clickSearchCriteriaButton();
        searchCriteriaSteps.selectSearchCriteria(SearchCriteria.TRAILER_ID);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.TRAILER_ID);
        identifyVehicleSteps.searchForVehicle("D000001");
        trailerDetailsSteps.checkVinChassisNumberIs("T12765432");
        trailerDetailsSteps.pressBackButton();

        identifyVehicleSteps.clickSearchCriteriaButton();
        searchCriteriaSteps.selectSearchCriteria(SearchCriteria.FULL_VIN);
        identifyVehicleSteps.checkSearchBoxAndText(SearchCriteria.FULL_VIN);
        identifyVehicleSteps.searchForVehicle("000000");
        identifyVehicleSteps.checkVehicleNotFoundPopUp();

    }

}
