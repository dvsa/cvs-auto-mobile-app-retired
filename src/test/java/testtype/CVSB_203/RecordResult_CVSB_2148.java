package testtype.CVSB_203;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class RecordResult_CVSB_2148 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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

    @WithTag("In_Test")
    @Title("CVSB-203 - AC 1 - Start a test type (Prohibition Clearence Any PSV Full Inspection & Fee No Certificate)")
    @Test
    public void testStartATestTypeProhibitionClearance() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Prohibition clearance");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Prohibition clearance");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Any PSV");
        testTypeSubcategorySteps.selectFromTestTypeList("Full inspection/ full fee");
        testTypeSubcategorySteps.waitForPageToLoadBySubcategory("Full inspection/ full fee");
        testTypeSubcategorySteps.selectFromTestTypeList(("Without certification"));
        testSteps.selectTestType("Prohibition clearance", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.checkAddDefectIsPresent();
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.checkNumberOfSeatbelts("Enter");
        testTypeDetailsSteps.checkNotesText("Add notes");
    }
}
