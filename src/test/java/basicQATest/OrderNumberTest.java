package basicQATest;

import pages.BasicPage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderNumberTest extends BaseTest {

    private final String orderNumber;

    public OrderNumberTest(String orderNumber) {
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