package basicQATest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasicPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static pages.BasicPage.BASE_URI;

@RunWith(Parameterized.class)
public class OrderNumber_Test extends Base_Test{

    private final String orderNumber;

    public OrderNumber_Test(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderNumber() {
        return new Object[][] {
                {"000000"},
                {"555-555"},
        };
    }

    @Test
    public void checkNonexistentNumber_showsError() {
        BasicPage objBasicPage = new BasicPage(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickOrderStatusButton();
        objBasicPage.waitForLoadOrderNumberInput();
        objBasicPage.enterOrderNumber(orderNumber);
        objBasicPage.clickGoButton();
        Assert.assertTrue(objBasicPage.isImageNotFoundDisplayed());
    }
}