package defect;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class AddDefectTest {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSteps testTypeSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    RecordDefectSteps recordDefectSteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectItemLevelThreeSteps defectItemLevelThreeSteps;

    @Steps
    AdvisoryDetailsSteps advisoryDetailsSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;


    @Managed
    public WebDriver webDriver;


    @Title("CVSB-139 / CVSB-668 - AC1 - Add a defect from test type details screen")
    @Test
    public void testTypeAddDefectOption() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.checkTestTypeResultAndVehicleDetailsOption("Public Service Vehicle Annual Testing", "PASS");
        testTypeSteps.checkAddDefectIsPresent();

    }

    @Title("CVSB-139 / CVSB-669 - AC2 - Add a defect from test type details screen")
    @Test
    public void addADefectFromTestType() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");


    }

    @Title("CVSB-139 / CVSB-670 - AC3 - Add advisory defect screen")
    @Test
    public void addAdvisoryDefectScreen() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.waitUntilPageIsLoaded();

    }

    @Title("CVSB-139 / CVSB-671 - AC4 - Add advisory defect")
    @Test
    public void addAdvisoryDefect() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.addNoteInputTapAddNote();
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing","Seat Belts & Supplementary Restraint Systems","Obligatory Seat Belt");

    }

    @Title("CVSB-139 / CVSB-672 - AC5 - Defect details screen")
    @Test
    public void defectDetailsScreen() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.checkAllElementsArePresent("3.1.b","MAJOR","Obligatory Seat Belt:","of an incorrect type.");

    }

    @Title("CVSB-139 / CVSB-673 - AC5 - Add a defect from the defect details screen")
    @Test
    public void defectAddDefectFromDefectDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.selectOptionsAndTapAddDefect("upper", "nearside", "2", "2");
        testTypeSteps.checkAdditionalDetails("Public Service Vehicle Annual Testing", "3.1.b ", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b). of an incorrect type.", "FAIL");

    }

    @Title("CVSB-139 / CVSB-674 - AC6 - Add PRS ")
    @Test
    public void defectAddDefectWithPRS() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.selectOptionsWithPRSCheckAndTapAddDefect("upper", "nearside", "2", "2");
        testTypeSteps.checkAdditionalDetailsWithPRSPresent("Public Service Vehicle Annual Testing", "3.1.b ", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b). of an incorrect type.", "FAIL");

    }


    @Title("CVSB-139 / CVSB-675 - AC7 - Add notes ")
    @Test
    public void defectAddDefectWithAddNotes() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.sendNotesWithContentCheckAndSize();
    }


}
