package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
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
    public void checkSetCarriedOutDuringTestOption(String yesOrNo) {
        assertThat(testTypeDetailsPage.checkIsCarriedOutValue(yesOrNo)).isTrue();
    }

    @Step
    public void checkSetCarriedOutDuringTestIsDisplayed() {
        assertThat(testTypeDetailsPage.checkIsCarriedOutDisplayed()).isTrue();
    }

    @Step
    public void checkSetCarriedOutDuringTestIsNotDisplayed() {
        assertThat(testTypeDetailsPage.checkIsCarriedOutDisplayed()).isFalse();
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
    public void selectAndCancelInputNumberOfSeatbelt() {
        testTypeDetailsPage.selectSeatbeltsNumberOption();
        testTypeDetailsPage.cancelSeatbeltInstallationCheck();
    }

    @Step
    public void doneInputNumberOfSeatbelt() {
        testTypeDetailsPage.selectSeatbeltsNumberOption();
        testTypeDetailsPage.doneSeatbeltInstallationCheck();
    }

    @Step
    public void checkDoneAndCancelOptionForSeatbeltNumber(){
        testTypeDetailsPage.selectSeatbeltsNumberOption();
        assertThat(testTypeDetailsPage.isCancelOptionDisplayedForSeatbeltNumber()).isTrue();
        assertThat(testTypeDetailsPage.isDoneOptionDisplayedForSeatbeltNumber()).isTrue();
        testTypeDetailsPage.cancelSeatbeltInstallationCheck();
    }

    @Step
    public void checkNumberOfSeatbelts(String number) {
        assertThat(testTypeDetailsPage.checkSetbealtNumber(number)).isTrue();
    }

    @Step
    public void checktSeabeltDetailsPage() {
        assertThat(testTypeDetailsPage.isSeatbeltTitleDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.isSeatbetlInputFieldDisplayed()).isTrue();
    }

    @Step
    public void selectMostRecentInstallationCheck() {
        testTypeDetailsPage.selectRecentInstallationCheckOption();
    }

    @Step
    public void checkDataPickerIsPresent() {
        assertThat(testTypeDetailsPage.isDateCalendarPickerDisplayed()).isTrue();
    }

    @Step
    public void checkDoneAndCancelOptionForMostRecentInstallationCheck() {
        assertThat(testTypeDetailsPage.isCancelOptionDisplayedForDatePicker()).isTrue();
        assertThat(testTypeDetailsPage.isDoneOptionDisplayedForDatePicker()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckIsDisplayed() {
        assertThat(testTypeDetailsPage.isMostInstallationCheckButtonDisplayed()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckIsNotDisplayed() {
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

    @Step
    public void setTestToOption(String option) {
        testTypeDetailsPage.waitUntilPageIsLoaded();
        if (option.equalsIgnoreCase("pass")) {
            testTypeDetailsPage.clickSetTestResul();
            testTypeDetailsPage.passLecTest();
        } else if (option.equalsIgnoreCase("fail")) {
            testTypeDetailsPage.clickSetTestResul();
            testTypeDetailsPage.failLecTest();
        } else if (option.equalsIgnoreCase("cancel")) {
            testTypeDetailsPage.clickPassedTest();
            testTypeDetailsPage.cancelLecTest();
        } else throw new IllegalArgumentException("The input argument should be pass, fail or cancel!");
    }

    @Step
    public void checkTestOptionArePresents() {
        testTypeDetailsPage.clickSetTestResul();
        assertThat(testTypeDetailsPage.checkPassTestOptionIsPresent()).isTrue();
        assertThat(testTypeDetailsPage.checkFailTestOptionIsPresent()).isTrue();
        assertThat(testTypeDetailsPage.checkCancelTestOptionIsPresent()).isTrue();
    }

    @Step
    public void checkTestIsPassed() {
        assertThat(testTypeDetailsPage.checkTestStatus("Pass")).isTrue();
    }

    @Step
    public void checkTestIsFailed() {
        assertThat(testTypeDetailsPage.checkTestStatus("Fail")).isTrue();
    }

    @Step
    public void checkCertificateSection(boolean isPresent) {
        if (isPresent) {
            assertThat(testTypeDetailsPage.checkLPLabelIsPresent()).isTrue();
            assertThat(testTypeDetailsPage.checkCertificateNumberInputFIedIsPresent()).isTrue();
            assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isTrue();
        } else {
            assertThat(testTypeDetailsPage.checkLPLabelIsPresent()).isFalse();
            assertThat(testTypeDetailsPage.checkCertificateNumberInputFIedIsPresent()).isFalse();
            assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isFalse();
        }
    }

    @Step
    public void sendCertificateNumber(String certificateNumber) {
        testTypeDetailsPage.sendCertificateNumber(certificateNumber);
    }

    @Step
    public void cancelCertificateNumberInput (String certificateNumberAfterCancellation) {
        String certificateNumber = testTypeDetailsPage.cancelInputCertificateNumber();
        assertThat(certificateNumberAfterCancellation.equals(certificateNumber)).isTrue();
    }

    @Step
    public void checkCertificateNumber(String expectedCertificateNumber) {
        String actualCertificateNumber = testTypeDetailsPage.getCertificateNumber();
        assertThat(expectedCertificateNumber.equals(actualCertificateNumber)).isTrue();
    }

    @Step
    public void checkCertificateGuidance() {
        assertThat(testTypeDetailsPage.isCertificateGuidanceDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsForCarriedOutSeatbeltCheckAreDisplayed(){
        testTypeDetailsPage.selectCarriedOutOption();
        testTypeDetailsPage.isCarriedOutDisplayed();
        testTypeDetailsPage.isCancelCarriedOutDisplayed();
        testTypeDetailsPage.isNotCarriedOutDisplayed();
    }

    @Step
    public void checkSeatbetlPopUpIsDisplayed(){
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpTitle()).isTrue();
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpMessage()).isTrue();
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpOkButton()).isTrue();
    }

    @Step
    public void pressOkButtonForSeatbeltPopUp(){
       testTypeDetailsPage.clickOkButtonForSeatbeltPopUp();
    }
}
