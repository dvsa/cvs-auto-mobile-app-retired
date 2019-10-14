package defect.CVSB_2569;

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
public class DefectRemove_CVSB_2574 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-2569 - CLONE - AC3 - Cancel removal of defect")
    @Test
    public void testCancelRemovalOfDefect() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkDefectsArePresentForTest("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressCancelInPopUp();
        defectDetailsSteps.checkPageTitleIsDisplayed();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.checkDefectIsNotRemoved("3.1 (b) MAJOR");
    }
}
