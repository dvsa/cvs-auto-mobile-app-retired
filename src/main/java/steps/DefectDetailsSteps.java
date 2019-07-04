package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.RandomStringUtils;
import pages.DefectDetailsPage;

import java.util.HashMap;
import java.util.Map;

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
    public void selectOptionsAndTapAddDefect(Map<String, String> map) {
        defectDetailsPage.selectOptionAndItsValue(map);
        defectDetailsPage.clickDone();
    }

    @Step
    public void selectOptionsWithPRSCheckAndTapAddDefect(Map<String, String> map) {
        defectDetailsPage.selectOptionAndItsValue(map);
        defectDetailsPage.enablePRS();
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
    public void checkPageTitleIsDisplayed() {
        assertThat(defectDetailsPage.checkPageTitleIsDisplayed()).isTrue();
    }

    @Step
    public void setPRS() {
        defectDetailsPage.enablePRS();
    }

    @Step
    public HashMap<String, String> inputBrakeSystemMinorDefect() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Vertical", "Upper");
        map.put("Lateral", "Nearside");
        map.put("Longitudinal", "Front");
        map.put("Axle Number", "8");

        return map;
    }

    @Step
    public HashMap<String, String> inputSeatbeltDefect() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Vertical", "Upper");
        map.put("Lateral", "Nearside");
        map.put("Row Number", "4");
        map.put("Seat Number", "4");

        return map;
    }

    @Step
    public void checkPRSOptionIsNotDisplayed() {
        assertThat(defectDetailsPage.checkPRSOptionIsDisplayed()).isFalse();
    }

    @Step
    public void checkIssuedInMobileComplianceIsNotPresent() {
        assertThat(defectDetailsPage.checkIssuedInMobileComplianceIsNotPresent()).isFalse();
    }

    @Step
    public void checkProhibitionLabelIsNotDisplayed() {
        assertThat(defectDetailsPage.checkProhibitionLabelIsNotDisplayed()).isFalse();
    }


    @Step
    public void checkPRSOptionIsDisplayed() {
        assertThat(defectDetailsPage.checkPRSOptionIsDisplayed()).isTrue();
    }
}
