package testtype.CVSB_983;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.SeatbeltInstallationCheckSteps;
import steps.TestSteps;
import steps.TestTypeDetailsSteps;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class EditCompletedTestType_2021 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-983 - AC3 - VSA saves their edited details within the test type (all mandatory fields are populated)")
    @Test
    public void testSaveEditedDetailsPopulatedFields() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.completeAddTestType(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("2");
        testTypeDetailsSteps.pressSave();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.checkNumberOfSeatbelts("4");
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDateIsEdited();
    }
}
