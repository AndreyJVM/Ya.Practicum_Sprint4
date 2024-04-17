package basicQATest;
import pages.BasicPage;
import pages.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static pages.BasicPage.PAGE_URL;

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
        BasicPage objBasicPage = new BasicPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);

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

