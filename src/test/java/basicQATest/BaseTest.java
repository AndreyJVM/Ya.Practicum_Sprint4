package basicQATest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static pages.BasicPage.BASE_URI;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startUp() {
        System.setProperty("chromedriver", "./src/main/java/resources/webdriver/chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URI);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}