package pages;

import net.thucydides.core.pages.PageObject;

public class MainPage extends PageObject {

//    @iOSFindBy(accessibility = "Accept")
//    private MobileElement acceptButton;

    public void click() {
        getDriver().getPageSource();
    }
}
