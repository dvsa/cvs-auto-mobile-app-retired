package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.composed.PreparerComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1056 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Ignore("This is not a valid test case anymore due to CVSB-438")
    @Title("CVSB_181 - AC1 Search for preparer ID with letters and numbers")
    public void searchPreparerIdLettersAndNumbers() {
        preparerComp.goToSelectPreparer(super.username);
        selectPreparerSteps.searchForPreparerIdAndCancel(
                preparerService.getPreparerByIndex(0).getPreparerId().substring(0, 2),
                preparerService.getPreparerByIndex(0).getPreparerId(),
                preparerService.getPreparerByIndex(0).getPreparerName());

        selectPreparerSteps.searchForPreparerIdAndCancel(
                preparerService.getPreparerByIndex(1).getPreparerId().substring(2),
                preparerService.getPreparerByIndex(1).getPreparerId(),
                preparerService.getPreparerByIndex(1).getPreparerName());

    }
}
