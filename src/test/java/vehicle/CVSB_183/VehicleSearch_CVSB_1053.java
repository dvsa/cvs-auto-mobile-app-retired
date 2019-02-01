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
public class VehicleSearch_CVSB_1053 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;


    @Title("CVSB-183 - AC3.1 Vehicle found in system")
    @Test
    public void testVehicleFoundInSystem() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("BQ91YHQ");
        identifyVehicleSteps.checkSearchBoxAndText("BQ91YHQ");
        identifyVehicleSteps.pressSearch();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91YHQ");

    }
}
