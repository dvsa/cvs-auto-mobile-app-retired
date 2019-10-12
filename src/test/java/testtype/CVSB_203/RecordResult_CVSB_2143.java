package testtype.CVSB_203;

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
public class RecordResult_CVSB_2143 extends BaseTestClass {


    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Title("CVSB-203 - AC1 - Start a test type (Class 6A Seatbelt Installation Check (annual test))")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testStartATestTypeClass6A() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeSubcategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Class 6A", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.checkAddDefectIsPresent();
        testTypeDetailsSteps.checkNumberOfSeatbelts("Enter");
        testTypeDetailsSteps.checkNotesText("Add notes");
    }
}
