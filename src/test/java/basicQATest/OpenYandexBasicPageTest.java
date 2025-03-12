package basicQATest;

import pages.BasicPage;
import org.junit.Test;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class OpenYandexBasicPageTest extends BaseTest {

    private BasicPage basicPage;

    private final String YANDEX_URL = System.getProperty("ya.base.url").toLowerCase(Locale.ROOT);

    @Override
    public void startUp() {
        super.startUp();
        basicPage = new BasicPage(driver);
    }

    @Test
    public void checkClickYandexLogo_OpensYandexMainPage() {
        basicPage.waitForLoadServiceLogo();

        basicPage.clickYandexLogo();
        String currentUrl = driver.getCurrentUrl();

        assertEquals(YANDEX_URL, currentUrl);
    }
}