package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;


@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_645 extends BaseTestClass {

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


    @Title("CVSB-112 TCA - AC2 Test cancel adding a level 2 item")
    @Test
    public void defectGoBackFromFirstLevelToMain() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("ANNUAL TEST");
        testTypeSteps.selectAddDefect("ANNUAL TEST");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.checkPageIsLoaded();
        defectItemLevelThreeSteps.clickBack();
        defectItemSteps.clickBack();
        recordDefectSteps.clickBack();
        testTypeSteps.checkTestWasNotAdded("ANNUAL TEST", "3. Seat Belts & Supplementary Restraint Systems", "1. Registration Plate","1. Obligatory Seat Belt:", "2. Anchorages:");

    }

}
