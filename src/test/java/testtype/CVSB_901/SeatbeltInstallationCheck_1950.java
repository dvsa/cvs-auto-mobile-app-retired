package testtype.CVSB_901;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_1950 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-901 - AC8 - Edit number of seat belts fitted - from value = zero")
    @Test
    public void testEditNumberOfSeatbeltsDifferentFromZeroBehaviour() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.inputNumberOfSeatbelt("0");
        testTypeDetailsSteps.checkNumberOfSeatbelts("0");
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.inputNumberOfSeatbelt("1");
        testTypeDetailsSteps.checkNumberOfSeatbelts("1");
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsDisplayed();
    }
}
