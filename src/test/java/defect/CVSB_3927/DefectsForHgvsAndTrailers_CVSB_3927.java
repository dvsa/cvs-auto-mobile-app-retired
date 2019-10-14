package defect.CVSB_3927;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;


@RunWith(SerenityRunner.class)
public class DefectsForHgvsAndTrailers_CVSB_3927 extends BaseTestClass {

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
    TestTypeCategorySteps testTypeCategorySteps;

    @WithTagValuesOf({"Smoke_1", "Smoke_2"})
    @Title("CVSB-3927 - AC2 - Viewing the correct additional detail fields for HGV & Trailer")
    @Test
    public void addsDefectsToHgv() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("First test");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("5");
        defectCategorySteps.selectDefectFromList("5. Exhaust Emissions");
        defectItemSteps.selectDefectFromList("2. Compression Ignition Engines Statutory Visual Test:");
        defectDescriptionSteps.selectDefect("5.2 (a) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("15");
        defectCategorySteps.selectDefectFromList("15. Cab Security");
        defectItemSteps.selectDefectFromList("1. A Cab:");
        defectDescriptionSteps.selectDefect("15.1 (a) (i) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("38");
        defectCategorySteps.selectDefectFromList("38. Service Brake Operation");
        defectItemSteps.selectDefectFromList("7. On vehicles and trailers both fitted with ISO 7638 (ABS/EBS) lead sockets");
        defectDescriptionSteps.selectDefect("38.7 MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("74");
        defectCategorySteps.selectDefectFromList("74. Other Dangerous Defects");
        defectItemSteps.selectDefectFromList("1. A defect not described elsewhere in the manual such that:");
        defectDescriptionSteps.selectDefect("74.1 * DANGEROUS");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
    }

    @Title("CVSB-3927 - AC2 - Viewing the correct additional detail fields for HGV & Trailer")
    @Test
    public void addsDefectsToTrl() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificTrailer("768594");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("First test");
        testSteps.checkTestTypeStatus("First test", TestPage.TestTypeStatuses.EDIT);
        testSteps.selectTestType("First test", TestPage.TestTypeStatuses.EDIT);
        testTypeDetailsSteps.checkTestTypeName("First test");
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("12");
        defectCategorySteps.selectDefectFromList("12. Trailer Parking and Emergency Brakes and Air Line Connections");
        defectItemSteps.selectDefectFromList("1. Trailer parking brake:");
        defectDescriptionSteps.selectDefect("12.1 (a) DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("13");
        defectCategorySteps.selectDefectFromList("13. Trailer Landing Legs");
        defectItemSteps.selectDefectFromList("1. A landing leg or any component part");
        defectDescriptionSteps.selectDefect("13.1 * DANGEROUS");
        defectDetailsSteps.setProhibitionIssued();
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.clickAddDefect();
        defectCategorySteps.searchForDefect("38");
        defectCategorySteps.selectDefectFromList("38. Service Brake Operation");
        defectItemSteps.selectDefectFromList("6. Vehicles and Trailers fitted with ABS or ABS/EBS or ESC:");
        defectDescriptionSteps.selectDefect("38.6 (d) MAJOR");
        defectDetailsSteps.tapDone();
        testTypeDetailsSteps.pressSave();
        testSteps.checkTrailerTestDetails("0285678", "T12768594");
    }
}
