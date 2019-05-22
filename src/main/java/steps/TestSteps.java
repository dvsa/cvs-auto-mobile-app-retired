package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.TestPage;

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
        for (String expectedTestType : selectedTestTypes) {
            assertThat(testPage.isTestTypeDisplayedByXpath(expectedTestType)).isTrue();
        }
    }

    @Step
    public void checkNoIdentifyVehicleOptionAvailable() {
        testPage.waitUntilPageIsLoaded();
        int numberOfElementsFound = testPage.checkDataByLabelValueAndName("Identify", "arrow back Identify Vehicle", "arrow back Vehicle", "arrow back Identify", "Identify vehicle",
                "arrow back identify vehicle", "arrow back vehicle", "arrow back identify", "identify vehicle", "Identify Vehicle arrow forward", "Vehicle arrow forward", "Identify arrow forward",
                "identify vehicle arrow forward", "vehicle arrow forward", "identify arrow forward");
        assertThat(numberOfElementsFound).isEqualTo(0);
    }

    @Step
    public void checkReviewButton() {
        assertThat(testPage.isReviewButtonAvailable()).isTrue();
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
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isTestTypeDisplayedByXpath(selectedTestType)).isFalse();
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
    public void clickConfirm() {
        testPage.waitUntilPageIsLoaded();
        testPage.clickReviewButtonAndScroll();
    }

    @Step
    public void checkTestNotCompleteDisplayedAndOkButton() {
        assertThat(testPage.isTestNotCompleteDisplayed()).isTrue();
        assertThat(testPage.buttonOkIsClickable()).isTrue();
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
    public void clickOkButton() {
        testPage.clickOkButton();
    }

    @Step
    public void selectVehicleCategoryOption() {
        testPage.clickEUVehicleCategoryOption();
    }

    @Step
    public void checkEUVehicleCategoryOptionIsDisplayed() {
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
    public void checkCountryOfRegistrationOptionIsDisplayed() {
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
    public void reviewActionAndScroll() {
        testPage.clickReviewButtonAndScroll();
    }

    @Step
    public void reviewAction(){
        testPage.clickReviewButton();
    }
}
