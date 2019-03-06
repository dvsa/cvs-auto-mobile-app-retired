package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LoginPage;

public class LoginSteps extends ScenarioSteps {

    LoginPage loginPage;

    @Step
    public void logIn(String user, String pass) {
        loginPage.waitUsernamePageToLoad();
        loginPage.insertUserName(user);
        loginPage.clickNext();
        loginPage.waitPasswordPageToLoad();
        loginPage.insertPassword(pass);
        loginPage.clickSignIn();
    }
}
