package vehicle;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;
import steps.composed.PreparerComp;
import steps.composed.VehicleComp;

@RunWith(SerenityRunner.class)
public class ChangeAVehicleTest {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    PreparerComp preparerComp;

    @Steps
    TestSteps testSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Managed
    public WebDriver webDriver;

    @Title("CVSB-365 / CVSB-753 - AC1 - Change a vehicle before confirming vehicle details")
    @Test()
    public void testChangeBeforeConfirmVehicleDetails() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.tapIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("aa12bcd");
        vehicleDetailsSteps.waitUntillPageIsloaded();
    }

    @Title("CVSB-365 / CVSB-754 - AC2 - Change a vehicle after confirming vehicle details")
    @Test()
    public void testChangeAVehicleAfterConfirmVehicleDetails() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.tapVehicleDetails();
        vehicleDetailsSteps.tapIdentifyVehicle();
        identifyVehicleSteps.searchForVehicle("aa12bcd");
        vehicleDetailsSteps.waitUntillPageIsloaded();
    }

    @Title("CVSB-365 / CVSB-755 - AC3 - Change a vehicle after selecting a preparer")
    @Test()
    public void testChangeAVehicleAfterSelectingAPreparer() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndConfirm("AK4434", "Durrell Vehicles Limited");
        testSteps.checkNoIdentifyVehicleOptionAvailable();
    }

}
