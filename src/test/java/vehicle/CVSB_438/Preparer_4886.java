package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.VehicleDetailsSteps;
import steps.composed.PreparerComp;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Preparer_4886 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Title("CVSB_438 - CVSB-5105 - AC 1 VSA returns to the vehicle details screen")
    @Test
    public void selectPreparer() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.goBackToVehicleDetailsPage();
        vehicleDetailsSteps.checkPageTitle();
    }
}
