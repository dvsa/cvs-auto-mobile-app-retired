package testtype.CVSB_444;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeLinked_CVSB_4684 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-444 - TCD - AC1 As a VSA I would like to view only relevant linked tests so that I don't have to go through the full test type taxonomy (Technical LEC)")
    public void relevantLinkedTestsForTechnicalLEC() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(), "Technical test", super.username);
        testTypeCategorySteps.selectFromTestTypeList("LEC");
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes("Annual test",
                "Class 6A", "Retest", "Prohibition clearance", "Technical test");
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes("Notifiable alteration");
    }
}
