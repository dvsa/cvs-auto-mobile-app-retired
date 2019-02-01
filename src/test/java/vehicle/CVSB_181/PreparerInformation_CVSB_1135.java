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
public class PreparerInformation_CVSB_1135 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC9 Select preparer")
    @Test
    public void selectPreparer() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.checkPreparerPopUp(
                preparerService.getPreparerByIndex(0).getPreparerId(),
                preparerService.getPreparerByIndex(0).getPreparerName());
    }
}
