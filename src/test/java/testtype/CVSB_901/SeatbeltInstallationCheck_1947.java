package testtype.CVSB_901;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_1947 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-901 - AC5 - Record number of seat belts fitted")
    @Test
    public void testEditNumberOfSeatbelts() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectAnnualTestReading();
        testTypeDetailsSteps.inputNumberOfSeatbelt("4");
        testTypeDetailsSteps.checkTestTypeDetailsTitleIsDisplayed();
        testTypeDetailsSteps.checkNumberOfSeatbelts("4");
    }
}
