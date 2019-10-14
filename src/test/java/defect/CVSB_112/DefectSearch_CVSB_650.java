package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_650  extends BaseTestClass {

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


    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Title("CVSB-112 - AC4  Negative result for searching with the search bar (no results)")
    @Test
    public void checkNoResultsAllLevels() {

        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.checkListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        defectCategorySteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        defectCategorySteps.checkNoResultsFoundAndSuggestion();
        defectCategorySteps.clearSearch();
        defectCategorySteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");

        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        defectItemSteps.checkNoResultsFoundAndSuggestion();
        defectItemSteps.clearSearch();
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");

        defectDescriptionSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectDescriptionSteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        defectDescriptionSteps.checkNoResultsFoundAndSuggestion();


    }
}
