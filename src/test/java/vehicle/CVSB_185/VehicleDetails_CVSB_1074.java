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
public class VehicleDetails_CVSB_1074 extends BaseTestClass {

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

    @Title("CVSB-185 - AC2 - VSA views expandable technical record fields")
    @Test
    public void testExpandableTechRecordFields() {
        vehicleComp.goToVehicleDetails(super.username);
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        // TODO add Vehicle Test History part after bug fix
        vehicleDetailsSteps.selectBrakes();
        // TODO check rest of Brakes data after bug fix
        brakesSteps.checkDetails("171202", "None", "None",
                "None", "exhaust", "exhaust");
        brakesSteps.pressBackButton();
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkDetails("5018", "7100", "7100", "7100",
                "13315", "17140", "18000", "19000", "0");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkDetails("295/80-22.5", "A", "single", "0", "j",
                "456");
        tyresSteps.pressBackButton();
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkDetails("20/12/2010", "7", "2",
                "0", "50", "0", "0",
                "No", "No", "None", "None");
        additionalVehicleDetailsSteps.pressBackButton();
    }
}
