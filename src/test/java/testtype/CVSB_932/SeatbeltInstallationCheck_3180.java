package testtype.CVSB_932;

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
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatbeltInstallationCheck_3180 extends BaseTestClass {

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

    @Title("CVSB-3180 - Improvement ticket - Update seatbelt installation check")
    @Test
    public void updateSeatbeltInstallationCheck() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.checkMostRecentInstallationCheckIsNotDisplayed();
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkMostRecentInstallationCheckButtonIsDisplayed();
    }
}
