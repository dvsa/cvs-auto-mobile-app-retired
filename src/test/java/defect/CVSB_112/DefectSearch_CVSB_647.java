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
public class DefectSearch_CVSB_647  extends BaseTestClass {

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


    @Title("CVSB-112 - AC5 Test returning to search results")
    @Test
    public void defectGoBackFromFirstLevelToMain() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("ANNUAL TEST");
        testTypeSteps.selectAddDefect("ANNUAL TEST");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        recordDefectSteps.searchForDefect(")*{(][}" + RandomStringUtils.randomPrint(8));
        recordDefectSteps.checkNoResultsFoundAndSuggestion();


    }
}