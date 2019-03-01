package vehicle.CVSB_365;

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
public class VehicleChange_CVSB_753 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;


    @Title("CVSB-365 - AC1 - Change a vehicle before confirming vehicle details")
    @Test()
    public void testChangeBeforeConfirmVehicleDetails() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.pressBackButton();
        identifyVehicleSteps.searchForVehicle("BQ91YHQ");
        vehicleDetailsSteps.waitUntilPageIsLoaded();
    }


}
