package basicQATest;
import pages.BasicPage;
import pages.OrderPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReturnToBasicPageTest extends BaseTest{

    @Test
    public void checkClickOnLogoReturnsToMainPage() {
        BasicPage objBasicPage = new BasicPage(driver);
        OrderPage objOrderPage = new OrderPage(driver);

        objBasicPage.waitForLoadServiceLogo();
        objOrderPage.clickOrderButtonTop();
        objOrderPage.waitForLoadOrderHeader();
        objBasicPage.clickServiceLogo();
        assertTrue(objBasicPage.isHomeHeaderDisplayed());
    }
}