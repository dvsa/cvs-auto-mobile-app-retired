package vehicle.CVSB_184;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Search_CVSB_1898 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("TCA - AC3 - VSA searches by full VIN number instead")
    @Test
    public void testSearchByVIN() {
        vehicleComp.goToIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91YHQ");
    }
}

