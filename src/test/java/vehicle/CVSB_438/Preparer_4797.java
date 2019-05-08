package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Preparer_4797 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Title("CVSB_438 - AC 3 Select preparer and confirm")
    @Test
    public void searchPreparer() {
        preparerComp.goToSelectPreparer();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.searchForPreparerId("AK4434");
        preparerSteps.preparerIsFound("AK4434");
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();
        testSteps.checkNoIdentifyVehicleOptionAvailable();
    }
}
