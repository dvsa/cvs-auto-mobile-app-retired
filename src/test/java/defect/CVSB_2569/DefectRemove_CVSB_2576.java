package defect.CVSB_2569;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectRemove_CVSB_2576 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Title("CVSB-2569 CLONE - AC5 - Confirm removal of test type")
    @Test
    public void confirmTestTypeRemoval() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypetRemovalPopUp();
        testTypeDetailsSteps.pressRemoveTestTypeInPopUp();
        testSteps.checkPageTitleDisplayed();
        testSteps.checkTestTypeDeleted("Annual test");
    }
}
