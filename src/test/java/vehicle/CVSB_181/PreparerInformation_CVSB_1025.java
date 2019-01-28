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
public class PreparerInformation_CVSB_1025 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC1 Search for preparer ID only")
    @Test
    public void searchPreparerIdOnly() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.searchForPreparerIdAndCancel("AK4434", "AK4434", "Durrell Vehicles Limited");
    }
}
