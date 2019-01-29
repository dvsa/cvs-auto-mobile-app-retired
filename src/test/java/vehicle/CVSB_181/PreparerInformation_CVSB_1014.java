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
public class PreparerInformation_CVSB_1014 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC2 No preparer information given")
    @Test
    public void confirmNoPreparerInformationGiven() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.noPreparerInformationGiven();
    }
}
