package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1012 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Steps
    TestSteps testSteps;

    @Title("CVSB_181 - AC4 Confirm no preparer information given")
    @Ignore("This is not a valid test case anymore due to CVSB-438")
    @Test
    public void confirmNoPreparerInformationGiven() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.advanceWithNoPreparerInformation();
        testSteps.checkPageTitleDisplayed();
    }
}
