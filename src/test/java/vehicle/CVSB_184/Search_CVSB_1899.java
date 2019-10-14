package vehicle.CVSB_184;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Search_CVSB_1899 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-184 - AC3 - VSA searches by the last six digits of the VIN number instead")
    @Test
    public void testSearchByLastDigitsVin() {
        vehicleComp.goToIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("678410");
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");
    }
}
