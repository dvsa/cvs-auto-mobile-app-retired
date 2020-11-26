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
public class Preparer_4804 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB_438 -  AC 10 Press Cancel on popup")
    public void searchAgainInPreparerNotFoundPopUp() {
        preparerComp.goToSelectPreparer(super.username);
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.searchForPreparerId("Durrell");
        preparerSteps.noPreparerFound();
        preparerSteps.searchAgainForPreparer();
        preparerSteps.searchForPreparerId("ak 44 34");
        preparerSteps.preparerIsFound("AK4434");
    }
}
