package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;
import steps.*;

public class AbandonTestComp extends ScenarioSteps {

    @Steps
    TestSteps testSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Step
    public void goToAbandonTestScreen(SelectReasonPage.Reasons... reasons) {
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(reasons);
        selectReasonSteps.pressNextButton();

    }
}
