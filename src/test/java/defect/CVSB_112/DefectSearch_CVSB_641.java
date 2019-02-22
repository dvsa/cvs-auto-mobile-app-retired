package defect.CVSB_112;

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
public class DefectSearch_CVSB_641 extends BaseTestClass {

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


    @Title("CVSB-112 AC1 Test cancel adding a level 1 defect category")
    @Test
    public void cancelAddingALevelOneDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("1. Registration Plate", "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.clickBack();
        testTypeDetailsSteps.checkDefectWasNotAdded("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate");

    }
}
