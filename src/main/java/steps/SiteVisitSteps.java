package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SiteVisitPage;

import java.util.Date;

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

        //It loops 8 times 43 seconds making it a total of more than 5 minutes. The check at the bottom is required to not kill the bs connection.
        for(int i=0; i<7; i++){
            try {
                Thread.sleep(43000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkEndVisitButton();
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

    @Step
    public Date retrieveTimeFromTimeline() {
        return siteVisitPage.retrieveTimeFromTimeline();
    }

    @Step
    public void clickStartTest() {
        siteVisitPage.clickCreateNewTest();
    }
}
