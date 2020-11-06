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

@Ignore
@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_652 extends BaseTestClass {

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


    @Title("CVSB-112 - AC5 Test returning to search results")
    // De-scoped due to: CVSB-12952: VTA FE Maintenance - increasing suite efficiency
    public void testReturningToSearchResults() {

        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        defectCategorySteps.searchForDefect("Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.clickBack();
        defectCategorySteps.checkExpectedPresentDefects(2, "3. Seat Belts & Supplementary Restraint Systems");
        defectCategorySteps.checkExpectedPresentDefects(0, "1. Registration Plate");


        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect("Obligatory Seat Belt:");
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");
        defectDescriptionSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectDescriptionSteps.clickBack();
        defectItemSteps.checkExpectedPresentDefects(2, "1. Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(0, "2. Anchorages:");


        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");
        defectDescriptionSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectDescriptionSteps.searchForDefect("missing.".toUpperCase());
        defectDescriptionSteps.selectItemFromSearchList("missing.");
        defectDetailsSteps.checkPageIsLoaded();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.checkExpectedPresentDefects(1, "missing.");
        defectDescriptionSteps.checkExpectedPresentDefects(0, "of an incorrect type.");

    }
}
