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
public class PreparerInformation_CVSB_1137 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC11 Select preparer and cancel")
    @Test
    public void selectPreparer() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndCancel("AK4434", "Durrell Vehicles Limited");
        selectPreparerSteps.checkPageTitle();
    }
}
