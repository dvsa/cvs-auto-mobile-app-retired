package testtype.CVSB_437;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeLinked_CVSB_773 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Title("CVSB-437 - AC1 List of test types for the 'Add a linked test' option")
    @Test
    public void testListFromAddLinkedTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.checkAddALinkedTestButtonVisibility();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkTestTypePage();
        testTypeCategorySteps.checkInTestTypeList( "class 6a (seatbelt installation check)", "annual test", "retest");

    }


}
