package pages.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class UtilPage extends BasePage {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    public void showBrowserstackUrl(String url){
        logger.info(url);
    }
}
