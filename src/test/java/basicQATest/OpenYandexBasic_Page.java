package basicQATest;

import pages.BasicPage;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OpenYandexBasic_Page extends Base_Test{

    private final String YANDEX_URL = "https://dzen.ru/?yredirect=true";

    @Test
    public void checkClickYandexLogo_OpensYandexMainPage() {
        BasicPage objBasicPage = new BasicPage(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickYandexLogo();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(YANDEX_URL, currentUrl);
    }
}