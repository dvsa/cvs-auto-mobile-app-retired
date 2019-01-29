package defect.CVSB_145;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectRemove_CVSB_663 extends BaseTestClass {

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
    DefectDetailsSteps defectDetailsSteps;


    @Title("CVSB-145 - AC3 - Cancel remove defect")
    @Test
    public void testCancelRemoveDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.tapAddDefect();
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        testTypeSteps.swipeDefect("3.1.b MAJOR");
        testTypeSteps.pressRemove();
        testTypeSteps.pressCancelInPopUp();
        testTypeSteps.checkDefectIsNotRemoved("3.1.b MAJOR");
    }

}
