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
public class DefectRemove_CVSB_2572 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-2569 - CLONE - AC1 - Remove defect")
    public void testRemoveDefectPopUp() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkDefectsArePresentForTest("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.checkDefectRemovalPopUp();
    }
}
