package steps.util;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.util.UtilPage;

public class UtilSteps extends ScenarioSteps {
    UtilPage utilPage;

    @Step()
    public void resetAndQuitDriver() {
        utilPage.resetAndQuitDriver();
    }
}
