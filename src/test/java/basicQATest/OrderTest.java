package basicQATest;
import org.openqa.selenium.By;
import seleniumWebYandexScooterTest.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static seleniumWebYandexScooterTest.BasicPageTest.PAGE_URL;
import static seleniumWebYandexScooterTest.OrderPageTest.ORDER_BUTTON_BOTTOM;
import static seleniumWebYandexScooterTest.OrderPageTest.ORDER_BUTTON_TOP;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;
    private BasicPageTest objBasicPage;
    private OrderPageTest objOrderPage;

    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    private final By xpathOrderButton;

    public OrderTest
            (String name, String lastName, String address, String metro, String phoneNumber,
             String date, String period, String color, String comment, By xpathOrderButton) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
        this.xpathOrderButton = xpathOrderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {"Вася", "Пупкин", "ул. Ватутина, 25", "Черкизовская", "+79111111111", "23.03.2023", "сутки", "чёрный жемчуг", "В 17:00 возле подъезда №1", ORDER_BUTTON_BOTTOM},
                {"Ян", "По", "ул. Победы, 7", "Красные Ворота", "88004005050", "25.04.2024", "четверо суток", "серая безысходность", "-", ORDER_BUTTON_TOP},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(PAGE_URL);
        objBasicPage = new BasicPageTest(driver);
        objOrderPage = new OrderPageTest(driver);
        objBasicPage.waitForLoadServiceLogo();
        objBasicPage.clickCookieButton();
    }

    @Test
    public void checkSuccessfulOrderTopButtonAndBottom() {
        objOrderPage.setOrderDetails(name, lastName, address, metro, phoneNumber, date, period, color, comment, xpathOrderButton);
        Assert.assertTrue(objOrderPage.isOrderCreatedStatusDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

