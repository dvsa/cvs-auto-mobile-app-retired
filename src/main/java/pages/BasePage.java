package pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage extends PageObject {


    protected WebElement findElementById(String id) {
        return getDriver().findElement(By.id(id));
    }

    protected WebElement findElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }

    protected WebElement waitUntilPageIsLoadedById(String id) {
        return waitUntiPageIsLoadedByElement(By.id(id));
    }


    protected void waitUntillNumberOfElementsToBe(By locator, int elementNumber) {
        FluentWait wait = globalFluentWait();
        wait.until(ExpectedConditions.numberOfElementsToBe(locator, elementNumber));
    }


    private WebElement waitUntiPageIsLoadedByElement(By locator) {


        FluentWait wait = globalFluentWait();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));


        return getDriver().findElement(locator);

    }


    private FluentWait globalFluentWait() {
        FluentWait wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        return wait;
    }


}
