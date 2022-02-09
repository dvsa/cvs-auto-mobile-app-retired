package vehicle.CVSB_11547;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import utils.BaseTestClass;


@WithTag("In-test")
@RunWith(SerenityRunner.class)
public class SkeletonRecords_CVSB_11547 extends BaseTestClass {
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

    @Title("CVSB-11547 - AC1 Single vehicle retrieved, skeleton record")
    @Test
    public void testSingleVehicleDetails_SkeletonRecord(){
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.searchForVehicle("778899");

        // Verify that a popup is shown.
        identifyVehicleSteps.waitUntilPopUpShown();
        identifyVehicleSteps.checkIncompleteRecordPopupIsShown();

        // Close the popup by clicking on OK.
        identifyVehicleSteps.pressOkInPopUp();
        identifyVehicleSteps.checkIncompleteRecordPopupIsNotShown();
    }

    @Title("CVSB-11547 - AC2 Multiple vehicles retrieved, at least one skeleton record, CVSB-11547 - AC3 Multiple vehicles retrieved, access vehicle details")
    @Test
    public void testMultipleVehicleDetails_SkeletonRecord(){
        launchSteps.clickGetStarted(super.username);
        searchForAnATFSteps.waitForPageToLoadAndSelectAnAtf("Abshire-Kub 09-4129632");
        atfDetailsSteps.startVisit();
        siteVisitSteps.createNewTest();

        // For vin 223344 there are 2 records: one testable, one skeleton.
        identifyVehicleSteps.searchForVehicle("223344");

        selectVehicleSteps.waitUntilPageIsLoaded();
        selectVehicleSteps.checkSkeletonRecordWarningIsShown();

        selectVehicleSteps.checkVehicleIsShown("VOLVO", "1984", "F12-33");
        selectVehicleSteps.checkIncompleteRecordShown();

        // AC3 Multiple vehicles retrieved, access vehicle details
        selectVehicleSteps.selectIncompleteRecord();

        // Verify that a popup is shown.
        selectVehicleSteps.waitUntilPopUpShown();
        selectVehicleSteps.checkIncompleteRecordPopupIsShown();

        // Close the popup by clicking on OK.
        selectVehicleSteps.pressOkInPopUp();
        selectVehicleSteps.checkIncompleteRecordPopupIsNotShown();
    }
}
