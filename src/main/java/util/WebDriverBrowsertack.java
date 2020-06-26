package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;

public class WebDriverBrowsertack {


    static protected WebDriver driver;

    public static void setup() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.video", "false");
        caps.setCapability("browserstack.selenium_version", "3.5.2");


        try {
            driver = new RemoteWebDriver(new URL("http://" + TypeLoader.getBsUsername() + ":" + TypeLoader.getBsPass() + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static String getToken() {
        System.out.println("\n ...getting token...");
        WebDriverBrowsertack.setup();

        driver.get(TypeLoader.getMicrosoftonlineUrl());
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//div[@class='placeholderContainer']/*[1]"));
        String username = BaseUtils.getUserName();
        element.sendKeys(username);


        WebElement element2 = driver.findElement(By.xpath("//div[@class='inline-block'][2]"));
        element2.click();

        FluentWait wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Enter password')]")),
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Enter password')]"))
        ));

        WebElement element3 = driver.findElement(By.xpath("//div[@class='placeholderContainer']/*[1]"));
        element3.sendKeys(TypeLoader.getAppPassword());


        WebElement element4 = driver.findElement(By.xpath("//div[@class='inline-block'][1]"));
        element4.click();

        String token = driver.getCurrentUrl().split("id_token=")[1].split("&session_state=")[0];
        driver.quit();
        return token;
    }
}
