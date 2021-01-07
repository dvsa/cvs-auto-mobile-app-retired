package testtype.CVSB_17409;

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
public class DefectTaxonomy_CVSB_17409 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    UtilSteps utilSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    DefectCategorySteps defectCategorySteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectDescriptionSteps defectDescriptionSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;


    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - HGV")
    @Test
    public void defectTaxonomyUpdatesHGV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (i) MAJOR", "5.1 (a) (ii) MAJOR", "5.1 (a) (iii) MAJOR");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm5();
        defectDetailsSteps.clickBack();
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (iv) MAJOR");
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("8.1 (i) DANGEROUS", "8.1 (j) (i) MINOR", "8.1 (j) (ii) MAJOR");
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
    }

    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - PSV")
    @Test
    public void defectTaxonomyUpdatesPSV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (i) MAJOR", "5.1 (a) (ii) MAJOR", "5.1 (a) (iii) MAJOR");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm5();
        defectDetailsSteps.clickBack();
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (iv) MAJOR");
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm5();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("8.1 (i) DANGEROUS", "8.1 (j) (i) MINOR", "8.1 (j) (ii) MAJOR");
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFifthIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSixthIm8();
        defectDetailsSteps.clickBack();
    }

    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - TRL")
    @Test
    public void defectTaxonomyUpdatesTRL() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("341234", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.clearSearch();

        defectCategorySteps.searchForDefect("Condition");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("8.1 (j) (i) MINOR");
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm8();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFirstIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForSecIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForThirdIm59();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkDefectDisplayForFourthIm59();
    }

    @Title("CVSB-17409 - AC2 - Additional Details for IM5 - HGV")
    @Test
    public void additionalDetailsForIm5Hgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
    }

    @Title("CVSB-17409 - AC2 - Additional Details for IM5 - PSV")
    @Test
    public void additionalDetailsForIm5Psv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
        defectDetailsSteps.clickBack();
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.waitUntilPageIsLoaded();
        defectDetailsSteps.checkLongitudinalIsNotDisplayed();
        defectDetailsSteps.checkVerticalIsNotDisplayed();
        defectDetailsSteps.checkHorizontalIsNotDisplayed();
        defectDetailsSteps.checkLateralIsNotDisplayed();
        defectDetailsSteps.checkAxleNumberIsNotDisplayed();
        defectDetailsSteps.checkNotesIsNotDisplayed();
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 - HGV")
    @Test
    public void additionalDetailsForIm8Hgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.clearSearch();

        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 - PSV")
    @Test
    public void additionalDetailsForIm8Psv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.clearSearch();

        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 - TRL")
    @Test
    public void additionalDetailsForIm8Trl() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("341234", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();

        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.checkHorizontalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
    }

    @Title("CVSB-17409 - AC4 - Additional details for IM59 - HGV")
    @Test
    public void additionalDetailsForIm59HGV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
    }

    @Title("CVSB-17409 - AC4 - Additional details for IM59 - PSV")
    @Test
    public void AdditionalDetailsForIm59PSV() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
    }

    @Title("CVSB -17409 - AC4 - Additional details for IM59 - TRL")
    @Test
    public void AdditionalDetailsForIm59Trl() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("341234", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
        defectDetailsSteps.clickBack();
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.checkVerticalIsDisplayed();
        defectDetailsSteps.checkLateralIsDisplayed();
        defectDetailsSteps.checkLongitudinalIsDisplayed();
        defectDetailsSteps.checkAxleNumberIsDisplayed();
        defectDetailsSteps.scroll();
        defectDetailsSteps.checkNotesIsDisplayed();
    }

    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - To verify Test Result as per the deficiency - HGV")
    @Test
    public void verifyTestResultPerDeficiencyForHgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();

        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (i) MAJOR", "5.1 (a) (ii) MAJOR", "5.1 (a) (iii) MAJOR");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("N3");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("1");
        odometerReadingSteps.checkReadingValue("1");
        odometerReadingSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }

    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - To verify Test Result as per the deficiency - PSV")
    @Test
    public void verifyTestResultPerDeficiencyForPsv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();

        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("M3");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12");
        odometerReadingSteps.checkReadingValue("12");
        odometerReadingSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (ii) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.pressDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (iii) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("5.1 (a) (iv) MAJOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();

        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("8.1 (i) DANGEROUS");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (ii) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
    }

    @Title("CVSB-17409 - AC1 - Defect taxonomy updates - To verify Test Result as per the deficiency - TRL")
    @Test
    public void verifyTestResultPerDeficiencyForTrl() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("341234", super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.waitUntilPageIsLoaded();
        testTypeDetailsSteps.selectAddDefect("Annual test");
        defectCategorySteps.waitUntilPageIsLoaded();
        defectCategorySteps.clearSearch();

        defectCategorySteps.searchForDefect("Condition");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.pressDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectVehicleCategory("O1");
        euVehicleCategorySteps.clickSaveOptionButton();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "PASS");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("8.1 (j) (i) MINOR");
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();

        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (a) (ii) * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (a) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (i) MAJOR");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.pressDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.clickReviewAndSubmit();
        testReviewSteps.checkTestStatus("Annual test", "FAIL");
        testReviewSteps.goToTestPage();
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.clickOnDefect("59.3 (b) (ii) DANGEROUS");
        defectDetailsSteps.scroll();
        defectDetailsSteps.pressRemove();
        defectDetailsSteps.pressRemoveInPopUp();
        testTypeDetailsSteps.clickAddDefect();
    }
}