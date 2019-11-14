package testtype.CVSB_444;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestTypeLinked_CVSB_4679 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    ConfirmationPageSteps confirmationPageSteps;

    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    @Title("CVSB-444 - TCD - AC1 As a VSA I would like to view only relevant linked tests so that I don't have to go through the full test type taxonomy (Prohibition Clearance Class 6A Full Inspection and Fee)")
    public void testListFromAddLinkedTestTypeVoluntaryTestHeadlampAimTest() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(), "Voluntary test");
        testTypeCategorySteps.selectFromTestTypeList("Headlamp aim test");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("1");
        odometerReadingSteps.checkReadingValue("1");
        odometerReadingSteps.pressSave();
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.pressSave();
        testSteps.addLinkedTestType();
        testTypeCategorySteps.selectFromTestTypeList("Voluntary test");
        testTypeCategorySteps.checkTestTypeListOnlyContainsTestTypes("Brake test",
                "Smoke test", "Speed limiter check");
        testTypeCategorySteps.selectFromTestTypeList("Brake test");
        testSteps.selectTestType("Voluntary test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setTestToOption("pass");
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.scrollDown();
        testReviewSteps.pressSubmit();
        testReviewSteps.pressSubmitInPopUp();
        confirmationPageSteps.pressDone();
        siteVisitSteps.checkCreateTestButton();
    }
}
