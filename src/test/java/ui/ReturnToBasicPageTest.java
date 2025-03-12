package ui;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ReturnToBasicPageTest extends BaseTest {

    @Test
    public void checkClickOnLogoReturnsToMainPage() {
        basicPage.waitForLoadServiceLogo();
        orderPage.clickOrderButtonTop();

        orderPage.waitForLoadOrderHeader();
        basicPage.clickServiceLogo();

        assertTrue(basicPage.isHomeHeaderDisplayed());
    }
}