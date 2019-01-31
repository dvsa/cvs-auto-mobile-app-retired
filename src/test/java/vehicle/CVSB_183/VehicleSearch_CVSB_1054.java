package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1054 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;


    @Title("CVSB-183 - AC3.2 Vehicle not found in system (Try again)")
    @Test
    public void testVehicleNotFound() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("AAAAAA");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkVehicleNotFoundPopUp();
        identifyVehicleSteps.pressOkInPopUp();
        identifyVehicleSteps.checkVehicleNotFoundPopUpDismissed();

    }
}
