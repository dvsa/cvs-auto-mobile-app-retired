package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ATFDetailsPage;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class ATFDetailsSteps extends ScenarioSteps {
    ATFDetailsPage atfDetailsPage;

    @Step
    public void startVisit() {
        atfDetailsPage.waitUntilPageIsLoaded();
        atfDetailsPage.clickStartVisit();
        atfDetailsPage.selectConfirmInPopUp();
    }

    @Step
    public void waitUntilPageIsLoaded() {
        atfDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkAtfDetails(String atfName, String pNumber, String address, String phoneNumber) {
        atfDetailsPage.waitUntilPageIsLoaded();
        List<String> data = atfDetailsPage.findAllValuesByXpath();
        assertThat(data.contains(atfName)).isTrue();
        assertThat(data.contains(pNumber)).isTrue();
        assertThat(data.contains(address)).isTrue();
        assertThat(data.contains(phoneNumber)).isTrue();
    }

    @Step
    public void pressPhoneNumber(String number) {
        atfDetailsPage.clickPhoneNumber(number);
    }

    @Step
    public void checkCallPopUp(String number) {
        assertThat(atfDetailsPage.isCallPopUpDisplayedByNumber(number)).isTrue();

    }

    @Step
    public void pressCancelInCallPopUp() {
        atfDetailsPage.clickCancelInPopUp();
    }

    @Step
    public void checkCallPopUpNotDisplayed(String number) {
        assertThat(atfDetailsPage.isCallPopUpDisplayedByNumber(number)).isFalse();
    }

    @Step
    public void pressBackButton() {
        atfDetailsPage.clickOnBackToSearchForAnAtf();
    }

    @Step
    public void checkStartVisitPopUp() {
        assertThat(atfDetailsPage.isStartVisitPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressStartVisit() {
        atfDetailsPage.clickStartVisit();
    }

    @Step
    public void pressConfirmInSiteVisitPopUp() {
        atfDetailsPage.selectConfirmInPopUp();
    }

    @Step
    public void pressReportIssueInStartVisitPopUp() {
        atfDetailsPage.clickReportIssueInPopUp();
    }

    @Step
    public void checkReportIssuePopUp() {
        assertThat(atfDetailsPage.isReportIssuePopUpDisplayed()).isTrue();
    }

    @Step
    public void pressOkInReportIssuePopUp() {
        atfDetailsPage.clickOkInReportIssuePopUp();
    }

    @Step
    public void checkReportIssuePopUpIsNotDisplayed() {
        assertThat(atfDetailsPage.isReportIssuePopUpDisplayed()).isFalse();
    }

    @Step
    public void pressCancelInStartVisitPopUp() {
        atfDetailsPage.clickCancelInPopUp();
    }

    @Step
    public void checkStartVisitPopUpIsNotDisplayed() {
        assertThat(atfDetailsPage.isStartVisitPopUpDisplayed()).isFalse();
    }
}
