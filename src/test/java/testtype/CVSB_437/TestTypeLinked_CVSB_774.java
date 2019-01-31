package testtype.CVSB_437;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeLinked_CVSB_774 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    // TODO create a modular step to go to specific test types from multiple subcategories
    @Title("CVSB-437 - Add a linked test")
    @Test
    public void testAddALinkedTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkInTestTypeList( "class 6a (seatbelt installation check)", "annual test", "retest");
        testTypeCategorySteps.selectFromTestTypeList("retest");
        testTypeSubcategorySteps.seeInTestTypeList("paid", "part paid");
        testTypeSubcategorySteps.selectFromTestTypeList("paid");
        testTypeSubcategorySteps.seeInTestTypeList("any psv", "class 6a (seatbelt installation check)");
        testTypeSubcategorySteps.selectFromTestTypeList("any psv");
        testSteps.checkSelectedTestTypes("any psv In progress arrow forward");

    }

}
