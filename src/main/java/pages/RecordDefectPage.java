package pages;

public class RecordDefectPage extends BasePage {

    private static final String RECORD_DEFECT_PAGE_ID = "Record defect";

    public void selectItemFromList(String itemName) {
        findElementByXpath("//*[contains(@label, '" + itemName + "')]").click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(RECORD_DEFECT_PAGE_ID);
    }

    public int getElementsNumberFromList(String... values) {
        return findAllDataByComposedXpath(values).size();
    }
}
