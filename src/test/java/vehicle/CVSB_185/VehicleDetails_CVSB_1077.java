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

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TyresSteps tyresSteps;

    @Title("CVSB-185 - AC5 - Fields displayed on the app (Weights and Tyres) are contextually sensitive based on technical record of the vehicle required")
    @Test
    public void testWeightsAndTyresFieldsBasedOnContext() {
        //TO DO Refactor after mock date is added
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkDetails("53850", "6383", "40343", "30923",
                "20445", "82879", "85025", "71125", "0");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkDetails("4IHi7", "E9", "single", "416", "J",
                "1355");
        tyresSteps.pressBackButton();
    }
}
