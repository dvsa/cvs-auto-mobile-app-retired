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
public class TestTypeRemove_CVSB_761 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-176 - AC2 Pressing remove button")
    @Test
    public void testPressRemoveTestTypeButton() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.swipeTestType("ANNUAL TEST In progress arrow forward");
        testSteps.checkTestTypeRemoveButtonVisibility();
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();

    }
}
