package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TestPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps extends ScenarioSteps {

    TestPage testPage;

    private static final String MESSAGE_COMPLETE_TEST_DETAILS = "You must complete all vehicle and test type details before reviewing.";
    private static final String NO_TEST_TYPE_ADDED_TITLE = "No test type added";
    private static final String NO_TEST_TYPE_ADDED_INFO = "Add a test type before reviewing.";

    @Step
    public void addTestType() {
        testPage.waitUntilPageIsLoaded();
        testPage.addTestType();
    }

    @Step
    public void addTestTypeFor(String vehicle) {
        testPage.waitUntilPageIsLoaded();
        testPage.addTestTypeFor(vehicle);
    }

    @Step
    public void checkTestDetails(String regPlate, String vin) {
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isPageTitleDisplayed() && testPage.isVehicleRegistrationPlateDisplayed(regPlate, vin)).isTrue();
    }

    @Step
    public void checkTrailerTestDetails(String trailer, String vin) {
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isPageTitleDisplayed() && testPage.isTrailerRegistrationPlateDisplayed(trailer, vin)).isTrue();
        System.out.println(getDriver().getPageSource());
    }

    @Step
    public void checkAddATestTypeButtonVisibility() {
        assertThat(testPage.isAddATestTypeButtonDisplayed()).isTrue();
    }

    @Step
    public void checkAddATrailerButtonVisibility(){
        assertThat(testPage.checkAddATrailerButtonIsDisplayed()).isTrue();
    }

    @Step
    public void checkAddATrailerButtonExistence(){
        assertThat(testPage.checkAddATrailerButtonIsPresent()).isEqualTo(0);
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
    public void checkReviewAndSubmitButton() {
        assertThat(testPage.isReviewAndSubmitButtonAvailable()).isTrue();
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
        testPage.waitUntilPageIsLoaded();
        assertThat(testPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void selectOdometerReading() {
        testPage.clickOdometerReading();
    }

    @Step
    public void clickOdometerReadingFor(String vehicle) {
        testPage.clickOdometerReadingOf(vehicle);
    }

    @Step
    public void checkOdometerReadingButton(TestPage.OdometerUnitIndicatives odometerUnitIndicatives) {
        assertThat(testPage.isOdometerButtonIndicativeDisplayed(odometerUnitIndicatives)).isTrue();
    }

    @Step
    public void checkOdometerReadingIsSelected(TestPage.OdometerUnitIndicatives odometerUnitIndicatives) {
        // The checkmark is verified in the followoing function.
        checkOdometerReadingButton(odometerUnitIndicatives);
    }

    @Step
    public void checkOdometerReadingValue(String value) {
        // This check will remove any numerical formatting from the number and do a basic value comparison.
        // "1,234" will be stripped to be "1234".
        assertThat(testPage.getOdometerValue().replace(",","").equals(value)).isTrue();
    }

    @Step
    public void checkOdometerReadingValueFormatted(String value) {
        // This check will do a raw, visual comparison of the odometer reading (so may look like "1, 234").
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
    public void checkEUVehicleCategoryOptionIs(String category) {
        assertThat(testPage.checkMCategoryIsSelected(category)).isTrue();
    }

    @Step
    public void checkEUVehicleCategoryOptionIsSelected(String category) {
        checkEUVehicleCategoryOptionIs(category);
    }

    @Step
    public void checkNoEUCategoryIsSelected() {
        assertThat(testPage.checkNoEUCategoryIsSelected()).isTrue();
    }

    @Step
    public void checkCountryOfRegistrationOptionIsDisplayed() {
        assertThat(testPage.checkCountryOfRegistrationOptionIsDisplayed()).isTrue();
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
    public void clickReview(){
        testPage.clickReviewAndSubmitButton();
    }

    @Step
    public void checkErrorMessageMandatoryFieldsDisplayed() {
        assertThat(testPage.checkMessageIsDisplayed(MESSAGE_COMPLETE_TEST_DETAILS)).isTrue();
    }

    @Step
    public void checkErrorMessageMandatoryFieldsNotDisplayed() {
        assertThat(testPage.checkMessageIsDisplayed(MESSAGE_COMPLETE_TEST_DETAILS)).isFalse();
    }

    @Step
    public void checkErrorMessageNoTestTypeAdded() {
        assertThat(testPage.checkMessageIsDisplayed(NO_TEST_TYPE_ADDED_TITLE)).isTrue();
    }

    @Step
    public void checkErrorMessageAddATestTypeBeforeReviewing() {
        assertThat(testPage.checkMessageIsDisplayed(NO_TEST_TYPE_ADDED_INFO)).isTrue();
    }

    @Step
    public void checkHgvTestDetails(String hgv, String vin) {
            testPage.waitUntilPageIsLoaded();
            assertThat(testPage.isPageTitleDisplayed() && testPage.isHgvRegistrationPlateDisplayed(hgv, vin)).isTrue();
        }

    @Step
    public void selectHgvDetails() {
        selectVehicleDetails();
    }

    @Step
    public void selectTrailerDetails() {
        selectVehicleDetails();
    }

    @Step
    public void clickAddATrailerButton() {
        testPage.waitUntilPageIsLoaded();
        testPage.clickAddATrailerButton();
    }

    @Step
    public void checkAddAVehicleButtonVisibility() {
        assertThat(testPage.checkAddAVehicleButtonIsDisplayed()).isTrue();
    }

    @Step
    public void clickAddAVehicleButton() {
        testPage.waitUntilPageIsLoaded();
        testPage.clickAddAVehicleButton();
    }

    @Step
    public void checkOdometerOptionIsDisplayed() {
        assertThat(testPage.OdometerOptionIsDisplayed()).isTrue();
    }

    @Step
    public void checkPropertyIsDisplayedXTimes(String category, int times){
        assertThat(testPage.isPropertyDisplayedXTimes(category, times)).isTrue();
    }

    @Step
    public void checkVehicleCardIsDisplayedAfterVehicle(String item1, String item2) {
        assertThat(testPage.isItemDisplayedAfter(item1,  item2));
    }

    @Step
    public void selectEuVehicleCategory() {
        testPage.clickEUVehicleCategoryOption();
    }

    @Step
    public void clickCountryOfRegistrationFor(String vehicle) {
        testPage.clickCountryOfRegistrationOf(vehicle);
    }

    @Step
    public void scrollDown(){
        testPage.scrollPageDown();
    }

    @Step
    public void checkCountryOfRegistrationFieldIsUpdatedFor(String country, String vehicle){
        assertThat(testPage.checkCountryOfRegistrationFieldIsUpdatedFor(country, vehicle)).isTrue();
    }

    @Step
    public void clickEuVehicleCategoryFor(String vehicle){
        testPage.clickEuVehicleCategoryFor(vehicle);
    }

}
