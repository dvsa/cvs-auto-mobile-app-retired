package testtype.CVSB_437;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeLinked_CVSB_773 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Ignore("Invalid due to CVSB-444")
    @Title("CVSB-437 - AC1 List of test types for the 'Add a linked test' option")
    public void testListFromAddLinkedTestType() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.checkAddALinkedTestButtonVisibility();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.checkTestTypePage();
        testTypeCategorySteps.checkInTestTypeList("Annual test", "Class 6A", "Retest",
                "Prohibition clearance", "Technical test", "Voluntary test");
    }


}
