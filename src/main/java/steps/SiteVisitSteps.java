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
        siteVisitPage.setCreateTestTime();
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
    public void checkSiteVisitPageAfterSubmit() {
        siteVisitPage.waitUntilPageIsLoaded();
        assertThat(siteVisitPage.isPageTitleWithRetryDisplayed()).isTrue();
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
    public void checkATFRow(String atfName, String atfNumber) {
        assertThat(siteVisitPage.isAtfRowDisplayed(atfName, atfNumber)).isTrue();
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

    @Step
    public void checkVisitResults(String regPlate, String... testTypesWithResults) {
       assertThat(siteVisitPage.isSubmittedSiteVisitDisplayed(regPlate, testTypesWithResults)).isTrue();
    }

    @Step
    public void check4SecondToastMessage() {
        assertThat(siteVisitPage.isToastMessageDisplayed()).isTrue();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(siteVisitPage.isToastMessageDisplayed()).isFalse();
    }

    @Step
    public void checkVisitIsNotEditable(String regPlate) {
        assertThat(siteVisitPage.isVisitEditableByPlate(regPlate)).isFalse();
    }

    @Step
    public void waitUntilTimeNotTesting() {
        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkEndVisitButton();

        try {
            Thread.sleep(150000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Step
    public void checkTimeNotTesting() {
       assertThat(siteVisitPage.isTimeNotTestingDisplayed()).isTrue();
    }

    @Step
    public void clickTimeNotTesting() {
        siteVisitPage.clickTimeNotTesting();
    }

    @Step
    public void checkTimeNotTestingPopUp() {
        assertThat(siteVisitPage.isEnterReasonPopUDisplayed()).isTrue();
    }

    @Step
    public void pressOkInTimeNotTestingPopUp() {
        siteVisitPage.clickOkInReasonPopUp();
    }

    @Step
    public void checkAddedReasons(String text) {
       assertThat(siteVisitPage.areAllReasonsDisplayed(text)).isTrue();
    }

    @Step
    public void checkVehiclePosition(String mrn, int position) {
        assertThat(siteVisitPage.getVehiclePosition(mrn)).isEqualTo(position);
    }
}
