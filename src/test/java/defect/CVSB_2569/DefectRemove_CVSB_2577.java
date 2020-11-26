package defect.CVSB_2569;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class DefectRemove_CVSB_2577 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-2569 CLONE - AC5 - Cancel removal of test type")
    public void cancelTestTypeRemoval() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeRemoveButton();
        testTypeDetailsSteps.checkTestTypeRemovalPopUp();
        testTypeDetailsSteps.pressCancelRemoveTestTypeInPopUp();
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.pressSave();
        testSteps.checkPageTitleDisplayed();
        testSteps.checkTestTypeDeleted("Annual test In progress arrow forward");
    }
}
