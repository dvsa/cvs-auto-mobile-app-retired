package vehicle.CVSB_12013;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.PreparerComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SearchUsingVin_SpecialCharactersl_CVSB_12013 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    PreparerComp preparerComp;

    @Title("CVSV-12013 - TC1 - AC1 FE VSA performs a vehicle search (Partial VIN)")
    @Test
    public void testSearchUsingVin_FPartialVin() {
        preparerComp.goToSelectPreparerForASpecificVehicleUsingPartialVin("1/\\*-1",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTestDetails("AB12CDE", "YV31ME00000 1/\\*-1");
    }

    @Title("CVSV-12013 - TC2 - AC1 FE VSA performs a vehicle search (Full VIN)")
    @Test
    public void testSearchUsingVin_FullVin() {
        preparerComp.goToSelectPreparerForASpecificVehicle("YV31ME00000 1/\\*-1",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkTestDetails("AB12CDE", "YV31ME00000 1/\\*-1");
    }
}
