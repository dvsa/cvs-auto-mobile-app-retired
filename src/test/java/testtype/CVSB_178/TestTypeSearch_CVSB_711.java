package testtype.CVSB_178;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_711 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Title("CVSB-178 - AC1 Test test type drilldown")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testTestTypeDrillDown() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkAddATestTypeButtonVisibility();
        testSteps.addTestType();
        testTypeCategorySteps.checkInTestTypeList("Annual test", "Class 6A", "Retest",
                "Prohibition clearance", "Technical test", "Voluntary test");
        testTypeCategorySteps.checkTestTypePage();

    }
}
