package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1066 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;


    @Title("CVSB-185 - AC1 - VSA searches by registration number")
    @Test
    public void testSearchByRegistrationNumber() {
        vehicleComp.goToIdentifyVehicle();
        identifyVehicleSteps.typeInSearchField("BQ91YHQ");
        identifyVehicleSteps.checkSearchBoxAndText("BQ91YHQ");
        identifyVehicleSteps.pressSearch();
    }
}
