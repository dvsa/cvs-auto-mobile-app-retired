package vehicle.CVSB_3846;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import utils.BaseTestClass;

@RunWith(SerenityRunner.class)
public class TestAddPreparerForSecondVehicle extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    PreparerSteps preparerSteps;

    @Steps
    TrailerDetailsSteps trailerDetailsSteps;

    @Steps
    IdentifyTrailerSteps identifyTrailerSteps;

    @Title("CVSB-5102 - AC1 - Pre-populating Preparer ID from the first vehicle submission (no Preparer ID added)")
    @Test
    public void testPreparerForTrailerToHgvNotPrePopulated() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.checkPreparerFieldIsNotPrePopulated();
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
    }

    @Title("CVSB-5099 - AC1 - Pre-populating Preparer ID from the first vehicle submission (Preparer ID added)")
    @WithTag("Smoke_2")
    @Test
    public void testPreparerForTrailerToHgvPrePopulated() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.searchForPreparerId("AK 44 34");
        preparerSteps.preparerIsFound("AK4434");
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.checkPreparerFieldIsPrePopulatedWith("AK4434");
        preparerSteps.startTest();
        preparerSteps.confirmInPopUp();
    }

    @Title("CVSB-5104 - AC2 - Removing the pre populated field and entering a separate Preparer ID")
    @Test
    public void testPreparerForTrailerToHgvReplacePrePopulated() {
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("230123",super.username);
        preparerSteps.searchForPreparerId("AK 44 34");
        preparerSteps.preparerIsFound("AK4434");
        preparerSteps.confirmInPopUp();
        testSteps.checkHgvTestDetails("CT70VRL", "P012301230123");
        testSteps.checkAddATrailerButtonVisibility();
        testSteps.clickAddATrailerButton();
        identifyTrailerSteps.searchForTrailer("768594");
        trailerDetailsSteps.selectConfirmButtonTopRight();
        trailerDetailsSteps.selectConfirmFromPopUp();
        preparerSteps.checkPageTitleIsDisplayed();
        preparerSteps.checkPreparerFieldIsPrePopulatedWith("AK4434");
        preparerSteps.clearPreparerIdInputField();
        preparerSteps.searchForPreparerId("BL 55 45");
        preparerSteps.preparerIsFound("BL5545");
        preparerSteps.confirmInPopUp();
    }
}

