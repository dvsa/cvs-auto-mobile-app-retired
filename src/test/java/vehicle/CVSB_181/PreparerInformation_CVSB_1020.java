package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1020 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Ignore("This is not a valid test case anymore due to CVSB-438")
    @Title("CVSB_181 - AC6 No results returned for preparer information")
    public void noResultsReturnedForPreparerInformationSearch() {
        preparerComp.goToSelectPreparer(super.username);
        selectPreparerSteps.searchForInvalidPreparerId("test", "test", "test");
        selectPreparerSteps.checkPopUPOptionsArePresent();
    }
}