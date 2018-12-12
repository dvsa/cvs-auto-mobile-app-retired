import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.MainSteps;


@RunWith(SerenityRunner.class)
public class TestSample {

    @Steps
    MainSteps mainSteps;

    @Managed
    public WebDriver webDriver;


    @Test
    public void firstTest(){
        mainSteps.open();
    }
}
