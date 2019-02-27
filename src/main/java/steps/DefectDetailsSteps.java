package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DefectDetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DefectDetailsSteps extends ScenarioSteps {

    DefectDetailsPage defectDetailsPage;

    @Step
    public void checkAllElementsArePresent(String referenceNumber, String defectType, String defectName, String defectDescription) {
        defectDetailsPage.waitUntilPageIsLoaded();
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
    public void selectOptionsAndTapAddDefect(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {
        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectOptionsWithPRSCheckAndTapAddDefect(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {

        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        assertThat(defectDetailsPage.getPRSElementNumber()).isEqualTo(1);
        defectDetailsPage.enablePRS();
        assertThat(defectDetailsPage.getPRSElementNumber()).isEqualTo(2);
        defectDetailsPage.clickDone();
    }

    @Step
    public void sendNotesWithContentCheckAndSize() {
        defectDetailsPage.waitUntilPageIsLoaded();
        String randomData = RandomStringUtils.randomAlphanumeric(250);
        defectDetailsPage.sendNotes(randomData);
        assertThat(defectDetailsPage.checkIfTextIsPresent(randomData)).isEqualTo(0);
        assertThat(defectDetailsPage.checkIfTextIsPresent(randomData.substring(0, 200))).isEqualTo(1);

    }

    @Step
    public void tapDone() {
        defectDetailsPage.waitUntilPageIsLoaded();
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectOptionsWithPRSCheckAndTapDone(String verticalValue, String lateralValue, String rowNumberValue, String seatNumberValue) {

        defectDetailsPage.selectVerticalValue(verticalValue);
        defectDetailsPage.selectLateralValue(lateralValue);
        defectDetailsPage.selectRowNumberValue(rowNumberValue);
        defectDetailsPage.selectSeatNumberValue(seatNumberValue);
        assertThat(defectDetailsPage.getPRSElementNumber()).isEqualTo(1);
        defectDetailsPage.enablePRS();
        assertThat(defectDetailsPage.getPRSElementNumber()).isEqualTo(2);
        defectDetailsPage.clickDone();
    }

    @Step
    public void checkPageIsLoaded() {
        defectDetailsPage.waitUntilPageIsLoaded();
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
    public void scrollDefectDetailsPage() {
        defectDetailsPage.scrollDetailPage();
    }

    @Step
    public void checkPageTitleIsDisplayed(){
        assertThat(defectDetailsPage.checkPageTitleIsDisplayed()).isTrue();
    }
}
