package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestReviewPage;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestReviewSteps extends ScenarioSteps {

    TestReviewPage testReviewPage;

    @Step
    public void goBackToTestOVerviewScreen() {
        testReviewPage.clickGoToTestOverviewScreen();
    }

    @Step
    public void checkPageTitleIsDisplayed(){
        assertThat(testReviewPage.checkPageTitleIsDisplayed()).isTrue();
    }

    @Step
    public void checkElementIsDisplayed(String element){
        assertThat(testReviewPage.checkDiplayedElement(element)).isTrue();
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
        assertThat(testReviewPage.checkDiplayedElement(date)).isTrue();
    }

    @Step
    public void pressTestTypeAbandonButton(){
        testReviewPage.pressTestTypeAbandonButton();
    }

    @Step
    public void pressTestTypeRemoveButton(){
        testReviewPage.pressTestTypeRemoveButton();
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
}
