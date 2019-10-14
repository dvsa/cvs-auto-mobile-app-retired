package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1028 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-183 - AC2 Search for vehicle using full VIN number")
    @Test
    public void testSearchUsingFullVIN() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("1B7GG36N12S678410");
        identifyVehicleSteps.checkSearchBoxAndText("1B7GG36N12S678410");
        identifyVehicleSteps.pressSearch();
        // identifyVehicleSteps.checkLoadingScreen();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");
    }
}
