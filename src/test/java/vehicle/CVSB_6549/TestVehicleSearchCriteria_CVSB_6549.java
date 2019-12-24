package vehicle.CVSB_6549;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import util.BaseTestClass;
import util.SearchCriteria;

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

    @Title("CVSB-6549 - AC1 Search criteria selector displayed on the search vehicle screen")
    @Test
    public void testVehicleSearchCriteria() {
        launchSteps.clickGetStarted();
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
        identifyVehicleSteps.searchForVehicle("ceva ce nu exista");
        identifyVehicleSteps.checkVehicleNotFoundPopUp();

    }

}
