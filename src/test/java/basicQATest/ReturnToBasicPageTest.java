package basicQATest;
import seleniumWebYandexScooterTest.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static seleniumWebYandexScooterTest.BasicPageTest.PAGE_URL;

public class ReturnToBasicPage {

    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
    }

    @Test
    public void checkClickOnLogoReturnsToMainPage() {
        BasicPageTest objBasicPage = new BasicPageTest(driver);
        OrderPageTest objOrderPage = new OrderPageTest(driver);

        objBasicPage.waitForLoadServiceLogo();
        objOrderPage.clickOrderButtonTop();
        objOrderPage.waitForLoadOrderHeader();
        objBasicPage.clickServiceLogo();
        Assert.assertTrue(objBasicPage.IsHomeHeaderDisplayed());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

