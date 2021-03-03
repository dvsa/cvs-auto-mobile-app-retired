package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1141 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-185 - AC1 - VSA searches by VIN number")
    public void testSearchByVIN() {
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");
    }
}
