package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AbandonedTestPage;
import pages.SelectReasonPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AbandonedTestSteps extends ScenarioSteps {
    AbandonedTestPage abandonedTestPage;
    SelectReasonPage selectReasonPage;

    @Step
    public void checkAbandonedTestPage() {
        abandonedTestPage.waitUntilPageIsLoaded();
        assertThat(abandonedTestPage.isPageTitleDisplayed()).isTrue();
        assertThat(abandonedTestPage.isReasonsListTitleDisplayed()).isTrue();
    }

    @Step
    public void checkSelectedReasons(SelectReasonPage.Reasons... reasons) {
        List<String> actualDataList = abandonedTestPage.findAllValuesByXpath();
        for (SelectReasonPage.Reasons expectedReason : reasons) {
            assertThat(actualDataList.contains(selectReasonPage.getReasonTexts(expectedReason))).isTrue();
        }
    }

    @Step
    public void checkAddedComment(String comment) {
        assertThat(abandonedTestPage.getComment().contains(comment)).isTrue();
    }
}

