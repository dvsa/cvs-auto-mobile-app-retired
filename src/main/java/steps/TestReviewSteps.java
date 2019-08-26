package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.AssertionsForClassTypes;
import pages.SiteVisitPage;
import pages.TestReviewPage;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestReviewSteps extends ScenarioSteps {

    TestReviewPage testReviewPage;
    SiteVisitPage siteVisitPage;

    @Step
    public void goBackToTestOverviewScreen() {
        testReviewPage.clickGoToTestOverviewScreen();
    }

    @Step
    public void checkPageTitleIsDisplayed(){
        testReviewPage.waitUntilPageIsLoaded();
        assertThat(testReviewPage.checkPageTitleIsDisplayed()).isTrue();
    }

    @Step
    public void checkElementIsDisplayed(String element){
        assertThat(testReviewPage.checkDisplayedElement(element)).isTrue();
    }

    @Step
    public void checkElementIsNotDisplayed(String element){
        assertThat(testReviewPage.checkDisplayedElement(element)).isFalse();
    }

    @Step
    public void changeDetails() {
        testReviewPage.clickChangeDetailsButton();
    }

    @Step
    public void saveChangedDetails() {
        testReviewPage.clickSaveChangedDetailsButton();
    }

    @Step
    public void checkElementIsNotEditable(String element) {
        assertThat(testReviewPage.checkEditableElement(element)).isFalse();
    }

    @Step
    public void checkDateIsDisplayed() {
        LocalDateTime localDateTime = LocalDateTime.now() ;
        Integer dayOfSystem = localDateTime.getDayOfMonth() + 1;
        int monthOfSystem = localDateTime.getMonthValue();
        Integer yearOfSystem = localDateTime.getYear() - 1;

        String day = dayOfSystem.toString();
        String month = new DateFormatSymbols().getMonths()[monthOfSystem].substring(0, 3);
        String year = yearOfSystem.toString();

        String date = day + " " + month + " " + year;
        assertThat(testReviewPage.checkDisplayedElement(date)).isTrue();
    }

    @Step
    public void changeDetailsIsNotDisplayed() {
        assertThat(testReviewPage.isChangeDetailsButtonDisplayed()).isFalse();
    }

    @Step
    public void goToTestPage() {
        testReviewPage.goToTestPage();
    }

    @Step
    public void checkTestStatus(String testType, String status) {
        assertThat(testReviewPage.verifyTestStatus(testType,status)).isTrue();
    }

    @Step
    public void scrollDown() {
        testReviewPage.scrollPageDown();
    }

    @Step
    public void pressSubmit() {
        testReviewPage.clickSubmitButton();
    }

    @Step
    public void pressSubmitInPopUp() {
        siteVisitPage.setSubmitTestTime();
        testReviewPage.clickSubmitInPopUp();
    }

    @Step
    public void waitForPageToLoad() {
        testReviewPage.waitUntilPageIsLoaded();
    }

    @Step
    public void scrollUp() {
        testReviewPage.scrollPageUp();
    }

    @Step
    public void checkSubmitPopUp() {
        assertThat(testReviewPage.checkPopUpIsDisplayed()).isTrue();
    }

    @Step
    public void pressCancelInPopUp() {
        testReviewPage.clickCancelInPopUp();
    }

    @Step
    public void checkLoadingIndicator() {
        assertThat(testReviewPage.isLoadingIndicatorDisplayed()).isTrue();
    }

    @Step
    public void checkSubmitErrorPopUp() {
        assertThat(testReviewPage.isErrorPopUpDisplayed()).isTrue();
    }

    @Step
    public void pressSettings() {
        testReviewPage.clickSettings();
    }

    @Step
    public void checkDeviceSettings() {
        assertThat(testReviewPage.isDeviceSettingsPageDisplayed()).isTrue();
    }

    @Step
    public void pressTryAgain() {
        testReviewPage.clickTryAgain();
    }

    @Step
    public void checkLoadingIndicatorIsNotDisplayed() {
        assertThat(testReviewPage.isLoadingIndicatorNotDisplayed()).isTrue();
    }

    @Step
    public void pressNextVehicle() {
        testReviewPage.clickNextVehicle();
    }

    public void pressSubmitTests() {
        testReviewPage.clickSubmitTestsButton();
    }

    public void checkElementValue(String element, String value){
        testReviewPage.checkElementValue(element,value);
    }


}
