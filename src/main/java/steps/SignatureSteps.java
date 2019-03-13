package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SignaturePage;

public class SignatureSteps extends ScenarioSteps {

    SignaturePage signaturePage;

    @Step
    public void createSignatureIfNeeded() {
        signaturePage.waitPageToLoad();
        signaturePage.createSignature();
        signaturePage.clickSaveButton();
        signaturePage.confirmSignature();
    }
}
