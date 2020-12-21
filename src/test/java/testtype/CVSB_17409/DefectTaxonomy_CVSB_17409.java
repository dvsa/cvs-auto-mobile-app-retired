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


    @Title("CVSB-17409 - AC1 - Defect taxonomy updates HGV")
    @Test
    public void defectTaxonomyUpdatesHGV() {
        // for HGV
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
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (iv) MAJOR");
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("8.1 (i) DANGEROUS", "8.1 (j) (i) MINOR", "8.1 (j) (ii) MAJOR");
    }


    @Title("CVSB-17409 - AC1 - Defect taxonomy updates PSV")
    @Test
    public void defectTaxonomyUpdatesPSV() {
        // for PSV
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
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("5.1 (a) (iv) MAJOR");
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Condition of Tyres");
        defectCategorySteps.selectDefectFromList("Condition of Tyres");
        defectItemSteps.selectDefectFromList("1. A tyre:");
        testSteps.scrollDown();
        defectDescriptionSteps.checkItemsArePresent("8.1 (i) DANGEROUS", "8.1 (j) (i) MINOR", "8.1 (j) (ii) MAJOR");
    }


    @Title("CVSB-17409 - AC1 - Defect taxonomy updates TRL")
    @Test
    public void defectTaxonomyUpdatesTRL() {
        // for TRL
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
        defectDescriptionSteps.clickBack();
        defectItemSteps.clickBack();
        defectCategorySteps.clearSearch();
        defectCategorySteps.searchForDefect("Brake Systems");
        defectCategorySteps.selectDefectFromList("Brake Systems and Components");
        defectItemSteps.selectDefectFromList("3. Brake drums, back plates & shoes, discs, callipers & pads including friction material with:");
        defectDescriptionSteps.checkItemsArePresent("59.3 (a) (i) MAJOR", "59.3 (a) (ii) * DANGEROUS", "59.3 (b) (i) MAJOR", "59.3 (b) (ii) DANGEROUS");
    }

    @Title("CVSB-17409 - AC2 - Additional Details for IM5 HGV")
    @Test
    public void additionalDetailsForIm5Hgv() {
        // for HGV
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
        defectDescriptionSteps.selectDefect("5.1 (a) (i) MAJOR");
        defectDetailsSteps.checkItemsArePresent("After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used before 1 July 2008: The level specified on the manufacturer’s plate or 2.5m-1 for non-turbocharged engines, where the plate value is not available.\" name=\"After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used before 1 July 2008: The level specified on the manufacturer’s plate or 2.5m-1 for non-turbocharged engines, where the plate value is not available.\" label=\"After a total of six accelerations have been completed, the average smoke opacity recorded for accelerations 4, 5 and 6 is more than: For vehicles first used before 1 July 2008: The level specified on the manufacturer’s plate or 2.5m-1 for non-turbocharged engines, where the plate value is not available.");
    }

    @Title("CVSB-17409 - AC2 - Additional Details for IM5 TRL")
    @Test
    public void additionalDetailsForIm5Trl() {
        // for TRL
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
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("1. Compression Ignition Engines Statutory Smoke Meter Test:");
        defectDescriptionSteps.selectDefect("5.1 (a) (i) MAJOR");
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 HGV")
    @Test
    public void additionalDetailsForIm8Hgv() {
        // for HGV
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
        defectDescriptionSteps.selectDefect("8.1 (j) (i) MINOR");
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 TRL")
    @Test
    public void additionalDetailsForIm8Trl() {
        // for TRL
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
        defectDescriptionSteps.selectDefect("8.1 (j) (i) MINOR");
//        defectDetailsSteps
    }

    @Title("CVSB-17409 - AC3 - Additional Details for IM8 PSV")
    @Test
    public void additionalDetailsForIm8Psv() {
        // for PSV
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("012345", super.username);
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
        defectDescriptionSteps.selectDefect("8.1 (j) (i) MINOR");

    }


}
