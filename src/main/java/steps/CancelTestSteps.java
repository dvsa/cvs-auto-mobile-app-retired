package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.CancelTestPage;
import pages.SiteVisitPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CancelTestSteps extends ScenarioSteps {
    CancelTestPage cancelTestPage;
    SiteVisitPage siteVisitPage;

    @Step
    public void pressBackButton() {
        cancelTestPage.clickOnBackButton();
    }

    @Step
    public void checkPageDetails() {
        cancelTestPage.waitUntilPageIsLoaded();
        assertThat(cancelTestPage.isPageTitleDisplayed() && cancelTestPage.isTextTipDisplayed()).isTrue();
        assertThat(cancelTestPage.isInputTitleDisplayed()).isTrue();
    }

    @Step
    public void checkTextInputField() {
        assertThat(cancelTestPage.isInputFieldDisplayed()).isTrue();
    }

    @Step
    public void pressSubmit() {
        cancelTestPage.clickSubmit();
    }

    @Step
    public void checkNoReasonPopUp() {
        assertThat(cancelTestPage.isNoReasonPopUpTitleDisplayed()).isTrue();
        assertThat(cancelTestPage.isNoReasonPopUpTextDisplayed()).isTrue();
        assertThat(cancelTestPage.isNoReasonPopUpButtonDisplayed()).isTrue();
    }

    @Step
    public void pressOKNoReasonPopUp() {
        cancelTestPage.clickOnNoReasonPopUpOkButton();
        assertThat(cancelTestPage.isNoReasonPopUpTitleDisplayed()).isFalse();
        assertThat(cancelTestPage.isNoReasonPopUpTextDisplayed()).isFalse();
        assertThat(cancelTestPage.isNoReasonPopUpButtonDisplayed()).isFalse();
    }

    @Step
    public void addReasonForCancellation(String text) {
        cancelTestPage.addReason(text);
        cancelTestPage.clickOutsideOfTextField();
        assertThat(cancelTestPage.getReasonTextFromInput().contains(text)).isTrue();
    }

    @Step
    public void pressSubmitInPopUp() {
        siteVisitPage.setSubmitTestTime();
        cancelTestPage.clickSubmitInPopUp();
    }
}

