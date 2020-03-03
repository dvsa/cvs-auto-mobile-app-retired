package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1031 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Ignore("[CVSB-8416] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-183 - AC4 VSA tries to search without entering a Registration Number or a VIN number")
    public void testVehicleSearchWithoutEnteringVinOrRegPlate() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkVehicleNotFoundPopUp();
        identifyVehicleSteps.pressOkInPopUp();
        identifyVehicleSteps.checkVehicleNotFoundPopUpDismissed();

    }
}
