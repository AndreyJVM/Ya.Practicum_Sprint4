package basicQATest;

import pages.BasicPage;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class OpenYandexBasicPageTest extends BaseTest {

    private final String YANDEX_URL = System.getProperty("ya.base.url").toLowerCase(Locale.ROOT);

    @Test
    public void checkClickYandexLogo_OpensYandexMainPage() {
        BasicPage basicPage = new BasicPage(driver);
        basicPage.waitForLoadServiceLogo();

        basicPage.clickYandexLogo();
        String currentUrl = driver.getCurrentUrl();

        assertEquals(YANDEX_URL, currentUrl);
    }
}