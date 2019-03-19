package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteVisitSteps extends ScenarioSteps {

    SiteVisitPage siteVisitPage;

    @Step
    public void createNewTest() {
        siteVisitPage.waitUntilPageIsLoaded();
        siteVisitPage.clickCreateNewTest();
    }

    @Step
    public void waitUntilPageIsLoaded(){
        siteVisitPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkSiteVisitPage() {
        siteVisitPage.waitUntilPageIsLoaded();
        assertThat(siteVisitPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkCancelledTestStatus(String regPlate) {
        assertThat(siteVisitPage.isCanceledTestDisplayed(regPlate)).isTrue();
    }

    @Step
    public void checkThatThereIsNoBackButton() {
        waitUntilPageIsLoaded();
        assertThat(siteVisitPage.isBackButtonAvailable()).isFalse();
    }

    @Step
    public void completeEndVisit() {
        waitUntilPageIsLoaded();
        siteVisitPage.clickEndVisit();
        siteVisitPage.clickOk();
    }

    @Step
    public void checkCreateTestButton() {
        siteVisitPage.waitUntilPageIsLoaded();
        assertThat(siteVisitPage.isCreateTestButtonDisplayed()).isTrue();
    }

    @Step
    public void checkEndVisitButton() {
        assertThat(siteVisitPage.isEndVisitButtonDisplayed()).isTrue();
    }

    @Step
    public void checkATFRow(String atfName) {
        assertThat(siteVisitPage.isAtfRowDisplayed(atfName)).isTrue();
    }

    @Step
    public void checkDate() {
        assertThat(siteVisitPage.isCurrentDateDisplayed()).isTrue();
    }

    @Step
    public void checkTime() {
        assertThat(siteVisitPage.isCurrentTimeDisplayed()).isTrue();
    }

    @Step
    public void selectEndVisit() {
        waitUntilPageIsLoaded();
        siteVisitPage.clickEndVisit();
    }

    @Step
    public void checkEndVisitPopUp() {
        assertThat(siteVisitPage.isEndVisitPopUpDisplayed()).isTrue();
    }

    @Step
    public void clickOkInEndVisitPopUp() {
        siteVisitPage.clickOk();
    }

    @Step
    public void pressCancelInEndVisitPopUp() {
        siteVisitPage.clickCancelInEndVisitPop();
    }

    @Step
    public void checkEndVisitPopUpIsNotDisplayed() {
        assertThat(siteVisitPage.isEndVisitPopUpDisplayed()).isFalse();
    }

    @Step
    public void checkLoading() {
        assertThat(siteVisitPage.isLoadingScreenDisplayed()).isTrue();
    }
}
