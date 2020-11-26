package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1077 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TyresSteps tyresSteps;

    @Title("CVSB-185 - AC5 - Fields displayed on the app (Weights and Tyres) are contextually sensitive based on technical record of the vehicle required")
    @Test
    public void testWeightsAndTyresFieldsBasedOnContext() {
        //TO DO Refactor after mock date is added
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkDetails("5018", "7100", "7100", "7100",
                "13315", "17140", "18000", "19000", "0");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkDetails("295/80-22.5", "A", "single", "0", "j",
                "456");
        tyresSteps.pressBackButton();
    }
}
