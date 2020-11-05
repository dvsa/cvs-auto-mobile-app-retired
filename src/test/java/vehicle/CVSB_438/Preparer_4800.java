package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class Preparer_4800 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Title("CVSB_438 - AC 5+6 VSA starts test without adding Preparer ID")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void checkWithoutPreparerPopUp() {
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
    }
}
