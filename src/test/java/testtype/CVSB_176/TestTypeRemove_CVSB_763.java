package testtype.CVSB_176;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeRemove_CVSB_763 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-176 - AC4 Cancelling removal")
    @Test
    public void testRemovalCanceling() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("Public Service Vehicle Annual Testing Not complete");
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();
        testSteps.pressCancelInPopUp();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }

}
