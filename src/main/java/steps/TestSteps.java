package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps extends ScenarioSteps {

    TestPage testPage;

    @Step
    public void addTestType() {
        testPage.waitUntilPageIsLoaded();
        testPage.addTestType();
    }

    @Step
    public void checkTestDetails(String regPlate, String vin) {
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isPageTitleDisplayed() && testPage.isVehicleRegistrationPlateDisplayed(regPlate, vin)).isTrue();
    }

    @Step
    public void checkAddATestTypeButtonVisibility() {
        assertThat(testPage.isAddATestTypeButtonDisplayed()).isTrue();
    }

    @Step
    public void checkSelectedTestTypes(String... selectedTestTypes) {
        testPage.waitUntilPageIsLoaded();
        List<String> actualData = testPage.findAllTestTypesFromListByClassName();
        for (String expectedTestType : selectedTestTypes) {
            assertThat(actualData.contains(expectedTestType)).isTrue();
        }
    }

    @Step
    public void checkNoIdentifyVehicleOptionAvailable() {
        testPage.waitUntilPageIsLoaded();
        int numberOfElementsFound = testPage.checkDataByLabelValueAndName("Identify", "Vehicle");
        assertThat(numberOfElementsFound).isEqualTo(0);
    }

    @Step
    public void selectNotCompleteTest(String testName) {
        testPage.waitUntilPageIsLoaded();
        testPage.clickOnNotCompleteTest(testName);
    }

    @Step
    public void selectAbandonedTest(String testName) {
        testPage.waitUntilPageIsLoaded();
        testPage.clickOnAbandonedTest(testName);
    }

    @Step
    public void checkTestSubmitted() {
        assertThat(testPage.isSubmitButtonAvailable()).isTrue();
    }

    @Step
    public void swipeTestType(String testType) {
        int initialXPosition = testPage.getXPositionForElement(testType);
        testPage.swipeLeftOnTestType(testType);
        int newXPosition = testPage.getXPositionForElement(testType);
        assertThat(initialXPosition).isNotEqualTo(newXPosition);

    }

    @Step
    public void checkTestTypeRemoveButtonVisibility() {
        assertThat(testPage.isRemoveButtonDisplayed()).isTrue();
    }

    @Step
    public void pressTestTypeRemoveButton() {
        testPage.clickOnRedRemoveButton();
    }

    @Step
    public void checkTestTypeRemovalPopUp() {
        assertThat(testPage.isRemovePopUpDisplayed()).isTrue();
    }

    @Step
    public void pressRemoveInPopUp() {
        testPage.clickRemoveFromPopUp();
    }

    @Step
    public void checkTestTypeDeleted(String selectedTestType) {
        List<String> actualData = testPage.findAllTestTypesFromListByClassName();
        for (String testType : actualData) {
            assertThat(testType.contains(selectedTestType)).isFalse();
        }
    }

    @Step
    public void pressCancelInPopUp() {
        testPage.clickCancelFromPopUp();
    }

    @Step
    public void pressCancelBottomRight() {
        testPage.clickCancelFromBottomRight();
    }

    @Step
    public void checkAddALinkedTestButtonVisibility() {
        assertThat(testPage.isAddALinkedTestVisible()).isTrue();
    }

    @Step
    public void addLinkedTestType() {
        testPage.addALinkedTestType();
    }

    @Step
    public void checkTestTypeAbandonButtonVisibility() {
        assertThat(testPage.isAbandonButtonDisplayed()).isTrue();
    }

    @Step
    public void pressTestTypeAbandonButton() {
        testPage.pressAbandonButton();
    }

    @Step
    public void checkPageTitleDisplayed() {
        assertThat(testPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void selectOdometerReading() {
        testPage.clickOdometerReading();
    }

    @Step
    public void checkOdometerReadingButton(TestPage.OdometerUnitIndicatives odometerUnitIndicatives) {
        assertThat(testPage.isOdometerButtonIndicativeDisplayed(odometerUnitIndicatives)).isTrue();
    }

    @Step
    public void checkOdometerReadingValue(String value) {
        assertThat(testPage.getOdometerValue().equals(value)).isTrue();
    }

    @Step
    public void selectAnnualTestReading() {
        testPage.clickAnnualTeswtReading();
    }
    @Step
    public void clickConfirm() {
        testPage.waitUntilPageIsLoaded();
        testPage.clickReviewAndConfirm();
    }

    @Step
    public void checkTestNotCompleteDisplayedAndOkButton() {
        assertThat(testPage.isTestNotCompleteDisplayed()).isTrue();
        assertThat(testPage.buttonOkIsClickable());
    }


    @Step
    public void waitUntilPageIsLoaded() {
        testPage.waitUntilPageIsLoaded();
    }

    @Step
    public void checkTestTypeStatus(String testType, TestPage.TestTypeStatuses status) {
        assertThat(testPage.isTestTypeStatusDisplayed(testType, status)).isTrue();
    }

    @Step
    public void selectTestType(String testType, TestPage.TestTypeStatuses testTypeStatus) {
        testPage.waitUntilPageIsLoaded();
        testPage.clickOnTestType(testType, testTypeStatus);
    }

    @Step
    public void checkCancelButton() {
        assertThat(testPage.isCancelButtonDisplayed()).isTrue();
    }

    @Step
    public void selectVehicleDetails() {
        testPage.clickVehicleDetails();
    }

    @Step
    public void chickOnButton() {
        testPage.clickOkButton();
    }

    @Step
    public void selectVehicleCategoryOption() {
        testPage.clickEUVehicleCategoryOption();
    }

    @Step
    public void checkEUVehicleCategoryOptionIsDisplayed () {
        assertThat(testPage.checkEUVehicleCategoryOptionIsDisplayed()).isTrue();
    }

    @Step
    public void checkIfCorrectOptionIsDisplayed(String category) {
        assertThat(testPage.checkMCategoryIsSelected(category)).isTrue();
    }

    @Step
    public void checkNoEUCategoryIsSelected() {
        assertThat(testPage.checkNoEUCategoryIsSelected()).isTrue();
    }

    @Step
    public void checkCountryOfregistrationOptionIsDisplayed () {
        assertThat(testPage.checkCountryOfregistrationOptionIsDisplayed()).isTrue();
    }

    @Step
    public void clickCountryOfRegistrationOption() {
        testPage.clickCountryOfRegistrationOption();
    }

    @Step
    public void checkCountryOfRegistrationFieldIsUpdated(String countryOfRegistration) {
        assertThat(testPage.checkCountryOfRegistrationFieldIsUpdated(countryOfRegistration)).isTrue();
    }

    @Step
    public void reviewAction() {
        testPage.clickReviewButton();
    }
}
