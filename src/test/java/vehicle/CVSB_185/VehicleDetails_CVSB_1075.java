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
public class VehicleDetails_CVSB_1075 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    BreaksSteps brakesSteps;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TyresSteps tyresSteps;

    @Steps
    AdditionalVehicleDetailsSteps additionalVehicleDetailsSteps;

    @Title("CVSB-185 - AC3 - VSA cannot update technical record")
    @Test
    public void testCannotUpdateTechRecords() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        // TODO add Vehicle Test History part after bug fix
        vehicleDetailsSteps.selectBrakes();
        // TODO check rest of Brakes data after bug fix
        brakesSteps.checkIfFieldIsNotEditable("1jU6");
        brakesSteps.pressBackButton();
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkIfFieldIsNotEditable("53850");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkIfFieldIsNotEditable("4IHi7");
        tyresSteps.pressBackButton();
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkIfFieldIsNotEditable("07/12/1991");
    }
}
