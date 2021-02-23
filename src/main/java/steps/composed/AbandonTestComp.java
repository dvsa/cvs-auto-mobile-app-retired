package steps.composed;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;

public class AbandonTestComp extends ScenarioSteps {

    @Steps
    TestSteps testSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Step
    public void goToAbandonTestScreen(SelectReasonPage.Reasons... reasons) {
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testSteps.scrollDown();
        testSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(reasons);
        selectReasonSteps.pressNextButton();

    }
}
