package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SelectReasonPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectReasonSteps extends ScenarioSteps {
    SelectReasonPage selectReasonPage;

    @Step
    public void checkSelectReasonPage() {
        selectReasonPage.waitUntilPageIsLoaded();
        assertThat(selectReasonPage.isPageTitleDisplayed() && selectReasonPage.isTextTipDisplayed()).isTrue();
    }

    @Step
    public void pressBackButton() {
        selectReasonPage.clickOnBackButton();
    }
}
