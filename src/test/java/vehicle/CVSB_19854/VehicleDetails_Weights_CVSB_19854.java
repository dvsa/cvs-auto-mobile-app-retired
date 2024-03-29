package vehicle.CVSB_19854;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_Weights_CVSB_19854 extends BaseTestClass {

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    HgvDetailsSteps hgvDetailsSteps;

    @Steps
    VehicleComp vehicleComp;

    @Title("CVSB-19854 - AC 1 axles should be in ascending order")
    @Test
    public void WeightsAxleOrder() {
        vehicleComp.goToVehicleDetails("012938", super.username);
        hgvDetailsSteps.scrollTheDetailPage("VIN / Chassis number");
        hgvDetailsSteps.selectWeights();
        weightsSteps.checkFieldIsListed("AXLE 1");
        weightsSteps.checkFieldIsListed("AXLE 2");
        weightsSteps.checkFieldIsListed("AXLE 3");
        // checking the axle order
        weightsSteps.checkAxleOrderStep("AXLE 1", "AXLE 2");
        weightsSteps.checkAxleOrderStep("AXLE 2", "AXLE 3");
    }
}
