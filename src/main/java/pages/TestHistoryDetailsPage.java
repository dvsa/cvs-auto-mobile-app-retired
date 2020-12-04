package pages;

import exceptions.AutomationException;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestHistoryDetailsPage extends BasePage {
    private static final String TEST_HISTORY_DETAILS_PAGE_TITLE = "Test history details";
    private static final String BACK_BUTTON_XPATH = "//XCUIElementTypeButton[contains(@name, 'arrow back')]";
    private static final String PAGE_ALL_TEXT_CLASS_NAME = "XCUIElementTypeStaticText";
    private static final String TEST_DATE_XPATH = "//XCUIElementTypeStaticText[contains(@name, 'Test date')]";
    private static final String TEST_TIME_XPATH = "//XCUIElementTypeStaticText[contains(@name, 'Test time')]";
    private static final String TEST_EXPIRY_XPATH = "//XCUIElementTypeStaticText[contains(@name, 'Test expiry')]";


    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_HISTORY_DETAILS_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        try {
            return findElementById(TEST_HISTORY_DETAILS_PAGE_TITLE).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public void clickBackButton() {
        logger.info("Clicking the Back button...");
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public List<String> getDataSetBetweenTitles(String dataSetStartText, String dataSetEndText) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        List<String> listOfData = new ArrayList<>();
        int startIndex = -1;
        int endIndex = -1;
        boolean addingData = false;
        String attribute;

        for (int i = 0; i < webElementList.size(); i++) {
            attribute = webElementList.get(i).getAttribute("name");
            logger.info("Attribute: " + attribute);
            if (attribute.equalsIgnoreCase(dataSetStartText)) {
                startIndex = i;
                addingData = true;
            }
            if (attribute.equalsIgnoreCase(dataSetEndText)) {
                endIndex = i;
                addingData = false;
                break;
            }

            if (addingData) {
                listOfData.add(attribute);
            }
        }

        if (startIndex == -1) {
            throw new AutomationException("Start field not present in page: " + dataSetStartText);
        }
        if (endIndex == -1) {
            throw new AutomationException("End field not present in page: " + dataSetEndText);
        }

        return listOfData;
    }

    public boolean checkElementIsPresent(String element) {
        try {
            return findElementById(element).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean checkTestDateElementIsPresent() {
        try {
            return findElementByXpath(TEST_DATE_XPATH).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean checkTestExpiryElementIsPresent() {
        try {
            return findElementByXpath(TEST_EXPIRY_XPATH).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean checkTestTimeElementIsPresent() {
        try {
            return findElementByXpath(TEST_TIME_XPATH).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public boolean checkIsValidDateFormat() {
        String date = findElementByXpath("//XCUIElementTypeOther[@name=\"Ionic App\"]/XCUIElementTypeOther[6]/XCUIElementTypeStaticText").getAttribute("name");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public boolean checkIsValidTimeFormat() {
        String time = findElementByXpath("//XCUIElementTypeOther[@name=\"Ionic App\"]/XCUIElementTypeOther[8]/XCUIElementTypeStaticText").getAttribute("name");
        String[] arrayTime = time.split("-");
        String startTime = arrayTime[0].trim();
        String endTime = arrayTime[1].trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(startTime);
            dateFormat.parse(endTime);
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public boolean checkAllElementsHaveStatusAndExpiryDate() {
        if (checkAllTestsHaveStatus() && checkAllTestsHaveDates()) return true;
        else return false;
    }

    public boolean checkAllTestsHaveStatus() {
        List<WebElement> elementsDisplayed = findElementsByXpath("//XCUIElementTypeButton");

        List<String> testElementsDisplayed = new ArrayList<>();
        for (WebElement we : elementsDisplayed) {
            testElementsDisplayed.add(we.getAttribute("name"));
        }

        List<String> testElementsDisplayedFiltered = testElementsDisplayed.stream()
                .filter(line -> !"arrow back Vehicle details".equals(line))
                .collect(Collectors.toList());

        boolean isPresent = true;
        for (String s : testElementsDisplayedFiltered) {
            if (!(s.contains("FAIL") || s.contains("PASS") || s.contains("PRS") || s.contains("ABANDONED") || s.contains("PROHIBITION"))) {
                isPresent = false;
            }
        }
        return isPresent;
    }

    public boolean checkAllTestsHaveDates() {
        List<WebElement> elementsDisplayed = findElementsByXpath("//XCUIElementTypeButton");

        List<String> testElementsDisplayed = new ArrayList<>();
        for (WebElement we : elementsDisplayed) {
            testElementsDisplayed.add(we.getAttribute("name"));
        }

        List<String> testElementsDisplayedFiltered = testElementsDisplayed.stream()
                .filter(line -> !"arrow back Vehicle details".equals(line))
                .collect(Collectors.toList());

        boolean isPresent = true;
        String regex = ".*(0[1-9]|[12]\\d|3[01]) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}.*";
        for (String s : testElementsDisplayedFiltered) {
            if (s.matches(regex))
                continue;
            else isPresent = false;
        }
        return isPresent;
    }

    public boolean checkAllElementsAreNotEditable() {
        List<WebElement> elementsDisplayed = findElementsByXpath("//XCUIElementTypeStaticText");
        boolean isEditable = false;
        for (WebElement we : elementsDisplayed) {
            try {
                we.sendKeys("Test");
                isEditable = true;
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
        return isEditable;
    }

    public boolean elementIsDisplayed(String element) {
        try {
            return findElementById(element).isDisplayed();
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public void scroll() {
        scroll(200, 700, 200, 300);
    }

    public void scrollPageDown() {
        scrollDownTo(500, -100);
    }
}
