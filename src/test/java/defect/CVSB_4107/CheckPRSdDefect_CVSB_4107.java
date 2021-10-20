package defect.CVSB_4107;

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
public class CheckPRSdDefect_CVSB_4107 extends BaseTestClass {

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

    @Title("CVSB-4107 - AC1 - Select PRS on Dangerous Defect, AC2 - Do not select PRS on Dangerous Defect, AC4 - Do not Save the PRS OFF selection")
    @Test
    public void toggleDefectWithPRS() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");

        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.setPRS();
        // TODO set up build to get path and check PRS lozenge present
        defectDetailsSteps.setPRS();
        defectDetailsSteps.clickBack();
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();
    }

    @Title("CVSB-4107 - AC3 Do not save PRS ON selection")
    @Test
    public void testDoNotSaveAndEditSavePRSonSelect() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);

        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.selectInputValuesWithPRSAndClickBack("Upper","Nearside","4", "4");
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();
    }

    @Title("CVSB-4107 - AC5 - Save the PRS ON selection, AC6 - Save the PRS OFF selection, AC7 - Cancel the PRS selection where PRS previously OFF. AC8 - Cancel the PRS selection where PRS previously ON")
    @Test
    public void togglePRSReturnToDefectDesc() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");

        defectCategorySteps.selectDefectFromList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("1. Obligatory Seat Belt");
        defectDescriptionSteps.selectDefect("3.1 (b) MAJOR");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.selectVerticalLateralRowNumberSeatNumber("Upper","Nearside","4", "4");
        testTypeDetailsSteps.checkAdditionalDetailsWithPRSPresent("Annual test", "3.1", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b) of an incorrect type.");

        // AC - 6
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.tapDone();
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();

        //AC - 7
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.clickBack();
        defectDetailsSteps.checkPRSOptionIsNotDisplayed();

        //AC - 8
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.tapOnPresentDefect("Annual test", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.setPRS();
        defectDetailsSteps.clickBack();
        testTypeDetailsSteps.checkAdditionalDetailsWithPRSPresent("Annual test", "3.1", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b) of an incorrect type.");
    }
}
