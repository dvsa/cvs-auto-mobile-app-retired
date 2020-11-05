package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class Preparer_4802 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB_438 - AC 8 Click 'Confirm' on popup")
    public void confirmWithoutPreparerFromPopUp() {
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.startTest();
        preparerSteps.advanceWithoutPreaprer();
        preparerSteps.confirmInPopUp();
        testSteps.checkPageTitleDisplayed();
    }
}
