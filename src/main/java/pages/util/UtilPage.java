package pages.util;

import pages.BasePage;
import util.TestHandler;

public class UtilPage extends BasePage {

    public void resetAndQuitDriver() {
        TestHandler.getInitializedStatus().set(false);
        TestHandler.currentCacheDisabled().set(false);
        TestHandler.testTypeEnabledCached().set(false);

        getDriver().quit();
    }
}
