package ui;

import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;
import static pages.OrderPage.ORDER_BUTTON_BOTTOM;
import static pages.OrderPage.ORDER_BUTTON_TOP;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

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

    @Parameterized.Parameters(name = "name: {0}; lastName: {1}; address: {2}; metro: {3}; phoneNumber: {4}; date: {5}; period: {6}; color: {7}; comment: {8}; xpathOrderButton: {9}")
    public static Object[][] getOrderDetails() {
        return new Object[][]{
                {"Вася", "Пупкин", "ул. Ватутина, 25", "Черкизовская", "+79111111111", "23.03.2023", "сутки", "чёрный жемчуг", "В 17:00 возле подъезда №1", ORDER_BUTTON_BOTTOM},
                {"Вася", "Пупкин", "ул. Ватутина, 25", "Черкизовская", "+79111111111", "23.03.2023", "сутки", "чёрный жемчуг", "В 17:00 возле подъезда №1", ORDER_BUTTON_TOP},
                {"Ян", "По", "ул. Победы, 7", "Красные Ворота", "88004005050", "25.04.2024", "четверо суток", "серая безысходность", "-", ORDER_BUTTON_BOTTOM},
                {"Ян", "По", "ул. Победы, 7", "Красные Ворота", "88004005050", "25.04.2024", "четверо суток", "серая безысходность", "-", ORDER_BUTTON_TOP},
        };
    }

    @Test
    public void checkSuccessfulOrderTopButtonAndBottom() {
        basicPage.waitForLoadServiceLogo();
        basicPage.clickCookieButton();
        orderPage.setOrderDetails(name, lastName, address, metro, phoneNumber, date, period, color, comment, xpathOrderButton);
        assertTrue(orderPage.isOrderCreatedStatusDisplayed());
    }

}