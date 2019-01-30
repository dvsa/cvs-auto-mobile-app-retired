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
        testTypeCategorySteps.checkInTestTypeList("class 6a (seatbelt installation check)", "annual test", "retest",
                "prohibition clearence", "technical test", "voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("class 6a (seatbelt installation check)");
        testTypeSubcategorySteps.seeInTestTypeList("annual");

    }

}
