package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void logIn() {
        loginPage.waitUsernamePageToLoad();
        loginPage.insertUserName("");
        loginPage.clickNext();
        loginPage.waitPasswordPageToLoad();
        loginPage.insertPassword("");
        loginPage.clickSignIn();
    }
}
