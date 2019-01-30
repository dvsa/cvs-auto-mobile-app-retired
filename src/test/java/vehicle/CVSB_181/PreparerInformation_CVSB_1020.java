package vehicle.CVSB_181;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class PreparerInformation_CVSB_1020 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    SelectPreparerSteps selectPreparerSteps;

    @Title("CVSB_181 - AC6 No results returned for preparer information")
    @Test
    public void noResultsReturnedForPreparerInformationSearch() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.searchForInvalidPreparerId("test", "test", "test");
        selectPreparerSteps.checkPopUPOptionsArePresent();
    }
}