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
        testTypeCategorySteps.checkInTestTypeList("ANNUAL TEST", "Class 6A (Seatbelt Installation Check)", "RETEST");
        testTypeCategorySteps.selectFromTestTypeList("RETEST");
        testTypeSubcategorySteps.seeInTestTypeList("PAID", "PART PAID");
        testTypeSubcategorySteps.selectFromTestTypeList("PAID");
        testTypeSubcategorySteps.seeInTestTypeList("Any PSV", "CLASS 6A (Seatbelt Installation Check)");
        testTypeSubcategorySteps.selectFromTestTypeList("Any PSV");
        testTypeSubcategorySteps.seeInTestTypeList("Public Service Vehicle Annual Testing");
        testTypeSubcategorySteps.selectFromTestTypeList("Public Service Vehicle Annual Testing");
        testSteps.checkSelectedTestTypes("Public Service Vehicle Annual Testing Not complete");

    }

}
