package testtype.CVSB_4952;

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
public class TestSpecialistTestsCar_CVSB_4952 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeSubcategorySteps testTypeSubCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TestReviewSteps testReviewSteps;

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
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - car")
    @Test
    public void testSpecialistTestCar() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificCar("911250");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkCarTestDetails("QW123RT", "P0123010911250");
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal Inspection", "Appeal", "Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal Inspection");
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
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal Inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Normal Inspection");
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();

    }

    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - motorcycle")
    @Test
    public void testSpecialistTestMotorcycle() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("956789");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkMotorcycleTestDetails("ZX345CV", "P0123010956789");
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "MSVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("MSVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Full inspection", "Part inspection", "Appeal");
        testTypeSubCategorySteps.selectFromTestTypeList("Full inspection");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Bodied vehicle");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Bodied vehicle");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Retest");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("MSVA");
        testTypeSubCategorySteps.selectFromTestTypeList("MSVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Unbodied vehicle", "Bodied vehicle");
        testTypeSubCategorySteps.selectFromTestTypeList("Unbodied vehicle");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Bodied vehicle");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Paid", "Free");
        testTypeSubCategorySteps.selectFromTestTypeList("Paid");
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();

    }


    @Title("CVSB-4952 - As an SVSA I want to be able to select/ remove/ abandon a test type so that I can conduct a specialist test - lgv")
    @Test
    public void testSpecialistTestLgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("951264");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkLgvTestDetails("AS234TY", "P0123010951264");
        testSteps.addTestType();
        testTypeCategorySteps.checkTestTypesInListAreSelectable("Specialist test");
        testTypeCategorySteps.selectFromTestTypeList("Specialist test");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("IVA", "Voluntary IVA", "Retest");
        testTypeSubCategorySteps.selectFromTestTypeList("IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection", "Appeal", "Mutual recognition/ end of series & inspection");
        testTypeSubCategorySteps.selectFromTestTypeList("Appeal");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection");
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.goBackToCategory();
        testTypeSubCategorySteps.selectFromTestTypeList("Voluntary IVA");
        testTypeSubCategorySteps.checkTestTypesInListAreSelectable("Normal inspection");
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
        testSteps.checkTestTypeStatus("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("Specialist test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.pressTestTypeAbandonButton();
        selectReasonSteps.checkSpecialistReasonsList();

    }
}
