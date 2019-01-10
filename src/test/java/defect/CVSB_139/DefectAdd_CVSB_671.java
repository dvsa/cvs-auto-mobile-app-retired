package defect.CVSB_139;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectAdd_CVSB_671 extends BaseTestClass {

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

    @Title("CVSB-139 - AC4 - Add advisory defect")
    @Test
    public void addAdvisoryDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.addNoteInputTapAddNote();
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");

    }

}
