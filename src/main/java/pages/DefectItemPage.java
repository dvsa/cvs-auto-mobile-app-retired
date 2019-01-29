package pages;

public class DefectItemPage extends BasePage {

    private static final String DEFECT_ITEM_PAGE_ID = "Defect item";

    public void selectItemFromList(String itemName) {
        findElementByXpath("//*[contains(@label, '" + itemName + "')]").click();
    }

    public void waitUntilPageIsLoaded() {
        waitUntilPageIsLoadedById(DEFECT_ITEM_PAGE_ID);
    }

}
