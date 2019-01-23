package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.DefectItemSteps;
import steps.RecordDefectSteps;
import steps.TestSteps;
import steps.TestTypeSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_640 extends BaseTestClass {

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


    @Title("CVSB-112 - AC1 - Level 1 Test drilldrown")
    @Test
    public void defectGoBackFromSecondLevelToFirstLevel() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("ANNUAL TEST");
        testTypeSteps.selectAddDefect("ANNUAL TEST");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.clickBack();
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");

    }

}
