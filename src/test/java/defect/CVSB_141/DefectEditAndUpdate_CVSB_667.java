package defect.CVSB_141;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectEditAndUpdate_CVSB_667 extends BaseTestClass {

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
    AdvisoryDetailsSteps advisoryDetailsSteps;


    @Title("CVSB-141 - AC2 - Edit and update advisory from advisory details screen")
    @Test
    public void testEditAndUpdateFromAdvisoryDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.waitUntilPageIsLoaded();
        advisoryDetailsSteps.addCustomNoteAndTapAddNote("test note 1234");
        // TODO find a better way for advisory/defect verification
        testTypeDetailsSteps.checkDefectsArePresentForTest("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        // TODO find a better way for existing advisory selection
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        advisoryDetailsSteps.checkExistingNote("test note 1234");
        advisoryDetailsSteps.addRandomNoteInputAndTapDone();
    }
}