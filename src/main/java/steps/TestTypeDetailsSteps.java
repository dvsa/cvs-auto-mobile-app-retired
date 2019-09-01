package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.AssertionsForClassTypes;
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
    public void checkSetCarriedOutDuringTestIsNotDisplayed() {
        assertThat(testTypeDetailsPage.checkIsCarriedOutDisplayed()).isFalse();
    }

    @Step
    public void cancelCarriedOutDuringTest() {
        testTypeDetailsPage.selectCarriedOutOption();
        testTypeDetailsPage.cancelIsCarriedOut();
    }

    @Step
    public void checkNumberOfSeatbelts(String number) {
        assertThat(testTypeDetailsPage.checkSetbealtNumber(number)).isTrue();
    }

    @Step
    public void checkNumberOfSeatbeltsIsNotDisplayed(){
        assertThat(testTypeDetailsPage.checkNumberOfSeatbeltsIsNotDisplayed()).isTrue();
    }

    @Step
    public void selectMostRecentInstallationCheck() {
        testTypeDetailsPage.selectRecentInstallationCheckOption();
    }

    @Step
    public void checkDataPickerIsPresent() {
        testTypeDetailsPage.waitUntilPageIsLoaded();
        assertThat(testTypeDetailsPage.isDateCalendarPickerDisplayed()).isTrue();
    }

    @Step
    public void checkDoneAndCancelOptionForMostRecentInstallationCheck() {
        assertThat(testTypeDetailsPage.isCancelOptionDisplayedForDatePicker()).isTrue();
        assertThat(testTypeDetailsPage.isDoneOptionDisplayedForDatePicker()).isTrue();
    }

    @Step
    public void checkMostRecentInstallationCheckButtonIsDisplayed() {
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
    public void verifyThatNoRecentInstallationDateIsDisplayed() {
        assertThat(testTypeDetailsPage.verifyThatNoRecentInstallationDateIsDisplayed()).isTrue();
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
        testTypeDetailsPage.waitUntilPageIsLoaded();
        testTypeDetailsPage.clickSave();
    }

    @Step
    public void verifyMostRecentInstallationCheckDateIsEdited() {
        assertThat(testTypeDetailsPage.verifyMostRecentInstallationDate()).isTrue();
    }

    @Step
    public void setTestToOption(String option) {
        testTypeDetailsPage.waitUntilPageIsLoaded();
        if (option.equalsIgnoreCase("pass")) {
            testTypeDetailsPage.clickSetTestResult();
            testTypeDetailsPage.passLecTest();
        } else if (option.equalsIgnoreCase("fail")) {
            testTypeDetailsPage.clickSetTestResult();
            testTypeDetailsPage.failLecTest();
        } else if (option.equalsIgnoreCase("cancel")) {
            testTypeDetailsPage.clickPassedTest();
            testTypeDetailsPage.cancelLecTest();
        } else throw new IllegalArgumentException("The input argument should be pass, fail or cancel!");
    }

    @Step
    public void pressCancelOptionLEC() {
        testTypeDetailsPage.cancelLecTest();
    }

    @Step
    public void checkTestOptionArePresents() {
        testTypeDetailsPage.clickSetTestResult();
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
            assertThat(testTypeDetailsPage.checkCertificateNumberInputFieIdIsPresent()).isTrue();
            assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isTrue();
        } else {
            assertThat(testTypeDetailsPage.checkLPLabelIsPresent()).isFalse();
            assertThat(testTypeDetailsPage.checkCertificateNumberInputFieIdIsPresent()).isFalse();
            assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isFalse();
        }
    }

    @Step
    public void sendCertificateNumberAndSave(String certificateNumber) {
        testTypeDetailsPage.sendCertificateNumberAndSave(certificateNumber);
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
    public void addNotes(String text) {
        testTypeDetailsPage.waitUntilPageIsLoaded();
        testTypeDetailsPage.clickNotes();
        testTypeDetailsPage.typeIntoNotesField(text);
        testTypeDetailsPage.tapTitleTwiceToCloseIOSKeyboard();
    }

    @Step
    public void checkNotesText(String text) {
        assertThat(testTypeDetailsPage.isTextDisplayedInNotes(text)).isTrue();
    }

    @Step
    public void checkTestTypeName(String testTypeName) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testTypeName);
        assertThat(testTypeDetailsPage.getTestTypeDetails().isDisplayed()).isTrue();
    }


    @Step
    public void checkAddDefectIsPresent() {
        assertThat(testTypeDetailsPage.getAddDefectElement().isDisplayed()).isTrue();
    }


    @Step
    public void selectAddDefect(String testType) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testType);
        if (testTypeDetailsPage.isAddDefectButtonDisplayed()) {
            testTypeDetailsPage.getAddDefectElement().click();
        } else {
            testTypeDetailsPage.scrollDetailPage();
            testTypeDetailsPage.getAddDefectElement().click();
        }
    }

    @Step
    public void clickAddDefect() {
        testTypeDetailsPage.getAddDefectElement().click();
    }

    @Step
    public void checkDefectsArePresentForTest(String testType, String recordDefect, String defectItem) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testType);
        assertThat(testTypeDetailsPage.checkDefectIsPresent(recordDefect).isDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.checkDefectIsPresent(defectItem).isDisplayed()).isTrue();

    }

    @Step
    public void checkAdditionalDetails(String testType, String referenceNumber, String defectType, String defectItem, String defectItemSubcategory, String defectItemSubcategoryType) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testType);
        assertThat(testTypeDetailsPage.getElementById(referenceNumber).isDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.getElementById(defectType).isDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.getElementByLabel(defectItem).isDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.getElementByLabel(defectItemSubcategory).isDisplayed()).isTrue();
        assertThat(testTypeDetailsPage.getElementByLabel(defectItemSubcategoryType).isDisplayed()).isTrue();
    }

    @Step
    public void checkAdditionalDetailsWithPRSPresent(String testType, String referenceNumber, String defectType, String defectItem, String defectItemSubcategory, String defectItemSubcategoryType) {
        checkAdditionalDetails(testType, referenceNumber, defectType, defectItem, defectItemSubcategory, defectItemSubcategoryType);
        assertThat(testTypeDetailsPage.getPRMSLabels()).isEqualTo(1);
    }

    @Step
    public void tapOnPresentDefect(String testType, String recordDefect, String defectItem) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testType);
        testTypeDetailsPage.clickOnDefect(recordDefect, defectItem);
    }

    @Step
    public void swipeDefect(String defectId) {
        int initialXPosition = testTypeDetailsPage.getXPositionForElement(defectId);
        testTypeDetailsPage.swipeLeftOnDefect(defectId);
        int newXPosition = testTypeDetailsPage.getXPositionForElement(defectId);
        assertThat(initialXPosition).isNotEqualTo(newXPosition);
    }

    @Step
    public void pressRemove() {
        testTypeDetailsPage.clickOnRemoveButton();
    }

    @Step
    public void checkDefectRemovalPopUp() {
        assertThat(testTypeDetailsPage.isDefectRemovalPopUpVisible()).isTrue();
    }

    @Step
    public void pressRemoveInPopUp() {
        testTypeDetailsPage.clickRemoveInPopUp();
    }

    @Step
    public void checkDefectRemoved(String defectId) {
        assertThat(testTypeDetailsPage.isDefectVisible(defectId)).isFalse();
    }

    @Step
    public void pressCancelInPopUp() {
        testTypeDetailsPage.clickCancelInPopUp();
    }

    @Step
    public void checkDefectIsNotRemoved(String defectId) {
        assertThat(testTypeDetailsPage.isDefectVisible(defectId)).isTrue();
    }

    @Step
    public void checkDefectWasNotAdded(String testType, String... defects) {
        testTypeDetailsPage.waitUntilPageIsLoadedByTestType(testType);
        for (String defect: defects) {
            assertThat(testTypeDetailsPage.checkElementIsNotPresent(defect).isEmpty()).isTrue();
        }
    }

    @Step
    public void checkTestTypeRemovalPopUp() {
        assertThat(testTypeDetailsPage.isTestTypeRemovalPopUpVisible()).isTrue();
    }

    @Step
    public void pressRemoveTestTypeInPopUp() {
        testTypeDetailsPage.clickRemoveInTestTypePopUp();
    }

    @Step
    public void pressCancelRemoveTestTypeInPopUp() {
        testTypeDetailsPage.clickCancelInTestTypePopUp();
    }

    @Step
    public void checkTestTypesPageIsLoadedByTitle() {
        assertThat(testTypeDetailsPage.getTestTypeDetails().isDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsForCarriedOutSeatbeltCheckAreDisplayed(){
        testTypeDetailsPage.selectCarriedOutOption();
        testTypeDetailsPage.isCarriedOutDisplayed();
        testTypeDetailsPage.isCancelCarriedOutDisplayed();
        testTypeDetailsPage.isNotCarriedOutDisplayed();
    }

    @Step
    public void checkSeatbeltPopUpIsDisplayed(){
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpTitle()).isTrue();
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpMessage()).isTrue();
        assertThat(testTypeDetailsPage.checkSeatbeltPopUpOkButton()).isTrue();
    }

    @Step
    public void pressOkButtonForSeatbeltPopUp(){
       testTypeDetailsPage.clickOkButtonForSeatbeltPopUp();
    }

    @Step
    public void checkTestResultField() {
       assertThat(testTypeDetailsPage.isTestResultFieldDisplayed()).isTrue();
    }

    @Step
    public void pressTestResultsOption() {
        testTypeDetailsPage.clickSetTestResult();
    }

    @Step
    public void checkFailAndPassOptions() {
       assertThat(testTypeDetailsPage.isPassOptionDisplayed() && testTypeDetailsPage.isFailOptionDisplayed()).isTrue();
    }

    @Step
    public void checkResultIsNotSet() {
        assertThat(testTypeDetailsPage.isSelectStatusDisplayed()).isTrue();
    }

    @Step
    public void selectNumberOfSeatbeltsFitted() {
        testTypeDetailsPage.selectSeatbeltsNumberOption();
    }

    @Step
    public void scrollTestTypeDetailsPage() {
        testTypeDetailsPage.scrollDetailPage();
    }

    @Step
    public void pressTestTypeAbandonButton() {
        testTypeDetailsPage.scrollDetailPage();
        testTypeDetailsPage.pressTestTypeAbandonButton();
    }

    @Step
    public void pressTestTypeRemoveButton() {
        testTypeDetailsPage.scrollDetailPage();
        testTypeDetailsPage.pressTestTypeRemoveButton();
    }

    @Step
    public void selectDefectBasedOnDefectDescription(String description) {
        testTypeDetailsPage.tapDefectDescription(description);
    }

    @Step
    public void clickOnTitle() {
        testTypeDetailsPage.tapTitleTwiceToCloseIOSKeyboard();
    }

    @Step
    public void setProhibitionIssued() {
        testTypeDetailsPage.enableProhibition();
    }

    @Step
    public void checkProhibitionIssuedSwitchOn() {
        assertThat(testTypeDetailsPage.getProhibitionSwitchValue().contentEquals("1")).isTrue();
    }

    @Step
    public void checkProhibitionIssuedSwitchOff() {
        assertThat(testTypeDetailsPage.getProhibitionSwitchValue().contentEquals("0")).isTrue();
    }

    @Step
    public void enablePRS(){testTypeDetailsPage.enablePRS();}

    @Step
    public void checkTestTypeAbandonButton() {
        assertThat(testTypeDetailsPage.isAbandonButtonDisplayed()).isTrue();
    }

    @Step
    public void checkTestTypeRemoveButton() {
        assertThat(testTypeDetailsPage.isRemoveTestButtonDisplayed()).isTrue();
    }

    @Step
    public void checkElementValue(String element, String value){
        testTypeDetailsPage.checkElementValue(element,value);
    }
    @Step
    public void checkCertificateNumberIsDisplayed() {
        assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isTrue();
        assertThat(testTypeDetailsPage.checkCertificateNumberInputFieIdIsPresent()).isTrue();
    }

    @Step
    public void checkCertificateGuidanceDisplays(String instruction) {
        assertThat(testTypeDetailsPage.isCertificateNumberGuidance(instruction)).isTrue();
    }

    @Step
    public void checkCertificateNumberIs(String certificateNumber) {
        assertThat(testTypeDetailsPage.isCertificateNumber(certificateNumber)).isTrue();
    }

    @Step
    public void checkCertificateNumberIsNotDisplayed() {
        assertThat(testTypeDetailsPage.isStaticTextNotDisplayed("CERTIFICATE NUMBER")).isTrue();
    }

    @Step
    public void checkErrorNotesDetailsIsDisplayed() {
        assertThat(testTypeDetailsPage.isErrorMessageDisplayed("Before saving, give more details about the failure in the notes section."));
    }

    @Step
    public void checkNotesTitle(String notes) {
        String[] stringArray = notes.split(" ");
        boolean isDisplayed = true;
        for(String string:stringArray){
            System.out.println("string: " + string);
            if(!testTypeDetailsPage.isStaticTextDisplayed(string)){
                isDisplayed = false;
            }
        }
        assertThat(isDisplayed).isTrue();
    }

    @Step
    public void checkCertificateNumberIsDisplayed() {
        assertThat(testTypeDetailsPage.checkCertificateNumberLabelIsPresent()).isTrue();
        assertThat(testTypeDetailsPage.checkCertificateNumberInputFieIdIsPresent()).isTrue();
    }

    @Step
    public void checkCertificateGuidanceDisplays(String instruction) {
        assertThat(testTypeDetailsPage.isCertificateNumberGuidance(instruction)).isTrue();
    }

    @Step
    public void checkCertificateNumberIs(String certificateNumber) {
        assertThat(testTypeDetailsPage.isCertificateNumber(certificateNumber)).isTrue();
    }

    @Step
    public void checkCertificateNumberIsNotDisplayed() {
        assertThat(testTypeDetailsPage.isStaticTextNotDisplayed("CERTIFICATE NUMBER")).isTrue();
    }
}
