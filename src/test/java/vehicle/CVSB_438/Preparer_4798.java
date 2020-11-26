package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.composed.PreparerComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class Preparer_4798 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB_438 - AC 4 Select preparer and cancel")
    public void selectPreparerAndCancel() {
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.searchForPreparerId("AK4434");
        preparerSteps.preparerIsFound("AK4434");
        preparerSteps.cancelInPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
    }
}
