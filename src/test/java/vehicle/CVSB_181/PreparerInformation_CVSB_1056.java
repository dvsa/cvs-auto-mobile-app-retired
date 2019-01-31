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
public class PreparerInformation_CVSB_1056 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC1 Search for preparer ID with letters and numbers")
    @Test
    public void searchPreparerIdLettersAndNumbers() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.searchForPreparerIdAndCancel("AK", "AK4434", "Durrell Vehicles Limited");
        selectPreparerSteps.searchForPreparerIdAndCancel("9939", "FQ9939", "Tayside Repairs Ltd");
    }
}