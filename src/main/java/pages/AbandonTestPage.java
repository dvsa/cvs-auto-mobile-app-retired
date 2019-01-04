package pages;


import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AbandonTestPage extends BasePage {

    private static final String DONE_BUTTON_ID = "Done";
    private static final String BACK_BUTTON_ID = "arrow back Back";
    private static final String PAGE_TITLE_ID = "Abandon test";
    private static final String REASON_LIST_TITLE_ID = "REASON(S) FOR ABANDONING THIS TEST";
    private static final String COMMENT_TITLE_ID = "ADDITIONAL COMMENTS (OPTIONAL)";
    private static final String ADD_COMMENTS_FIELD_XPATH = "//*[@type='XCUIElementTypeTextView']";
    private static final String LIST_TEXT_ELEMENTS_XPATH = "//XCUIElementTypeStaticText";


    public void clickOnDone() {
        waitUntilPageIsLoaded();
        findElementById(DONE_BUTTON_ID).click();
    }

    public void clickOnBack() {
        waitUntilPageIsLoaded();
        findElementById(BACK_BUTTON_ID).click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(PAGE_TITLE_ID);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(PAGE_TITLE_ID).isDisplayed();
    }

    public boolean isReasonsListTitleDisplayed() {
        return findElementById(REASON_LIST_TITLE_ID).isDisplayed();
    }

    public boolean isAdditionalCommentsTitleDisplayed() {
        return findElementById(COMMENT_TITLE_ID).isDisplayed();
    }

    public void scrollPageDown() {
        scrollDownTo(500, -800);
    }

    public void scrollPageUp() {
        scrollDownTo(500, 800);
    }

    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(LIST_TEXT_ELEMENTS_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }

        return listOfData;
    }

    public boolean isCommentSectionDisplayed() {
        WebElement commentField = null;
        try {
            commentField = findElementByXpath(ADD_COMMENTS_FIELD_XPATH);
        } catch (Exception e) {
        }
        if (commentField != null) {
            return commentField.isDisplayed();
        } else
            return false;
    }

    public void clickOnCommentsTextField() {
        findElementByXpath(ADD_COMMENTS_FIELD_XPATH).click();
    }

    public void addComment(String comment) {
        findElementByXpath(ADD_COMMENTS_FIELD_XPATH).sendKeys(comment);
    }

    public void clickOutsideOfTextField() {
        findElementById(COMMENT_TITLE_ID).click();
        findElementById(COMMENT_TITLE_ID).click();
    }

    public String getComment() {
        return findElementByXpath(ADD_COMMENTS_FIELD_XPATH).getAttribute("value");
    }

}
