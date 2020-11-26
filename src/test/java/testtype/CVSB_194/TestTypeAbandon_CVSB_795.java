package testtype.CVSB_194;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import steps.*;
import steps.composed.AbandonTestComp;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeAbandon_CVSB_795 extends BaseTestClass {

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




    @Title("CVSB-194 - AC1 Text box for additional comments")
    @Test
    public void testTextBoxForAdditionalComments() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        abandonTestComp.goToAbandonTestScreen(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        abandonTestSteps.checkAbandonTestPage();
        abandonTestSteps.checkSelectedReasons(SelectReasonPage.Reasons.REASON_8, SelectReasonPage.Reasons.REASON_12,
                SelectReasonPage.Reasons.REASON_6, SelectReasonPage.Reasons.REASON_2);
        abandonTestSteps.checkCommentSection();
    }

}
