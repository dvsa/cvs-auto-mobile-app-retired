package vehicle.CVSB_184;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class Search_CVSB_1898 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-184 - AC3 - VSA searches by full VIN number instead")
    public void testSearchByVin() {
        vehicleComp.goToIdentifyVehicle(super.username);
        identifyVehicleSteps.searchForVehicle("1B7GG36N12S678410");
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");
    }
}

