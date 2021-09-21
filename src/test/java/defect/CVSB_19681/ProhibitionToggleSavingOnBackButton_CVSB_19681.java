package defect.CVSB_19681;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ProhibitionToggleSavingOnBackButton_CVSB_19681 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

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

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Title("CVSB-19681 - AC1 - VSA does not Save the Prohibition ON selection, defect not previously added")
    @Test
    public void testProhibitionToggleSave() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (c) * DANGEROUS");
        defectDetailsSteps.selectHorizontalLateralAxleNotDone("Inner", "Offside", "3");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.selectDefect("8.1 (c) * DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOff();

        //AC4 VSA Cancels the Prohibition selection where Prohibition previously OFF
        defectDetailsSteps.selectHorizontalLateralAxleNotDone("Inner", "Offside", "3");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.saveDefectDetails();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.clickBack();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOff();
        defectDetailsSteps.saveDefectDetails();

        //AC6 The VSA saves the prohibition to ON when it was previously OFF
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.saveDefectDetails();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOn();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();

        //AC2  - VSA Saves the Prohibition ON selection, defect not previously added
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.selectDefectFromList("8. Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre");
        defectDescriptionSteps.selectDefect("8.1 (c) * DANGEROUS");
        defectDetailsSteps.selectHorizontalLateralAxleNotDone("Inner", "Offside", "3");
        defectDetailsSteps.scrollDefectDetailsPage();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.saveDefectDetails();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOn();
        defectDetailsSteps.saveDefectDetails();

        //AC3 VSA Cancels the Prohibition selection where Prohibition previously ON
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.clickBack();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOn();
        defectDetailsSteps.saveDefectDetails();

        //AC5 The VSA saves the prohibition to OFF when it was previously ON
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.saveDefectDetails();
        testTypeDetailsSteps.clickOnDefect("8.1 (c) DANGEROUS");
        defectDetailsSteps.checkProhibitionIssuedSwitchOff();
    }
}
