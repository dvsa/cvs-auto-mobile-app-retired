package defect.CVSB_439;

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
public class ProhibitionIssuedToggle_CVSB_5728 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;


    @Title("CVSB-439 - AC4 - VSA clicks OK when presented with a prohibition pop up message")
    @Ignore("CVSB-8749 - maintenance for improving test suite speed")
    @Test
    public void testProhibitionNotEnabledPopUpCloseNoAsterisk() {
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("7. Size and Type of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("7.1 (a) (ii) DANGEROUS");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.checkProhibitionIssuedSwitchOff();
        defectDetailsSteps.tapDone();
        defectDetailsSteps.checkProhibitionPopUpNoAsteriskDefect();
        defectDetailsSteps.pressOkInProhibitionPopUp();
        defectDetailsSteps.checkProhibitionPopUpNotDisplayed();
    }

}
