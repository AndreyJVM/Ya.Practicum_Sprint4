package basicQATest;
import seleniumWebYandexScooterTest.BasicPageTest;
import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import static seleniumWebYandexScooterTest.BasicPageTest.PAGE_URL;

public class OpenYandexBasicPageTest {

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
        BasicPageTest objBasicPage = new BasicPageTest(driver);
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



