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
public class Preparer_4805 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Title("CVSB_438 - AC 1 VSA searches for preparer ID")
    @Test
    public void cancelInPreparerNotFoundPopUp() {
        preparerComp.goToSelectPreparer();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.searchForPreparerId("Durrell");
        preparerSteps.noPreparerFound();
        preparerSteps.continueInPopUp();
        testSteps.checkPageTitleDisplayed();

    }
}
