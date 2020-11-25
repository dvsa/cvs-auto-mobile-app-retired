package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_802 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    AbandonTestComp abandonTestComp;

    @Steps
    AbandonedTestSteps abandonedTestSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;



    @Title("CVSB-194 - AC3 Edit additional comments after abandon")
    @WithTag("Smoke_2")
    @Test
    public void testEditAdditionalCommentAfterAbandon() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.addAdditionalComments("Additional Comment Test 123");
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.ABANDONED);
        abandonedTestSteps.checkAbandonedTestPage();
        abandonedTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        abandonedTestSteps.checkAddedComment("Additional Comment Test 123");
    }

}
