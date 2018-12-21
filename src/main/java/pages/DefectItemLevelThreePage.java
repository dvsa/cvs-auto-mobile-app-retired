package pages;

public class DefectItemLevelThreePage extends BasePage {

    private static final String ADVISORY_LABEL_ID = "ADVISORY";
    private static final String ADVISORY_NOTE_ID = "Add an advisory note";

    public void clickAddAdvisoryNote() {
        findElementById(ADVISORY_NOTE_ID).click();
    }

    public void waitUntillPageIsLoaded() {
        waitUntilPageIsLoadedById(ADVISORY_LABEL_ID);
    }

    public void selectById(String defectId) {
        findElementById(defectId).click();
    }
}
