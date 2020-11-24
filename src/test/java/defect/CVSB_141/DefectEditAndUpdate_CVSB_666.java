package defect.CVSB_141;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectEditAndUpdate_CVSB_666 extends BaseTestClass {

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

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;


    @Title("CVSB-141 - AC1 - Edit and update defect from test type details screen")
    @WithTag("Smoke_2")
    @Test
    public void testEditAndUpdateFromTestTypeDetails() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.checkDefectsArePresentForTest("Annual test", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt");
        // TODO find a better method for existing defect selection
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.selectOptionsWithPRSCheckAndTapDone("Upper", "Nearside", "2", "2");
        testTypeDetailsSteps.checkAdditionalDetailsWithPRSPresent("Annual test", "3.1", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b) of an incorrect type.");
    }


}
