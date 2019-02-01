package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1154 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-183 - AC2 Search for vehicle using last six-digits of the VIN number")
    @Test
    public void testSearchUsingSixDigitVIN() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("678410");
        identifyVehicleSteps.checkSearchBoxAndText("678410");
        identifyVehicleSteps.pressSearch();
        identifyVehicleSteps.checkLoadingScreen();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91YHQ");

    }
}
