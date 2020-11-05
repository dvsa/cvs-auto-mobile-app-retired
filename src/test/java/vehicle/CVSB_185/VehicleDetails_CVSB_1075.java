package vehicle.CVSB_185;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class VehicleDetails_CVSB_1075 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    BrakesSteps brakesSteps;

    @Steps
    WeightsSteps weightsSteps;

    @Steps
    TyresSteps tyresSteps;

    @Steps
    AdditionalVehicleDetailsSteps additionalVehicleDetailsSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-185 - AC3 - VSA cannot update technical record")
    public void testCannotUpdateTechRecords() {
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        // TODO add Vehicle Test History part after bug fix
        vehicleDetailsSteps.selectBrakes();
        // TODO check rest of Brakes data after bug fix
        brakesSteps.checkIfFieldIsNotEditable("171202");
        brakesSteps.pressBackButton();
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkIfFieldIsNotEditable("5018");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkIfFieldIsNotEditable("A");
        tyresSteps.pressBackButton();
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkIfFieldIsNotEditable("20/12/2010");
    }
}
