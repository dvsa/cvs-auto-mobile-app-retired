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
public class VehicleDetails_CVSB_1074 extends BaseTestClass {

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

    @Title("CVSB-185 - AC2 - VSA views expandable technical record fields")
    @Test
    public void testExpandableTechRecordFields() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.scrollTheDetailPage("Chassis make");
        // TODO add Vehicle Test History part after bug fix
        vehicleDetailsSteps.selectBrakes();
        // TODO check rest of Brakes data after bug fix
        brakesSteps.checkDetails("1jU6", "oaCS4aZ5UGGZT", "bmsZLJjBZFRMu3",
                "KeQHRwq9", "friction", "exhaust");
        brakesSteps.pressBackButton();
        vehicleDetailsSteps.selectWeights();
        weightsSteps.checkDetails("53850", "6383", "40343", "30923",
                "20445", "82879", "85025", "71125", "0");
        weightsSteps.pressBackButton();
        vehicleDetailsSteps.selectTyres();
        tyresSteps.checkDetails("4IHi7", "E9", "single", "416", "J",
                "1355");
        tyresSteps.pressBackButton();
        vehicleDetailsSteps.selectAdditionalVehicleDetails();
        additionalVehicleDetailsSteps.checkDetails("07/12/1991", "pP", "S5J9z",
                "986", "57", "251", "29",
                "true", "true", "3UZnR", "bof1ikLSURNJi0oxHdAmyo1");
        additionalVehicleDetailsSteps.pressBackButton();
    }
}
