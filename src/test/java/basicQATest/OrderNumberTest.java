package basicQATest;

import pages.BasicPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderNumberTest extends BaseTest {

    private final String orderNumber;
    private BasicPage basicPage;

    @Override
    public void startUp() {
        super.startUp();
        basicPage = new BasicPage(driver);
    }

    public OrderNumberTest(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters(name = "orderNumber: {0}")
    public static Object[][] getOrderNumber() {
        return new Object[][] {
                {"000000"},
                {"555-555"},
                {""},
        };
    }

    @Test
    public void checkNonexistentNumber_showsError() {
        basicPage.waitForLoadServiceLogo();

        basicPage.clickOrderStatusButton();
        basicPage.waitForLoadOrderNumberInput();

        basicPage.enterOrderNumber(orderNumber);
        basicPage.clickGoButton();

        assertTrue(basicPage.isImageNotFoundDisplayed());
    }
}