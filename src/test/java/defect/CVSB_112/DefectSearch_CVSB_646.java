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
public class DefectSearch_CVSB_646 extends BaseTestClass {

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


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-112 - AC4 Search with the search bar")
    public void searchDefectUsingSearchBar() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate");
        defectCategorySteps.searchForDefect("Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(2, "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(0, "1. Registration Plate");
        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");

        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect("Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(2, "1. Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(0, "2. Anchorages:");
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");


        defectDescriptionSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectDescriptionSteps.searchForDefect("missing.".toUpperCase());
        defectDescriptionSteps.checkExpectedPresentDefects(1, "missing.");
        defectDescriptionSteps.checkExpectedPresentDefects(0, "of an incorrect type.");
        defectDescriptionSteps.selectItemFromSearchList("missing.");

        defectDetailsSteps.checkPageIsLoaded();

    }
}
