package vehicle.CVSB_182;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.SelectPreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleConfirm_CVSB_722 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    PreparerSteps preparerSteps;


    @Title("CVSB-182 - AC2 VSA further confirms")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testVehicleDetailsFurtherConfirmation() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectConfirmButtonTopRight();
        vehicleDetailsSteps.checkConfirmationPopUp();
        vehicleDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
    }
}
