package sitevisit;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import steps.composed.TestTypeCategoryComp;
import steps.util.UtilSteps;
import utils.BaseTestClass;

@Ignore
@RunWith(SerenityRunner.class)
public class DeleteActivitiesTest extends BaseTestClass {

    @Steps
    UtilSteps utilSteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Ignore("this is just a test to verify the deletion")
    @Title("CVSB-12181 - Delete activities from Dynamo")
    public void testChangesSingularVehicleTests() {
        utilSteps.showBrowserstackUrl(super.sessionDetails.getBsSessionUrl());
        //add hgv
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P012301230123",super.username);
    }
}
