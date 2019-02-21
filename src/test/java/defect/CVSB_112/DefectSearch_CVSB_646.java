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


    @Title("CVSB-112 - AC4 Search with the search bar")
    @Test
    public void searchDefectUsingSearchBar() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate");
        defectCategorySteps.searchForDefect("3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(2, "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(0, "1. Registration Plate");
        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");

        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect("1. Obligatory Seat Belt:");
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
