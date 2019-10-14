package testtype.CVSB_176;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
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


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-176 - AC4 Cancelling removal")
    @Test
    public void testRemovalCanceling() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();
        testSteps.pressCancelInPopUp();
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("Annual test In progress arrow forward");

    }

}
