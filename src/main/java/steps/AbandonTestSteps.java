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
        abandonTestPage.waitUntilPageIsLoaded();
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

    @Step
    public void addAdditionalComments(String comment) {
        if (!abandonTestPage.isCommentSectionDisplayed())
            abandonTestPage.scrollPageDown();
        abandonTestPage.clickOnCommentsTextField();
        abandonTestPage.addComment(comment);
        abandonTestPage.clickOutsideOfTextField();
    }

    @Step
    public void checkAddedComment(String comment) {
        assertThat(abandonTestPage.getComment().contains(comment)).isTrue();
    }

    @Step
    public void pressDone() {
        abandonTestPage.clickOnDone();
    }

    @Step
    public void checkWarningPopUp() {
        assertThat(abandonTestPage.isWarningPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressCancel() {
        abandonTestPage.clickOnPopUpCancel();
    }

    @Step
    public void goBackToSelectReason() {
        abandonTestPage.clickOnBack();
    }

    @Step
    public void pressAbandon() {
        abandonTestPage.clickOnPopUpAbandon();
    }
}

