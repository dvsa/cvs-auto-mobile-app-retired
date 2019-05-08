package vehicle.CVSB_438;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.PreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class Preparer_4804 extends BaseTestClass {
    @Steps
    PreparerComp preparerComp;

    @Steps
    PreparerSteps preparerSteps;

    @Title("CVSB_438 -  AC 10 Press Cancel on popup")
    @Test
    public void searchAgainInPreparerNotFoundPopUp() {
        preparerComp.goToSelectPreparer();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.searchForPreparerId("Durrell");
        preparerSteps.noPreparerFound();
        preparerSteps.searchAgainForPreparer();
        preparerSteps.searchForPreparerId("ak 44 34");
        preparerSteps.preparerIsFound("AK4434");
    }
}
