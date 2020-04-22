package pages;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SelectReasonPage extends BasePage {

    private static final String SELECT_REASON_PAGE_TITLE = "Select reason";
    private static final String SELECT_REASON_BACK_BUTTON = "arrow back Test";
    private static final String SELECT_REASON_TEXT_TIP = "You can select multiple reasons for abandoning this test";
    private static final String REASON_LIST_ELEMENTS_XPATH = "//XCUIElementTypeStaticText[contains(@name,'You can select multiple reasons')]/../following-sibling::XCUIElementTypeButton";
    private static final String NEXT_BUTTON_ID = "Next";

    private static final String REASON_TEXT_1 = "The vehicle was not submitted for test at the appointed time";
    private static final String REASON_TEXT_2 = "The relevant test fee has not been paid";
    private static final String REASON_TIR_TEXT_3 = "The trailer was not accompanied by a suitable drawing motor vehicle";
    private static final String REASON_TIR_TEXT_4 = "There is not permanently fixed to the chassis a serial number (motor vehicle) or the identification mark issued by the Secretary of State (trailer)";
    private static final String REASON_TIR_TEXT_5 = "The vehicle or motor vehicle by which it is accompanied emits substantial amounts of smoke so as to make it unreasonable for the test to be carried out";
    private static final String REASON_TIR_TEXT_6 = "The vehicle or trailer (any part) was in such a dirty or dangerous condition as to make it unreasonable for the test to be carried out";
    private static final String REASON_TIR_TEXT_7 = "The vehicle did not have sufficient fuel and oil to allow the test to be carried out";
    private static final String REASON_TIR_TEXT_8 = "The test could not be completed due to a failure of a part of the vehicle, or trailer and accompanying motor vehicle which made movement impossible";
    private static final String REASON_TIR_TEXT_9 = "The vehicle was presented for test carrying unsuitable material";
    private static final String REASON_TEXT_3 = "There was no means of identifying the vehicle i.e. the vehicle chassis/serial number was missing or did not relate to the vehicle";
    private static final String REASON_TEXT_4 = "The registration document or other evidence of the date of first registration was not presented when requested";
    private static final String REASON_TEXT_5 = "The vehicle was emitting substantial amounts of exhaust smoke so as to make it unreasonable for the test to be carried out";
    private static final String REASON_TEXT_6 = "The vehicle was in such a dirty or dangerous condition as to make it unreasonable for the test to be carried out";
    private static final String REASON_TEXT_7 = "The vehicle did not have sufficient fuel and oil to allow the test to be carried out";
    private static final String REASON_TEXT_8 = "The test could not be completed due to a failure of a part of the vehicle which made movement under its own power impossible";
    private static final String REASON_TEXT_9 = "Current Health and Safety legislation cannot be met in testing the vehicle";
    private static final String REASON_TIR_TEXT_10 = "Current Health and Safety legislation cannot be met in testing the vehicle";
    private static final String REASON_TEXT_10 = "The driver and/or presenter of the vehicle declined either to remain in the vehicle or in its vicinity throughout the examination or to drive it or to operate controls or doors or to remove or refit panels after being requested to do so";
    private static final String REASON_TEXT_11 = "The vehicle exhaust outlet has been modified in such a way as to prevent a metered smoke check being conducted";
    private static final String REASON_TIR_TEXT_11 = "The driver and/or presenter of the vehicle refused to or was unable to comply with the instructions of DVSA staff making it impractical or unsafe to continue the test";
    private static final String REASON_TEXT_12 = "A proper examination cannot be readily carried out as any door, engine cover, hatch or other access device designed to be opened is locked or otherwise cannot be opened";

    private static final String REASON_SPECIALIST_TEXT_1 = "The vehicle/trailer is not eligible to the scheme";
    private static final String REASON_SPECIALIST_TEXT_2 = "The vehicle/trailer was not presented for examination at the appointed time or place";
    private static final String REASON_SPECIALIST_TEXT_3 = "The vehicle (for whatever reason) cannot be driven or the engine run to the extent necessary to complete the examination";
    private static final String REASON_SPECIALIST_TEXT_4 = "The vehicle/trailer was presented at an incorrect test location (see conditions specified on IVA 30)";
    private static final String REASON_SPECIALIST_TEXT_5 = "The vehicle/trailer is in such a dirty or dangerous condition that it is unreasonable for the examination to be carried out";
    private static final String REASON_SPECIALIST_TEXT_6 = "Items on the vehicle/trailer have not been removed or secured as required by the examiner";
    private static final String REASON_SPECIALIST_TEXT_7 = "A door, tailgate, boot lid, engine cover, fuel cap or other device capable of being opened was locked or fixed such that a proper examination could not be carried out";
    private static final String REASON_SPECIALIST_TEXT_8 = "The vehicle/trailer condition is such that a proper examination would involve a danger of injury to any person; or damage to the vehicle or any other property";
    private static final String REASON_SPECIALIST_TEXT_9 = "The identification number is not: permanently fixed to the vehicle/trailer; easy to read and in an accessible position; adequate for the purpose of identifying the vehicle";
    private static final String REASON_SPECIALIST_TEXT_10 = "The driver at the time of the examination did not remain with the vehicle and operate the controls, or did not comply with a reasonable request of the examiner in the course of his duties, or did not remove and refit panels as requested";
    private static final String REASON_SPECIALIST_TEXT_11 = "The vehicle was not presented with the fuel tank(s) full";


    public boolean areAllReasonsDisplayed(Reasons[] reasons) {
        waitUntilPageIsLoaded();
        for (SelectReasonPage.Reasons reason : reasons) {
            if(!isReasonFromListDisplayed(reason))return false;
        }
        return true;
    }

    public boolean areAllReasonsDisplayed(ReasonsSpecialist[] reasons) {
        waitUntilPageIsLoaded();
        for (SelectReasonPage.ReasonsSpecialist reason : reasons) {
            if(!isSpecialistReasonFromListDisplayed(reason))return false;
        }
        return true;
    }

    public enum Reasons {REASON_1, REASON_2, REASON_3, REASON_4, REASON_5, REASON_6, REASON_7, REASON_8, REASON_9, REASON_10, REASON_11, REASON_12 }
    public enum ReasonsTir{REASON_1, REASON_2, REASON_3, REASON_4, REASON_5, REASON_6, REASON_7, REASON_8, REASON_9, REASON_10, REASON_11 }
    public enum ReasonsSpecialist {REASON_SPECIALIST_1, REASON_SPECIALIST_2, REASON_SPECIALIST_3, REASON_SPECIALIST_4, REASON_SPECIALIST_5, REASON_SPECIALIST_6, REASON_SPECIALIST_7, REASON_SPECIALIST_8, REASON_SPECIALIST_9, REASON_SPECIALIST_10, REASON_SPECIALIST_11};

    public boolean isReasonSelected(int reasonNumber) {
        List<String> listOfExpectedReasonTexts = this.findAllReasonsByXpath();
        boolean isSelected = findElementByXpath("//XCUIElementTypeButton[contains(@name, '"+listOfExpectedReasonTexts.get(reasonNumber - 1)+"')]").getAttribute("name").endsWith("checkmark");
        return isSelected;
    }

    public void selectReason(Reasons reason) {
        // Determine the xpath for the "reason for cancellation", and click on it.
        String xPath = "//XCUIElementTypeButton[@name=\"" + getListOfReasonTexts().get(reason.ordinal()) + "\"]";
        findElementByXpath(xPath).click();
    }

    public void selectSpecialistReason(ReasonsSpecialist reason) {
        // Determine the xpath for the "reason for cancellation", and click on it.
        String xPath = "//XCUIElementTypeButton[@name=\"" + getListOfSpecialistReasonTexts().get(reason.ordinal()) + "\"]";
        findElementByXpath(xPath).click();
    }

    public void selectReason(ReasonsTir reason) {
        // Determine the xpath for the "reason for cancellation", and click on it.
        String xPath = "//XCUIElementTypeButton[@name=\"" + getListOfReasonTirTexts().get(reason.ordinal()) + "\"]";
        findElementByXpath(xPath).click();
    }

    public void selectReason(String reason) {
        for(WebElement availableReason:findElementsByXpath(REASON_LIST_ELEMENTS_XPATH)){
            if(availableReason.getAttribute("name").equals(reason)){
                availableReason.click();
                break;
            }
        }
    }

    public void selectReasonTir(String reason) {
        for(WebElement availableReason:findElementsByXpath(REASON_LIST_ELEMENTS_XPATH)){
            if(availableReason.getAttribute("name").equals(reason)){
                availableReason.click();
                break;
            }
        }
    }

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

    public List<String> findAllReasonsByXpath() {
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

    public List<String> getListOfReasonTirTexts() {
        List<String> listOfReasonTexts = new ArrayList<>();
        listOfReasonTexts.add(REASON_TEXT_1);
        listOfReasonTexts.add(REASON_TEXT_2);
        listOfReasonTexts.add(REASON_TIR_TEXT_3);
        listOfReasonTexts.add(REASON_TIR_TEXT_4);
        listOfReasonTexts.add(REASON_TIR_TEXT_5);
        listOfReasonTexts.add(REASON_TIR_TEXT_6);
        listOfReasonTexts.add(REASON_TIR_TEXT_7);
        listOfReasonTexts.add(REASON_TIR_TEXT_8);
        listOfReasonTexts.add(REASON_TIR_TEXT_9);
        listOfReasonTexts.add(REASON_TIR_TEXT_10);
        listOfReasonTexts.add(REASON_TIR_TEXT_11);
        return listOfReasonTexts;
    }

    public List<String> getListOfSpecialistReasonTexts() {
        List<String> listOfReasonTexts = new ArrayList<>();
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_1);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_2);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_3);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_4);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_5);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_6);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_7);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_8);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_9);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_10);
        listOfReasonTexts.add(REASON_SPECIALIST_TEXT_11);
        return listOfReasonTexts;
    }

    public String getReasonTexts(Reasons reason) {
        String text = "";
        switch (reason) {
            case REASON_1:
                text = REASON_TEXT_1;
            break;
            case REASON_2:
                text = REASON_TEXT_2;
            break;
            case REASON_3:
                text = REASON_TEXT_3;
            break;
            case REASON_4:
                text = REASON_TEXT_4;
            break;
            case REASON_5:
                text = REASON_TEXT_5;
            break;
            case REASON_6:
                text = REASON_TEXT_6;
            break;
            case REASON_7:
                text = REASON_TEXT_7;
            break;
            case REASON_8:
                text = REASON_TEXT_8;
            break;
            case REASON_9:
                text = REASON_TEXT_9;
            break;
            case REASON_10:
                text = REASON_TEXT_10;
            break;
            case REASON_11:
                text = REASON_TEXT_11;
            break;
            case REASON_12:
                text = REASON_TEXT_12;
            break;
        }
        return text;
    }

    public String getSpecialistReasonTexts(ReasonsSpecialist reason) {
        String text = "";
        switch (reason) {
            case REASON_SPECIALIST_1:
                text = REASON_SPECIALIST_TEXT_1;
                break;
            case REASON_SPECIALIST_2:
                text = REASON_SPECIALIST_TEXT_2;
                break;
            case REASON_SPECIALIST_3:
                text = REASON_SPECIALIST_TEXT_3;
                break;
            case REASON_SPECIALIST_4:
                text = REASON_SPECIALIST_TEXT_4;
                break;
            case REASON_SPECIALIST_5:
                text = REASON_SPECIALIST_TEXT_5;
                break;
            case REASON_SPECIALIST_6:
                text = REASON_SPECIALIST_TEXT_6;
                break;
            case REASON_SPECIALIST_7:
                text = REASON_SPECIALIST_TEXT_7;
                break;
            case REASON_SPECIALIST_8:
                text = REASON_SPECIALIST_TEXT_8;
                break;
            case REASON_SPECIALIST_9:
                text = REASON_SPECIALIST_TEXT_9;
                break;
            case REASON_SPECIALIST_10:
                text = REASON_SPECIALIST_TEXT_10;
                break;
            case REASON_SPECIALIST_11:
                text = REASON_SPECIALIST_TEXT_11;
                break;
        }
        return text;
    }

    public String getReasonTexts(ReasonsTir reason) {
        String text = "";
        switch (reason) {
            case REASON_1:
                text = REASON_TEXT_1;
                break;
            case REASON_2:
                text = REASON_TEXT_2;
                break;
            case REASON_3:
                text = REASON_TIR_TEXT_3;
                break;
            case REASON_4:
                text = REASON_TIR_TEXT_4;
                break;
            case REASON_5:
                text = REASON_TIR_TEXT_5;
                break;
            case REASON_6:
                text = REASON_TIR_TEXT_6;
                break;
            case REASON_7:
                text = REASON_TIR_TEXT_7;
                break;
            case REASON_8:
                text = REASON_TIR_TEXT_8;
                break;
            case REASON_9:
                text = REASON_TIR_TEXT_9;
                break;
            case REASON_10:
                text = REASON_TIR_TEXT_10;
                break;
            case REASON_11:
                text = REASON_TIR_TEXT_11;
                break;
        }
        return text;
    }

    public boolean isElementFromListDisplayed(String element) {
        return findElementByXpath("//*[@name='" + element + "']").isDisplayed();
    }

    public boolean isReasonFromListDisplayed(Reasons reason) {
        boolean status = false;
        switch (reason) {
            case REASON_1:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_1 + "']").isDisplayed();
                break;
            case REASON_2:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_2 + "']").isDisplayed();
                break;
            case REASON_3:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_3 + "']").isDisplayed();
                break;
                case REASON_4:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_4 + "']").isDisplayed();
                break;
                case REASON_5:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_5 + "']").isDisplayed();
                break;
            case REASON_6:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_6 + "']").isDisplayed();
                break;
            case REASON_7:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_7 + "']").isDisplayed();
                break;
            case REASON_8:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_8 + "']").isDisplayed();
                break;
            case REASON_9:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_9 + "']").isDisplayed();
                break;
            case REASON_10:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_10 + "']").isDisplayed();
                break;
            case REASON_11:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_11 + "']").isDisplayed();
                break;
            case REASON_12:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_12 + "']").isDisplayed();
                break;
        }
        return status;
    }

    public boolean isReasonFromListDisplayed(ReasonsTir reason) {
        boolean status = false;
        switch (reason) {
            case REASON_1:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_1 + "']").isDisplayed();
                break;
            case REASON_2:
                status = findElementByXpath("//*[@name='" + REASON_TEXT_2 + "']").isDisplayed();
                break;
            case REASON_3:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_3 + "']").isDisplayed();
                break;
            case REASON_4:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_4 + "']").isDisplayed();
                break;
            case REASON_5:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_5 + "']").isDisplayed();
                break;
            case REASON_6:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_6 + "']").isDisplayed();
                break;
            case REASON_7:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_7 + "']").isDisplayed();
                break;
            case REASON_8:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_8 + "']").isDisplayed();
                break;
            case REASON_9:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_9 + "']").isDisplayed();
                break;
            case REASON_10:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_10 + "']").isDisplayed();
                break;
            case REASON_11:
                status = findElementByXpath("//*[@name='" + REASON_TIR_TEXT_11 + "']").isDisplayed();
                break;
        }
        return status;
    }

    public boolean isSpecialistReasonFromListDisplayed(ReasonsSpecialist reason) {
        boolean status = false;
        switch (reason) {
            case REASON_SPECIALIST_1:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_1 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_2:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_2 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_3:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_3 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_4:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_4 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_5:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_5 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_6:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_6 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_7:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_7 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_8:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_8 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_9:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_9 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_10:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_10 + "']").isDisplayed();
                break;
            case REASON_SPECIALIST_11:
                status = findElementByXpath("//*[@name='" + REASON_SPECIALIST_TEXT_11 + "']").isDisplayed();
                break;
        }
        return status;
    }

    public void clickOnBackButton() {
        findElementById(SELECT_REASON_BACK_BUTTON).click();
    }

    public void clickOnNextButton() {
        findElementById(NEXT_BUTTON_ID).click();
    }

    public void scrollPageDown() {
        scrollDownTo(500, -800);
    }

    public void scrollPageUp() {
        scrollDownTo(500, 800);
    }


    public boolean isNextButtonDisplayed() {
        WebElement nextButton = null;
        try {
            nextButton = findElementById(NEXT_BUTTON_ID);
        } catch (Exception e) {
        }
        if (nextButton != null) {
            return nextButton.isDisplayed();
        } else
            return false;
    }
}
