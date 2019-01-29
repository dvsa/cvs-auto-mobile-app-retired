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
public class DefectEditAndUpdate_CVSB_666 extends BaseTestClass {

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


    @Title("CVSB-141 - AC1 - Edit and update defect from test type details screen")
    @Test
    public void testEditAndUpdateFromTestTypeDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.tapAddDefect();
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        // TODO find a better method for existing defect selection
        testTypeSteps.tapOnPresentDefect("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.selectOptionsWithPRSCheckAndTapDone("upper", "nearside", "2", "2");
        testTypeSteps.checkAdditionalDetailsWithPRSPresent("Public Service Vehicle Annual Testing", "3.1.b ", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b). of an incorrect type.", "FAIL");
    }


}
