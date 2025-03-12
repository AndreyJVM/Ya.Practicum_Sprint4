package ui;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicPage;
import pages.OrderPage;

public class BaseTest {

    public WebDriver driver;
    public BasicPage basicPage;
    public OrderPage orderPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/main/java/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BasicPage.BASE_URI);

        basicPage = new BasicPage(driver);
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}