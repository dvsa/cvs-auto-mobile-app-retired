package defect;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.*;
import steps.composed.TestTypeCategoryComp;

@RunWith(SerenityRunner.class)
public class EditAndUpdateDefectTest {

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
    DefectDetailsSteps defectDetailsSteps;

    @Steps
    AdvisoryDetailsSteps advisoryDetailsSteps;

    @Managed
    public WebDriver webDriver;


    @Title("CVSB-141 / CVSB-666 - AC1 - Edit and update defect from test type details screen")
    @Test
    public void testEditAndUpdateFromTestTypeDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.selectDefect("3.1.b MAJOR");
        defectDetailsSteps.tapAddDefect();
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing","Seat Belts & Supplementary Restraint Systems","Obligatory Seat Belt");
        // TODO find a better method for existing defect selection
        testTypeSteps.tapOnPresentDefect("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        defectDetailsSteps.selectOptionsWithPRSCheckAndTapDone("upper", "nearside", "2", "2");
        testTypeSteps.checkAdditionalDetailsWithPRSPresent("Public Service Vehicle Annual Testing", "3.1.b ", "MAJOR", "3. Seat Belts & Supplementary Restraint Systems", "1. Obligatory Seat Belt:", "(b). of an incorrect type.", "FAIL");
    }

    @Title("CVSB-141 / CVSB-667 - AC2 - Edit and update advisory from advisory details screen")
    @Test
    public void testEditAndUpdateFromAdvisoryDetails() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("Public Service Vehicle Annual Testing");
        testTypeSteps.selectAddDefect("Public Service Vehicle Annual Testing");
        recordDefectSteps.selectDefectFromList("Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.selectDefectFromList("Obligatory Seat Belt");
        defectItemLevelThreeSteps.tapAddAnAdvisoryNote();
        advisoryDetailsSteps.waitUntilPageIsLoaded();
        advisoryDetailsSteps.addCustomNoteAndTapAddNote("test note 1234");
        // TODO find a better way for advisory/defect verification
        testTypeSteps.checkDefectsArePresentForTest("Public Service Vehicle Annual Testing","Seat Belts & Supplementary Restraint Systems","Obligatory Seat Belt");
        // TODO find a better way for existing advisory selection
        testTypeSteps.tapOnPresentDefect("Public Service Vehicle Annual Testing", "Seat Belts & Supplementary Restraint Systems", "Obligatory Seat Belt");
        advisoryDetailsSteps.checkExistingNote("test note 1234");
        advisoryDetailsSteps.addRandomNoteInputAndTapDone();
    }
}
