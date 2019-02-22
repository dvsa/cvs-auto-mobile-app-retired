package defect.CVSB_145;

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
public class DefectRemove_CVSB_662 extends BaseTestClass {

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


    @Title("CVSB-145 - AC2 - Confirm remove defect")
    @Test
    public void testConfirmRemoveDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkDefectsArePresentForTest("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        testTypeDetailsSteps.swipeDefect("3.1 (b) MAJOR");
        testTypeDetailsSteps.pressRemove();
        testTypeDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.checkDefectRemoved("3.1 (b) MAJOR");
    }

}

