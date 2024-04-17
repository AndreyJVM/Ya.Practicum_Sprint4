package basicQATest;
import pages.BasicPage;
import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import static pages.BasicPage.PAGE_URL;

public class OpenYandexBasicPage {

    private WebDriver driver;

    private final String YANDEX_URL = "https://dzen.ru/?yredirect=true";

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkClickYandexLogo_OpensYandexMainPage() {
        BasicPage objBasicPage = new BasicPage(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickYandexLogo();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(YANDEX_URL, currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



