package testtype.CVSB_6988;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTechnicalTestNotifiableAlterationForHgvAndTrl_CVSB_6988 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;


    @Title("CVSB-7607 - AC1 - MANDATORY NOTES FIELD INCOMPLETE (TEST RESULT=FAIL)")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testMandatoryNotesFieldIncompleteTestResultFail() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.pressSave();
        testTypeDetailsSteps.checkErrorNotesDetailsIsDisplayed();
    }

    @Title("CVSB-7611 - AC2 - MANDATORY NOTES FIELD COMPLETE (TEST RESULT=FAIL) - direct back to test screen")
    @Test
    public void testMandatoryNotesFieldCompleteTestResultFail() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.pressSave();
        testTypeDetailsSteps.checkErrorNotesDetailsIsDisplayed();
        testTypeDetailsSteps.addNotes("Test 123");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
    }

    @Title("CVSB-7612 - AC2 - MANDATORY NOTES FIELD COMPLETE (TEST RESULT=FAIL) - entries saved")
    @Test
    public void testMandatoryAllMandatoryTestResultFail() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.addNotes("Test 123");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
    }

    @Title("CVSB-7613 - AC3 - NOTES FIELD TITLE CHANGE - FAIL")
    @Test
    public void testMandatoryNotesTitleChangeTestResultFail() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.checkNotesTitle("NOTES");
        testTypeDetailsSteps.pressSave();
        testTypeDetailsSteps.checkNotesTitle("NOTES (REQUIRED)");
    }

    @Title("CVSB-7614 - AC3b - NOTES FIELD TITLE CHANGE - PASS")
    @Test
    public void testMandatoryNotesTitleChangeTestResultPass() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Fail");
        testTypeDetailsSteps.checkTestIsFailed();
        testTypeDetailsSteps.pressSave();
        testTypeDetailsSteps.checkNotesTitle("NOTES (REQUIRED)");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkNotesTitle("NOTES");
    }

    @Title("CVSB-7615 - AC4 - NO MANDATORY FIELDS FOR TEST RESULT=PASS - directed back to test screen")
    @Test
    public void testMandatoryTestResultPass() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkNotesTitle("NOTES");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
    }

    @Title("CVSB-7616 - AC4 - NO MANDATORY FIELDS FOR TEST RESULT=PASS - entries saved")
    @Test
    public void testMandatorySavedTestResultPass() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectOption("N1");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Notifiable alteration");
        testTypeCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.IN_PROGRESS );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkNotesTitle("NOTES");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
        testSteps.checkTestTypeStatus("Technical test",TestPage.TestTypeStatuses.EDIT );
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("Paid notifiable alteration");
        testTypeDetailsSteps.checkNotesTitle("NOTES");
        testTypeDetailsSteps.checkNotesText("Add notes");
        testTypeDetailsSteps.checkTestIsPassed();
    }
}
