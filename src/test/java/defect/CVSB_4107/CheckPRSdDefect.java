package defect.CVSB_4107;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CheckPRSdDefect extends BaseTestClass {

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
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-139 - AC1 - Select PRS on Dangerous Defect, AC2 - Do not select PRS on Dangerous Defect")
    @Test
    public void toggleDefectWithPRS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");


        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.searchForDefect("59");
        defectCategorySteps.selectDefectFromList("59. Brake Systems and Components");
        defectItemSteps.selectDefectFromList("2. Brake pipes and flexible hoses");
        defectDescriptionSteps.selectDefect("59.2 (b) (iii) DANGEROUS");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.setPRS();
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();


//        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
//        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
//        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
//        defectDetailsSteps.setPRS();
//        defectDetailsSteps.setPRS();

//        defectCategorySteps.searchForDefect("8");
//        defectCategorySteps.selectDefectFromList("8. Condition of Tyres ");
//        defectItemSteps.selectDefectFromList("1. A Tyre:");
//        defectDescriptionSteps.selectDefect("8.1 (b) DANGEROUS");
//        defectDetailsSteps.setPRS();
//        defectDetailsSteps.setPRS();

//        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
//        testTypeDetailsSteps.checkAdditionalDetailsWithPRSPresent("Annual test", "3.1", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b) of an incorrect type.");

    }
}