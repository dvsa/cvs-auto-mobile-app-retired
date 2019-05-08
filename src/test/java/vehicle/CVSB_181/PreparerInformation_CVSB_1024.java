package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1024 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC1 Scroll through list of preparer IDs")
    @Ignore("This is not a valid test case anymore due to CVSB-438")
    @Test
    public void scrollPreparerIdList() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.checkPreparerPageIsScrollable(
                preparerService.getPreparerByIndex(0).getPreparerId(),
                preparerService.getPreparerByIndex(0).getPreparerName());
    }
}
