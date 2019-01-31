package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1077 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Title("CVSB-185 - AC5 - Fields displayed on the app (Weights and Tyres) are contextually sensitive based on technical record of the vehicle required")
    @Test
    public void testWeightsAndTyresFieldsBasedOnContext() {
        vehicleComp.goToVehicleDetails();
        // TODO implement the test case when we have relevant data
    }
}
