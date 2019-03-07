package testresults.CVSB_980;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class AutoCalculatedTestResults_2694 extends BaseTestClass {
    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    SignatureSteps signatureSteps;

    @Title("CVSB_980 - AC1 - Pass criteria (No defects)")
    @Test
    public void passCriteriaWithNoDefects() {
        loginSteps.logIn("cvs.automation2@dvsagov.onmicrosoft.com", "CvsTester@123");
        signatureSteps.createSignatureIfNeeded();
        testTypeCategoryComp.goToTestPage("TC7524","Avello Edinburgh Ltd");
        testSteps.clickCountryOfRegistrationOption();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("8");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("8");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
    }
}
