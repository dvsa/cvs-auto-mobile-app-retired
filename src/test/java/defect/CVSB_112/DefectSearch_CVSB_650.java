package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_650  extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSteps testTypeSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    RecordDefectSteps recordDefectSteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectItemLevelThreeSteps defectItemLevelThreeSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;


    @Title("CVSB-112 - AC4  Negative result for searching with the search bar (no results)")
    @Test
    public void defectGoBackFromFirstLevelToMain() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("annual test");
        testTypeSteps.selectAddDefect("annual test");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        recordDefectSteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        recordDefectSteps.checkNoResultsFoundAndSuggestion();
        recordDefectSteps.clearSearch();
        recordDefectSteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");

        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        defectItemSteps.checkNoResultsFoundAndSuggestion();
        defectItemSteps.clearSearch();
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");

        defectItemLevelThreeSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectItemLevelThreeSteps.searchForDefect(RandomStringUtils.randomAlphanumeric(8));
        defectItemLevelThreeSteps.checkNoResultsFoundAndSuggestion();


    }
}