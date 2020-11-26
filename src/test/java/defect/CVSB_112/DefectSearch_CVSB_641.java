package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_641 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;


    @Title("CVSB-112 AC1 Test cancel adding a level 1 defect category")
    @Test
    public void cancelAddingALevelOneDefect() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("1. Registration Plate", "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.clickBack();
        testTypeDetailsSteps.checkDefectWasNotAdded("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate");
    }
}
