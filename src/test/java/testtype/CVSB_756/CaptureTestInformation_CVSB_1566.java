package testtype.CVSB_756;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1566 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;


    @Title("CVSB-756 - AC3 - Access a test type")
    @Test
    public void testAccessATestType() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ", vehicleService.getVehicle().getVim());
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.checkSelectedTestTypes("Annual test In progress arrow forward");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkTestTypeDetailsPage();
    }

}
