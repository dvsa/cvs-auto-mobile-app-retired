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
public class Search_CVSB_1896 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB-184 - AC1 - Search by registration number does return the correct vehicle")
    @Test
    public void testSearchByLastDigitsVin() {
        vehicleComp.goToIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");
    }
}
