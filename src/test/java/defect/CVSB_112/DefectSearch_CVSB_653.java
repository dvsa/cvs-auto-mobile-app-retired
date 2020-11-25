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
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_653 extends BaseTestClass {

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
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-112 - AC6 Test returning from search results")
    @Test
    public void testReturningFromSearchResults() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");

        defectCategorySteps.checkListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        defectCategorySteps.searchForDefect("Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(2, "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(0, "1. Registration Plate");
        defectCategorySteps.clearSearch();
        defectCategorySteps.checkExpectedPresentDefects(4, "3. Seat Belts & Supplementary Restraint Systems" , "1. Registration Plate");
        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");

        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect("Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(2, "1. Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(0, "2. Anchorages:");
        defectItemSteps.clearSearch();
        defectItemSteps.checkExpectedPresentDefects(4, "1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");

        defectDescriptionSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectDescriptionSteps.searchForDefect("missing.".toUpperCase());
        defectDescriptionSteps.checkExpectedPresentDefects(1, "missing.");
        defectDescriptionSteps.checkExpectedPresentDefects(0, "of an incorrect type.");
        defectDescriptionSteps.clearSearch();
        defectDescriptionSteps.checkExpectedPresentDefects(1, "missing.");
        defectDescriptionSteps.checkExpectedPresentDefects(1, "of an incorrect type.");

    }
}
