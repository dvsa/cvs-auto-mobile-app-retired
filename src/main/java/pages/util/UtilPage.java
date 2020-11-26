package pages.util;

import net.serenitybdd.core.Serenity;
import pages.BasePage;

public class UtilPage extends BasePage {

    public void showBrowserstackUrl(String url){
        Serenity.recordReportData().withTitle("<a href=\""+url+"\">Click to see browserstack video</a>\n").andContents("Browserstack Url");
    }
}
