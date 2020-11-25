package testtype.CVSB_176;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeRemove_CVSB_763 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-176 - AC4 Cancelling removal")
    public void testRemovalCanceling() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.swipeTestType("Annual test In progress arrow forward");
        testSteps.pressTestTypeRemoveButton();
        testSteps.checkTestTypeRemovalPopUp();
        testSteps.pressCancelInPopUp();
        testSteps.checkTestDetails("BQ91YHQ","1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("Annual test In progress arrow forward");
    }
}
