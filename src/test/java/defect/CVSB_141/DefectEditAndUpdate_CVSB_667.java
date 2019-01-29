package defect.CVSB_141;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectEditAndUpdate_CVSB_667 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSteps testTypeSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    RecordDefectSteps recordDefectSteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectItemLevelThreeSteps defectItemLevelThreeSteps;

    @Steps
    AdvisoryDetailsSteps advisoryDetailsSteps;


    @Title("CVSB-141 - AC2 - Edit and update advisory from advisory details screen")
    @Test
    public void testEditAndUpdateFromAdvisoryDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.waitUntilPageIsLoaded();
        advisoryDetailsSteps.addCustomNoteAndTapAddNote("test note 1234");
        // TODO find a better way for advisory/defect verification
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        // TODO find a better way for existing advisory selection
        testTypeSteps.tapOnPresentDefect("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        advisoryDetailsSteps.checkExistingNote("test note 1234");
        advisoryDetailsSteps.addRandomNoteInputAndTapDone();
    }
}