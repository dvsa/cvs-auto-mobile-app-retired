package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AbandonTestPage;
import pages.SelectReasonPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AbandonTestSteps extends ScenarioSteps {
    AbandonTestPage abandonTestPage;
    SelectReasonPage selectReasonPage;

    @Step
    public void checkAbandonTestPage() {
        abandonTestPage.waitUntilPageIsLoaded();
        assertThat(abandonTestPage.isPageTitleDisplayed()).isTrue();
        assertThat(abandonTestPage.isReasonsListTitleDisplayed()).isTrue();
    }

    @Step
    public void checkSelectedReasons(SelectReasonPage.Reasons... reasons) {
        List<String> actualDataList = abandonTestPage.findAllValuesByXpath();
        for (SelectReasonPage.Reasons expectedReason : reasons) {
            assertThat(actualDataList.contains(selectReasonPage.getReasonTexts(expectedReason))).isTrue();
        }
    }

    @Step
    public void checkCommentSection() {
        if (!abandonTestPage.isCommentSectionDisplayed())
            abandonTestPage.scrollPageDown();
        assertThat(abandonTestPage.isCommentSectionDisplayed()).isTrue();
    }

}

