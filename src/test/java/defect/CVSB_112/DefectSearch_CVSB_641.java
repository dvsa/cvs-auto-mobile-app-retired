package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.DefectItemSteps;
import steps.RecordDefectSteps;
import steps.TestSteps;
import steps.TestTypeSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_641 extends BaseTestClass {

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


    @Title("CVSB-112 AC1 Test cancel adding a level 1 defect category")
    @Test
    public void cancelAddingALevelOneDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("annual test");
        testTypeSteps.selectAddDefect("annual test");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        recordDefectSteps.clickBack();
        testTypeSteps.checkTestWasNotAdded("annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate");

    }
}
