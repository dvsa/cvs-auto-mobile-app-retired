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
    public void cancelInputNumberOfSeatbelt() {
        testTypeDetailsPage.selectSeatbeltsNumberOption();
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
    public void checkMostRecentInstallationCheckIsDisplayed() {
        assertThat(testTypeDetailsPage.isMostInstallationCheckButtonDisplayed()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckIsNotDisplayed() {
        assertThat(testTypeDetailsPage.isMostInstallationCheckButtonDisplayed()).isFalse();
    }

    @Step
    public void setMostRecentInstallationCheckDate() {
        testTypeDetailsPage.setRecentInstallationDateCheck();
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
    public void checkSeatbeltInstallationCheckTitleIsDisplayed() {
        assertThat(testTypeDetailsPage.isSeatbeltTitleDisplayed()).isTrue();
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
}
