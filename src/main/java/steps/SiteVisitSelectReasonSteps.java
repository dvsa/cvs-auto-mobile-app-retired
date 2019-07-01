package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitSelectReasonPage;
import pages.SiteVisitSubmittedPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteVisitSelectReasonSteps extends ScenarioSteps {

    SiteVisitSelectReasonPage siteVisitSelectReasonPage;

    @Step
    public void pressSave() {
        siteVisitSelectReasonPage.clickSave();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        siteVisitSelectReasonPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSelectionForEachReason() {
        siteVisitSelectReasonPage.selectReason(SiteVisitSelectReasonPage.Reasons.WAITING_FOR_VEHICLE);
        assertThat(siteVisitSelectReasonPage.isReasonSelected(SiteVisitSelectReasonPage.Reasons.WAITING_FOR_VEHICLE)).isTrue();
        siteVisitSelectReasonPage.selectReason(SiteVisitSelectReasonPage.Reasons.ADMIN);
        assertThat(siteVisitSelectReasonPage.isReasonSelected(SiteVisitSelectReasonPage.Reasons.ADMIN)).isTrue();
        siteVisitSelectReasonPage.selectReason(SiteVisitSelectReasonPage.Reasons.BREAK);
        assertThat(siteVisitSelectReasonPage.isReasonSelected(SiteVisitSelectReasonPage.Reasons.BREAK)).isTrue();
        siteVisitSelectReasonPage.selectReason(SiteVisitSelectReasonPage.Reasons.SITE_ISSUE);
        assertThat(siteVisitSelectReasonPage.isReasonSelected(SiteVisitSelectReasonPage.Reasons.SITE_ISSUE)).isTrue();
        siteVisitSelectReasonPage.selectReason(SiteVisitSelectReasonPage.Reasons.OTHER);
        assertThat(siteVisitSelectReasonPage.isReasonSelected(SiteVisitSelectReasonPage.Reasons.OTHER)).isTrue();
    }

    @Step
    public void checkPopUp() {
        assertThat(siteVisitSelectReasonPage.isPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressOkInPopUp() {
        siteVisitSelectReasonPage.clickOk();
    }

    @Step
    public void typeNote(String text) {
        siteVisitSelectReasonPage.clickOnNotes();
        siteVisitSelectReasonPage.typeText(text);
    }
}
