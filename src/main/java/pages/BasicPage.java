package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class BasicPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final String BASE_URI = System.getProperty("webdriver.base.url").toLowerCase(Locale.ROOT);

    //Логотип сервиса "Самокат"
    private static final By SERVICE_LOGO = By.className("Header_LogoScooter__3lsAR");
    //Кнопка "Да все привыкли"
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");
    //Список вопросов
    private static final By FAQ_LIST = By.className("accordion");
    //Надпись на главной странице "Самокат на пару дней"
    private static final By HOME_HEADER = By.className("Home_Header__iJKdX");
    //Логотип Яндекса
    private static final By YANDEX_LOGO = By.cssSelector("[alt='Yandex']");
    //Кнопка "Статус заказа"
    private static final By ORDER_STATUS_BUTTON = By.className("Header_Link__1TAG7");
    //Плейсхолдер "Введите номер заказа"
    private static final By INPUT_ORDER_NUMBER = By.xpath(".//input[@placeholder='Введите номер заказа']");
    //Go кнопка
    private static final By GO_BUTTON = By.xpath(".//button[text()='Go!']");
    //Изображение "Такого заказа нет"
    private static final By NOT_FOUND_IMAGE = By.cssSelector("div.Track_NotFound__6oaoY > img");

    public BasicPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void waitForLoadServiceLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SERVICE_LOGO));
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void scrollToQuestionsList() {
        WebElement element = driver.findElement(FAQ_LIST);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickQuestion(String question) {
        String questionsList = String.format(".//div[@class='accordion']//*[text()='%s']", question);
        driver.findElement(By.xpath(questionsList)).click();
    }

    public void verifyAnswer(String answer) {
        String answersList = String.format(".//div[@class='accordion']//*[text()='%s']", answer);
        String answerText = driver.findElement(By.xpath(answersList)).getText();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(answersList), answerText));
    }

    public void clickServiceLogo() {
        driver.findElement(SERVICE_LOGO).click();
    }

    public boolean isHomeHeaderDisplayed() {
        WebElement homeHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_HEADER));
        return homeHeader.isDisplayed();

    }

    public void clickYandexLogo() {
        driver.findElement(YANDEX_LOGO).click();

        wait.until(numberOfWindowsToBe(2));
        switchToNewWindow(driver.getWindowHandle());
        
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete'"));
    }

    public void clickOrderStatusButton() {
        driver.findElement(ORDER_STATUS_BUTTON).click();
    }

    public void waitForLoadOrderNumberInput() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_ORDER_NUMBER));
    }

    public void enterOrderNumber(String orderNumber) {
        driver.findElement(INPUT_ORDER_NUMBER).sendKeys(orderNumber);
    }

    public void clickGoButton() {
        driver.findElement(GO_BUTTON).click();
    }

    public boolean isImageNotFoundDisplayed() {
        WebElement notFoundImage = wait.until(ExpectedConditions.visibilityOfElementLocated(NOT_FOUND_IMAGE));
        return notFoundImage.isDisplayed();
    }

    private String switchToNewWindow(String mainWindow) {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                return handle;
            }
        }
        throw new IllegalStateException("Новое окно не найдено");
    }
}