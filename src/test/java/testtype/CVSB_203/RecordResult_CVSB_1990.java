package testtype.CVSB_203;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class RecordResult_CVSB_1990 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-203 - AC6 – Select results for test types (Pass)")
    public void testSelectResultForTestTypePass() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestResultField();
        testTypeDetailsSteps.setTestToOption("Pass");
        testTypeDetailsSteps.checkTestIsPassed();

    }
}
