package basicQATest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicPage;

public class BaseTest {

    public WebDriver driver;

    @Before
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BasicPage.BASE_URI);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}