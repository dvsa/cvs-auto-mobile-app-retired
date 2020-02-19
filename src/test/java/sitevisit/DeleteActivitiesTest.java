package sitevisit;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DeleteActivitiesTest extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @WithTag("In_Test")
    @Title("CVSB-12181 - Delete activities from Dynamo")
    @Test
    public void testChangesSingularVehicleTests() {
        //add hgv
        testTypeCategoryComp.goToTestPageBySelectingASpecificVehicle("P012301230123");
    }
}
