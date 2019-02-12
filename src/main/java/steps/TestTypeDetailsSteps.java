package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestTypeDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;


public class TestTypeDetailsSteps extends ScenarioSteps {

    TestTypeDetailsPage testTypeDetailsPage;

    @Step
    public void setCarriedOutDuringTest(boolean isCarriedOut) {
        testTypeDetailsPage.selectCarriedOutOption();
        if (isCarriedOut) {
            testTypeDetailsPage.selectIsCarriedOut();
        } else {
            testTypeDetailsPage.selectIsNotCarriedOut();
        }
    }

    @Step
    public void checkSetCarreidOutDuringTestOption(String yesOrNo) {
        assertThat(testTypeDetailsPage.checkIsCarriedOutValue(yesOrNo)).isTrue();
    }

    @Step
    public void cancelCarriedOutDuringTest() {
        testTypeDetailsPage.selectCarriedOutOption();
        testTypeDetailsPage.cancelIsCarriedOut();
    }

    @Step
    public void inputNumberOfSeatbelt(String number) {
        testTypeDetailsPage.selectSeatbeltsNumberOption();
        testTypeDetailsPage.setSetbealtNumber(number);
        testTypeDetailsPage.doneSeatbeltInstallationCheck();
    }

    @Step
    public void cancelInputNumberOfSeatbelt(){
        testTypeDetailsPage.selectSeatbeltsNumberOption();
        testTypeDetailsPage.cancelSeatbeltInstallationCheck();
    }

    @Step
    public void checkNumberOfSeatbelts(String number){
        assertThat(testTypeDetailsPage.checkSetbealtNumber(number)).isTrue();
    }

    @Step
    public void checktSeabeltDetailsPage(){
        assertThat(testTypeDetailsPage.isSeatbeltTitleDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.isSeatbetlInputFieldDisplayed()).isTrue();
    }

    @Step
    public void selectMostRecentInstallationCheck(){
        testTypeDetailsPage.selectRecentInstallationCheckOption();
    }

    @Step
    public void checkDataPickerIsPresent() {
        assertThat(testTypeDetailsPage.isDateCalendarPickerDisplayed()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckIsDisplayed(){
        assertThat(testTypeDetailsPage.isMostInstallationCheckButtonDisplayed()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckIsNotDisplayed(){
        assertThat(testTypeDetailsPage.isMostInstallationCheckButtonDisplayed()).isFalse();
    }

    @Step
    public void setMostRecentInstallationCheckDateOneUnit(){
        testTypeDetailsPage.setRecentInstallationDateCheckOneUnit();
    }

    @Step
    public void verifyMostRecentInstallationCheckDate() {
        assertThat(testTypeDetailsPage.verifyMostRecentInstallationDate()).isTrue();
    }

    @Step
    public void cancelMostRecentInstallationCheckOption() {
        testTypeDetailsPage.selectRecentInstallationCheckOption();
        testTypeDetailsPage.cancelMostRecentInstallationCheck();
    }

    @Step
    public void checkTestTypeDetailsTitleIsDisplayed() {
        assertThat(testTypeDetailsPage.isTestTypeDetailsTitleDisplayed()).isTrue();
    }

    @Step
    public void checkSeatBeltInstallationCheckTitleIsDisplayed() {
        assertThat(testTypeDetailsPage.isSeatbeltTitleDisplayed()).isTrue();
    }

    @Step
    public void pressSave() {
        testTypeDetailsPage.clickSave();
    }

    @Step
    public void verifyMostRecentInstallationCheckDateIsEdited() {
        assertThat(testTypeDetailsPage.verifyMostRecentInstallationDate()).isFalse();
    }
}
