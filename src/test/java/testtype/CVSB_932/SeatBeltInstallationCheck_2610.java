package testtype.CVSB_932;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class SeatBeltInstallationCheck_2610 extends BaseTestClass {

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
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-2610 - Improvement ticket - Change 'carried out a seatbelt check' from yes to no does not update other fields")
    @Test
    public void changeCarriedOutASeatbeltCheckUpdatesOtherFields() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(),preparerService.getPreparerByIndex(0).getPreparerName(),super.username);
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.waitUntilPageIsLoaded();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbelts("4");
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.verifyMostRecentInstallationCheckDate();
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("Yes");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbelts("4");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.setCarriedOutDuringTest(false);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkSetCarriedOutDuringTestOption("No");
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.checkNumberOfSeatbeltsIsDisplayed();
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.verifyThatNoRecentInstallationDateIsDisplayed();
    }
}
