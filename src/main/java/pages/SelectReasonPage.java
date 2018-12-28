package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectReasonPage extends BasePage {

    private static final String SELECT_REASON_PAGE_TITLE = "Select reason";
    private static final String SELECT_REASON_BACK_BUTTON = "arrow back Test";
    private static final String SELECT_REASON_TEXT_TIP = "You can select multiple reasons for abandoning this test";
    private static final String REASON_LIST_ELEMENTS_XPATH = "//XCUIElementTypeSwitch";

    private static final String REASON_TEXT_1 = "The vehicle was not submitted for test at the appointed time";
    private static final String REASON_TEXT_2 = "The relevant test fee has not been paid";
    private static final String REASON_TEXT_3 = "The was no means of identifying the vehicle i.e. the vehicle chassis/serial number was missing or did not relate to the vehicle";
    private static final String REASON_TEXT_4 = "The registration document or other evidence of the date of first registration was not presented when requested";
    private static final String REASON_TEXT_5 = "The vehicle was emitting substantial amounts of exhaust smoke so as to make it unreasonable for the test to be carried out";
    private static final String REASON_TEXT_6 = "The vehicle was in such a dirty or dangerous condition as to make it unreasonable for the test to be carried out";
    private static final String REASON_TEXT_7 = "The vehicle did not have sufficient fuel and oil to allow the test to be carried out";
    private static final String REASON_TEXT_8 = "The test could not be completed due to a failure of a part of the vehicle which made movement under its own power impossible";
    private static final String REASON_TEXT_9 = "Current Health and Safety legislation cannot be met in testing the vehicle";
    private static final String REASON_TEXT_10 = "The driver and/or presenter of the vehicle declined either to remain in the vehicle or in its vicinity throughout the examination or to drive it or to operate controls or doors or to remove or refit panels after being requested to do so";
    private static final String REASON_TEXT_11 = "The vehicle exhaust outlet has been modified in such a way as to prevent a metered smoke check being conducted";
    private static final String REASON_TEXT_12 = "A proper examination cannot be readily carried out as any door, engine cover, hatch or other access device designed to be opened is locked or otherwise cannot be opened";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(SELECT_REASON_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        boolean status = false;
        if(findElementById(SELECT_REASON_PAGE_TITLE).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean isTextTipDisplayed() {
        boolean status = false;
        if(findElementById(SELECT_REASON_TEXT_TIP).isDisplayed()) {
            status = true;
        }
        return status;
    }

    public List<String> findAllValuesByXpath() {
        List<WebElement> webElementList = findElementsByXpath(REASON_LIST_ELEMENTS_XPATH);
        List<String> listOfData = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            listOfData.add(webElement.getAttribute("name"));
        }

        return listOfData;
    }

    public List<String> getListOfReasonTexts() {
        List<String> listOfReasonTexts = new ArrayList<>();
        listOfReasonTexts.add(REASON_TEXT_1);
        listOfReasonTexts.add(REASON_TEXT_2);
        listOfReasonTexts.add(REASON_TEXT_3);
        listOfReasonTexts.add(REASON_TEXT_4);
        listOfReasonTexts.add(REASON_TEXT_5);
        listOfReasonTexts.add(REASON_TEXT_6);
        listOfReasonTexts.add(REASON_TEXT_7);
        listOfReasonTexts.add(REASON_TEXT_8);
        listOfReasonTexts.add(REASON_TEXT_9);
        listOfReasonTexts.add(REASON_TEXT_10);
        listOfReasonTexts.add(REASON_TEXT_11);
        listOfReasonTexts.add(REASON_TEXT_12);
        return listOfReasonTexts;
    }

    public boolean elementFromListIsDisplayed(String element) {
        return findElementByXpath("//*[@name='" + element + "']").isDisplayed();
    }

    public void clickOnBackButton() {
        findElementById(SELECT_REASON_BACK_BUTTON).click();
    }

    public void scrollPageDown() {
        scrollDownTo(500, -800);
    }


}
