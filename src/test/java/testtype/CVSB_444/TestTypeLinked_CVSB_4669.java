package testtype.CVSB_444;

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
public class TestTypeLinked_CVSB_4669 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Test
    @Title("CVSB-444 - TCD - AC1 As a VSA I would like to view only relevant linked tests so that I don't have to go through the full test type taxonomy (Part Paid Retest Any PSV)")
    public void testListFromAddLinkedTestType() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(), "Retest");
        testTypeCategorySteps.selectFromTestTypeList("Part Paid");
        testTypeCategorySteps.selectFromTestTypeList("Any PSV");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkTestTypeListHasOnlySomeTestTypes("Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
    }
}
