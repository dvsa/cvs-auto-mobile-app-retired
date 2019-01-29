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
public class DefectAdd_CVSB_668 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSteps testTypeSteps;

    @Steps
    TestSteps testSteps;

    @Title("CVSB-139 - AC1 - Add a defect from test type details screen")
    @Test
    public void testTypeAddDefectOption() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("annual test");
        testTypeSteps.checkTestTypeResultAndVehicleDetailsOption("annual test", "PASS");
        testTypeSteps.checkAddDefectIsPresent();
    }
}
