package steps;

import io.cucumber.java.BeforeStep;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.DefectDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectDetailsSteps extends ScenarioSteps {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    DefectDetailsPage defectDetailsPage;

    @BeforeStep
    public void waitUntilPageIsLoaded() {
        defectDetailsPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkAllElementsArePresent(String referenceNumber, String defectType, String defectName, String defectDescription) {

        assertThat(defectDetailsPage.getDefectLabel().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getLocationLabel().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getNotesLabel().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getPRSLabel().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getSelectOptionElementNumber()).isEqualTo(4);
        assertThat(defectDetailsPage.getLateral().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getVertical().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getRowNumber().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getSeatNumber().isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getElementById(referenceNumber).isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getElementById(defectType).isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getElementByLabel(defectName).isDisplayed()).isTrue();
        assertThat(defectDetailsPage.getElementByLabel(defectDescription).isDisplayed()).isTrue();
    }

    @Step
    public void checkLongitudinalIsNotDisplayed() {
        assertThat(defectDetailsPage.isLongitudinalDisplayed()).isFalse();
    }

    @Step
    public void checkVerticalIsNotDisplayed(){
        assertThat(defectDetailsPage.isVerticalDisplayed()).isFalse();
    }

    @Step
    public void checkHorizontalIsNotDisplayed(){
        assertThat(defectDetailsPage.isHorizontalDisplayed()).isFalse();
    }

    @Step
    public void checkLateralIsNotDisplayed(){
        assertThat(defectDetailsPage.isLateralDisplayed()).isFalse();
    }

    @Step
    public void checkAxleNumberIsNotDisplayed(){
        assertThat(defectDetailsPage.isAxleNumberDisplayed()).isFalse();
    }

    @Step
    public void checkNotesIsNotDisplayed(){
        assertThat(defectDetailsPage.isNotesDisplayed()).isFalse();
    }

    @Step
    public void checkLongitudinalIsDisplayed() {
        assertThat(defectDetailsPage.isLongitudinalDisplayed()).isTrue();
    }

    @Step
    public void checkVerticalIsDisplayed(){
        assertThat(defectDetailsPage.isVerticalDisplayed()).isTrue();
    }

    @Step
    public void checkHorizontalIsDisplayed(){
        assertThat(defectDetailsPage.isHorizontalDisplayed()).isTrue();
    }

    @Step
    public void checkLateralIsDisplayed(){
        assertThat(defectDetailsPage.isLateralDisplayed()).isTrue();
    }

    @Step
    public void checkAxleNumberIsDisplayed(){
        assertThat(defectDetailsPage.isAxleNumberDisplayed()).isTrue();
    }

    @Step
    public void checkNotesIsDisplayed(){
        assertThat(defectDetailsPage.isNotesDisplayed()).isTrue();
    }

    @Step
    public void checkItemsArePresent(String... items) {
        defectDetailsPage.waitUntilPageIsLoaded();
        for (String item: items) {
            Assert.assertTrue(defectDetailsPage.findItemInList(item).isDisplayed());
        }
    }

    @Step
    public void checkDefectDisplayForFirstIm5(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFirstIm5IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForSecIm5(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForSecIm5IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForThirdIm5(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForThirdIm5IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFourthIm5(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFourthIm5IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFirstIm59(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFirstIm59IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForSecIm59(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForSecIm59IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForThirdIm59(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForThirdIm59IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFourthIm59(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFourthIm59IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFirstIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFirstIm8IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForSecIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForSecIm8IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForThirdIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForThirdIm8IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFourthIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFourthIm8IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForFifthIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForFifthIm8IsDisplayed()).isTrue();
    }

    @Step
    public void checkDefectDisplayForSixthIm8(){
        assertThat(defectDetailsPage.checkIfDefectDescriptionForSixthIm8IsDisplayed()).isTrue();
    }

    @Step
    public void selectVerticalLateralLongitudinalAxle(String verticalValue, String lateralValue, String longitudinalValue, String axleNumberValue) {
        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectLongitudinal(longitudinalValue);
        defectDetailsPage.selectAxleNumber(axleNumberValue);
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectHorizontalLateralAxle(String horizontalValue, String lateralValue, String axleNumberValue) {
        defectDetailsPage.selectHorizontalValue(horizontalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectAxleNumber(axleNumberValue);
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectVerticalLateralRowNumberSeatNumber(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {
        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectInputValuesWithPRSAndClickBack(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {
        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        defectDetailsPage.enablePRS();
        defectDetailsPage.clickBack();
    }

    @Step
    public void selectVerticalLateralRowNumberSeatNumberWithPRS(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {
        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        assertThat(defectDetailsPage.getPRSSwitchValue()).isEqualTo("0");
        defectDetailsPage.enablePRS();
        assertThat(defectDetailsPage.getPRSSwitchValue()).isEqualTo("1");
        defectDetailsPage.clickDone();
    }

    @Step
    public void setReferenceNumber(String referenceNumber) {
        defectDetailsPage.setReferenceNumber(referenceNumber);
    }

    @Step
    public void checkReferenceNumberIs(String referenceNumber) {
        assertThat(defectDetailsPage.getReferenceNumber().equalsIgnoreCase(referenceNumber));
    }

    @Step
    public void setDefectName(String defectName) {
        defectDetailsPage.setDefectName(defectName);
    }

    @Step
    public void checkDefectNameIs(String defectName) {
        assertThat(defectDetailsPage.getDefectName().equalsIgnoreCase(defectName));
    }

    @Step
    public void setDefectNotes(String notes) {
        defectDetailsPage.setDefectNotes(notes);
    }

    @Step
    public void checkDefectNotesIs(String notes) {
        assertThat(defectDetailsPage.getDefectNotes().equalsIgnoreCase(notes));
    }

    @Step
    public void sendNotesWithContentCheckAndSize() {
        String randomData = RandomStringUtils.randomAlphanumeric(250);
        defectDetailsPage.sendNotes(randomData);
        assertThat(defectDetailsPage.checkIfTextIsPresent(randomData)).isEqualTo(0);
        assertThat(defectDetailsPage.checkIfTextIsPresent(randomData.substring(0, 200))).isEqualTo(1);
    }

    @Step
    public void tapDone() {
        defectDetailsPage.clickDone();
    }

    @Step
    public void checkPageIsLoaded() {
        waitUntilPageIsLoaded();
    }

    @Step
    public void clickBack() {
        defectDetailsPage.clickBack();
    }

    @Step
    public void pressRemove() {
        defectDetailsPage.clickOnRemoveButton();
    }

    @Step
    public void checkDefectRemovalPopUp() {
        assertThat(defectDetailsPage.isDefectRemovalPopUpVisible()).isTrue();
    }

    @Step
    public void pressRemoveInPopUp() {
        defectDetailsPage.clickRemoveInPopUp();
    }

    @Step
    public void pressCancelInPopUp() {
        defectDetailsPage.clickCancelInPopUp();
    }

    @Step
    public void clickLongitudinal() {
        defectDetailsPage.clickLongitudinal();
    }

    @Step
    public void clickLongitudinalFront() {
        defectDetailsPage.clickLongitudinalFront();
    }

    @Step
    public void clickLongitudinalRear() {
        defectDetailsPage.clickLongitudinalRear();
    }

    @Step
    public void scrollDefectDetailsPage() {
        defectDetailsPage.scrollDetailPage();
    }

    @Step
    public void checkPageTitleIsDisplayed() {
        assertThat(defectDetailsPage.checkPageTitleIsDisplayed()).isTrue();
    }

    @Step
    public void checkSectionHeadingIsShown(String section) {
        boolean isDisplayed = true;
        logger.info("Checking for heading: " + section);
        if (!defectDetailsPage.isStaticTextDisplayed(section)) {
            isDisplayed = false;
        }
        assertThat(isDisplayed).isTrue();
    }

    @Step
    public void setPRS() {
        defectDetailsPage.enablePRS();
    }

    @Step
    public void setProhibitionIssued() {
        defectDetailsPage.enableProhibition();
    }

    @Step
    public void checkProhibitionIssuedSwitchOn() {
        assertThat(defectDetailsPage.getProhibitionSwitchValue().contentEquals("1")).isTrue();
    }

    @Step
    public void checkProhibitionIssuedSwitchOff() {
        assertThat(defectDetailsPage.getProhibitionSwitchValue().contentEquals("0")).isTrue();
    }

    @Step
    public void checkPRSOptionIsNotDisplayed() {
        assertThat(defectDetailsPage.checkPRSOptionIsDisplayed()).isFalse();
    }
//
//    public void checkPRSOptionIsDisplayed() {
//        assertThat(defectDetailsPage.checkPRSOptionIsDisplayed()).isTrue();
//    }

    @Step
    public void checkIssuedInMobileComplianceIsNotPresent() {
        assertThat(defectDetailsPage.isIssuedInMobileCompliancePresent()).isFalse();
    }

    @Step
    public void checkIssuedInMobileComplianceIsPresent() {
        assertThat(defectDetailsPage.isIssuedInMobileCompliancePresent()).isTrue();
    }

    @Step
    public void checkProhibitionLabelIsNotDisplayed() {
        assertThat(defectDetailsPage.isProhibitionLabelDisplayed()).isFalse();
    }

    @Step
    public void checkProhibitionLabelIsDisplayed() {
        assertThat(defectDetailsPage.isProhibitionLabelDisplayed()).isTrue();
    }

    @Step
    public void checkProhibitionPopUpNoAsteriskDefect() {
        assertThat(defectDetailsPage.isProhibitionPopUpNoAsteriskDefectDisplayed()).isTrue();
    }

    @Step
    public void pressOkInProhibitionPopUp() {
        defectDetailsPage.clickOkInProhibitionPopUp();
    }

    @Step
    public void checkProhibitionPopUpNotDisplayed() {
        assertThat(defectDetailsPage.isProhibitionPopUpDisplayed()).isFalse();
    }

    @Step
    public void scroll() {
        defectDetailsPage.scroll();
    }
}
