package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1018 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC7 Cancel popup continuing without preparer ID")
    @Test
    public void cancelContinuingWithoutPreparerId() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.searchForInvalidPreparerId("test", "test", "test");
        selectPreparerSteps.cancelAdvanceUsingWithoutPreparerLink();
    }
}
