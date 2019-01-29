package util;

import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class BaseTestClass {

    @Managed()
    public WebDriver webDriver;

}
