package testtype.CVSB_4952;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestSpecialistTestsCar_CVSB_4952 extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Ignore("Untill CVSB-18344 is fixed")
    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - car")
    public void testSpecialistTestCar() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificCar("911250",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkCarTestDetails("QW123RT", "P0123010911250");
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Appeal", "Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Basic inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Basic inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection", "Mutual recognition/ end of series");
        testTypeSubCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();
    }

    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - motorcycle")
    @Test
    public void testSpecialistTestMotorcycle() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkMotorcycleTestDetails("ZX345CV", "P0123010956789");
        testSteps.addTestType();
        testTypeCategorySteps.waitUntilPageIsLoaded();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "MSVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeSubCategorySteps.selectFromTestTypeList("MSVA");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("MSVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Full inspection", "Part inspection", "Appeal");
        testTypeSubCategorySteps.selectFromTestTypeList("Full inspection");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Full inspection");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Moped vehicle");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("MSVA");
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Appeal");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Moped vehicle");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Specialist test");
        testTypeSubCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Retest");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("MSVA");
        testTypeSubCategorySteps.selectFromTestTypeList("MSVA");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("MSVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Moped vehicle");
        testTypeSubCategorySteps.selectFromTestTypeList("Unbodied vehicle");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Unbodied vehicle");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("MSVA");
        testTypeSubCategorySteps.selectFromTestTypeList("Moped vehicle");
        testTypeSubCategorySteps.waitForPageToLoadBySubcategory("Moped vehicle");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();
    }

    @Ignore("Untill CVSB-18344 is fixed")
    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - lgv")
    public void testSpecialistTestLgv() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLgvTestDetails("AS234TY", "P0123010951264");
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Appeal", "Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Basic inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Basic inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection", "Mutual recognition/ end of series");
        testTypeSubCategorySteps.selectFromTestTypeList("Normal inspection");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.selectFromTestTypeList("Normal inspection");
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();
    }
}
