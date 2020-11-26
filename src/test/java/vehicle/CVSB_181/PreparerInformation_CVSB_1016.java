package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1016 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;

    @Ignore("This is not a valid test case anymore due to CVSB-438")
    @Title("CVSB_181 - AC8 Confirm popup continuing without preparer ID")
    public void confirmContinuingWithoutPreparerId() {
        preparerComp.goToSelectPreparer(super.username);
        selectPreparerSteps.searchForInvalidPreparerId("test", "test", "test");
        selectPreparerSteps.advanceUsingWithoutPreparerLink();
        testSteps.checkPageTitleDisplayed();
    }
}
