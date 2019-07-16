package defect.CVSB_439;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.TestSteps;
import steps.TestTypeCategorySteps;
import steps.TestTypeDetailsSteps;
import steps.TestTypeSubcategorySteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ProhibitionIssuedToggle_CVSB_5732 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubcategorySteps;


    @Title("CVSB-439 - AC7 - VSA switches prohibition issued field off for a test type")
    @Ignore("Story not yet merged")
    @Test
    public void testProhibitionIssuedTestTypeSwitchOff() {
        testTypeCategoryComp.goToTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testTypeCategorySteps.selectFromTestTypeList("Technical test");
        testTypeSubcategorySteps.selectFromTestTypeList("LEC");
        testSteps.selectTestType("Technical test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setProhibisionIssued();
        testTypeDetailsSteps.checkProhibitionIssuedSwitchOn();
        testTypeDetailsSteps.setProhibisionIssued();
        testTypeDetailsSteps.checkProhibitionIssuedSwitchOff();
    }

}
