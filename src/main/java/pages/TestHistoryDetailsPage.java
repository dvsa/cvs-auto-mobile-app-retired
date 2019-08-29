package pages;

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

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(TEST_HISTORY_DETAILS_PAGE_TITLE);
    }

    public boolean isPageTitleDisplayed() {
        return findElementById(TEST_HISTORY_DETAILS_PAGE_TITLE).isDisplayed();
    }

    public void clickBackButton() {
        findElementByXpath(BACK_BUTTON_XPATH).click();
    }

    public List<String> getDataSetBetweenTitles(String dataSetStartText, String dataSetEndText) {
        List<WebElement> webElementList = findElementsByClassName(PAGE_ALL_TEXT_CLASS_NAME);
        List<String> listOfData = new ArrayList<>();
        boolean isInInterval = false;
        for (WebElement webElement : webElementList) {
            if (webElement.getAttribute("name").equalsIgnoreCase(dataSetStartText)) {
                isInInterval = true;
            }
            if (isInInterval) {
                listOfData.add(webElement.getAttribute("value"));
            }
            if (webElement.getAttribute("name").equalsIgnoreCase(dataSetEndText)) {
                isInInterval = false;
            }
        }
        return listOfData;
    }

    public boolean checkElementIsPresent(String element) {
        return findElementById(element).isDisplayed();
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
        return findElementById(element).isDisplayed();
    }

    public void scroll() {
        scroll(200, 700, 200, 300);
    }
}
