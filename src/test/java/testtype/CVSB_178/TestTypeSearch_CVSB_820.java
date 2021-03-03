package testtype.CVSB_178;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.TestSteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeSubategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class TestTypeSearch_CVSB_820 extends BaseTestClass {
    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeSubategoryComp testTypeSubategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;

    @Ignore("CVSB-12952: VTA FE Maintenance - increasing suite efficiency")
    @Title("CVSB-178 - Add test type from the latest level of test type drilldown")
    public void testAddTestTypeFromLatestLevel() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeSubategoryComp.goToTestTypeSubcategoryFromCategory("Retest", preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testTypeSubcategorySteps.seeInTestTypeList("Paid", "Part paid");
        testTypeSubcategorySteps.selectFromTestTypeList("Paid");
        testTypeSubcategorySteps.seeInTestTypeList("Any PSV", "Class 6A (seatbelt installation check)");
        testTypeSubcategorySteps.selectFromTestTypeList("Class 6A (seatbelt installation check)");
        testSteps.checkTestDetails("BQ91YHQ", "1B7GG36N12S678410");
        testSteps.checkSelectedTestTypes("Retest");

    }

}
