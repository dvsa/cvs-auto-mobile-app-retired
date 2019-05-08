package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectPreparerPage extends BasePage {

    private static final String SELECT_PREPARER_PAGE_TITLE = "Select preparer";
    private static final String CONFIRM_BUTTON_ID = "Confirm";
    private static final String CANCEL_BUTTON_ID = "Cancel";
    private static final String CANCEL_BUTTON_POP_UP_XPATH_1 = "(//XCUIElementTypeButton[@name='Cancel'])";
    private static final String CANCEL_BUTTON_POP_UP_XPATH_2 = "(//XCUIElementTypeButton[@name='Cancel'])[2]";
    private static final String PAGE_TITLE_ID = "Select preparer";
    private static final String NO_PREPARER_ID_OPTION = "No preparer ID given";
    private static final String VEHICLE_DETAILS_BACK = "arrow back Vehicle details";
    private static final String SEARCH_PREPARER_ID_BAR = "//XCUIElementTypeSearchField";
    private static final String NO_PREPARER_FOUND = "No results found";
    private static final String CONTINUE_WITHOUT_PREPARER = "Continue without preparer ID";
    private static final String WARNING_MESSAGE_PREPARER = "You will not be able to add a preparer for this vehicle later.";

    @Deprecated
    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_PREPARER_PAGE_TITLE);
    }

    @Deprecated
    public int getYPositionForPreparer(String id, String name) {
        return getPreparer(id, name).getLocation().getY();
    }

    @Deprecated
    public WebElement getPreparer(String id, String name) {
        return findElementById(id + " " + name);
    }

    @Deprecated
    public void selectPreparer(String id, String name) {
        getPreparer(id, name).click();
    }

    @Deprecated
    public void confirm() {
        findElementById(CONFIRM_BUTTON_ID).click();
    }

    @Deprecated
    public void cancel() {
        findElementById(CANCEL_BUTTON_ID).click();
    }

    @Deprecated
    public void clickWithoutPreparerIdLink() {
        findElementById(CONTINUE_WITHOUT_PREPARER).click();
    }

    @Deprecated
    public void clickBackButton() {
        findElementById(VEHICLE_DETAILS_BACK).click();
    }

    @Deprecated
    public void clickSearchBar() {
        findElementByXpath(SEARCH_PREPARER_ID_BAR).click();
    }

    @Deprecated
    public void swipeDownPreparerPage() {
        scrollDownTo(500, -500);
    }

    @Deprecated
    public void searchForPreparerId(String preparerId) {
        WebElement searchBar = findElementByXpath(SEARCH_PREPARER_ID_BAR);
        searchBar.clear();
        searchBar.sendKeys(preparerId);
    }

    @Deprecated
    public List<String> retrievePreparerIdList() {
        List<WebElement> elements = findElementsByXpath("//XCUIElementTypeButton");
        List<String> idList = new ArrayList<>();
        for (WebElement el : elements) {
            idList.add(el.getAttribute("name"));
        }
        return idList;
    }

    @Deprecated
    public void clickNoPreparerIdOption() {
        findElementById(NO_PREPARER_ID_OPTION).click();
    }

    @Deprecated
    public boolean withoutPreparerIdLinkIsDisplayed() {
        return findElementById(CONTINUE_WITHOUT_PREPARER).isDisplayed();
    }

    @Deprecated
    public boolean isTitleDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    @Deprecated
    public boolean isNoResultsFoundDisplayed() {
       return findElementById(NO_PREPARER_FOUND).isDisplayed();
    }

    @Deprecated
    public boolean isWarningForMissingPreparerDisplayed() {
       return findElementById(WARNING_MESSAGE_PREPARER).isDisplayed();
    }

    @Deprecated
    public boolean isConfirmOptionDisplayed() {
        return findElementById(CONFIRM_BUTTON_ID).isDisplayed();
    }

    @Deprecated
    public boolean isCancelOptionDisplayed() {
        return findElementByXpath(CANCEL_BUTTON_POP_UP_XPATH_1).isDisplayed();
    }

    @Deprecated
    public boolean isCancelOptionDisplayedAfterNoPreparerIsSelected() {
        return findElementByXpath(CANCEL_BUTTON_POP_UP_XPATH_1).isDisplayed();
    }

    @Deprecated
    public boolean isSearchBarDisplayed() {
        return findElementByXpath(SEARCH_PREPARER_ID_BAR).isDisplayed();
    }

    @Deprecated
    public void clickCancelInPopUp() {
        findElementByXpath(CANCEL_BUTTON_POP_UP_XPATH_2).click();
    }
}
