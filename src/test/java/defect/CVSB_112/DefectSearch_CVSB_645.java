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
public class DefectSearch_CVSB_645 extends BaseTestClass {

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
    TestTypeCategorySteps testTypeCategorySteps;


    @Title("CVSB-112 - AC3 Test cancel adding a level 3 defect description")
    @Test
    public void cancelAddingALevelThreeDefect() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.checkPageIsLoaded();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.clickBack();
        testTypeDetailsSteps.checkDefectWasNotAdded("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate","1. Obligatory Seat Belt:", "2. Anchorages:");

    }

}
