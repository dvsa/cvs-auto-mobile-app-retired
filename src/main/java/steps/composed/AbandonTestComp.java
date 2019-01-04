package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;
import steps.*;

public class AbandonTestComp extends ScenarioSteps {

    @Steps
    LaunchSteps launchSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Step
    public void goToAbandonTestScreen(SelectReasonPage.Reasons... reasons) {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkTestDetails();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(reasons);
        selectReasonSteps.pressNextButton();

    }
}
