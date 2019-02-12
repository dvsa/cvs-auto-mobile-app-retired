package testtype.CVSB_983;

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
public class EditCompletedTestType_2022 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Title("CVSB-983 - AC4 - VSA saves their edited test type details (at least one mandatory field is not populated)")
    @Test
    public void testSaveEditedDetailsOneFieldNotPopulated() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("Yes");
        testTypeDetailsSteps.inputNumberOfSeatbelt("2");
        testTypeDetailsSteps.checkNumberOfSeatbelts("2");
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkSetCarreidOutDuringTestOption("No");
        testTypeDetailsSteps.inputNumberOfSeatbelt("5");
        testTypeDetailsSteps.checkNumberOfSeatbelts("5");
        testTypeDetailsSteps.pressSave();
        testSteps.checkTestTypeStatus("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
    }
}
