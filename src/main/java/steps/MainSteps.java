package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.MainPage;

public class MainSteps extends ScenarioSteps {
    MainPage mainPage;

    @Step
    public void open(){
        mainPage.click();
    }
}
