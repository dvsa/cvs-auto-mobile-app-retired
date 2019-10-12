package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_643 extends BaseTestClass {

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


    @Title("CVSB-112 - AC2 Test cancel adding a level 2 item")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void cancelAddingALevelTwoDefect() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.clickBack();
        defectCategorySteps.clickBack();
        testTypeDetailsSteps.checkDefectWasNotAdded("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate","1. Obligatory Seat Belt:", "2. Anchorages:");

    }

}
