package testtype.CVSB_178;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestTypeCategorySteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_818 extends BaseTestClass {

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-178 - AC1/AC2 - Select a test type category that contains other test type categories")
    @Test
    public void testTestTypeCategoryContainingOtherCategories() {
        testTypeCategoryComp.addTestType();
        testTypeCategorySteps.checkTestTypePage();
        testTypeCategorySteps.checkInTestTypeList("Annual test", "Class 6A", "Retest",
                "Prohibition clearance", "Technical test", "Voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("Class 6A");
        testTypeSubcategorySteps.seeInTestTypeList("Annual test");

    }

}
