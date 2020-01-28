import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Page {

    // Specifying all elements of the web page used for tests
    private final By USER_TOPLINE_ELEMENT = By.className("header-topline__user-link");
    private final By LOGIN_INPUT_EMAIL = By.id("auth_email");
    private final By LOGIN_INPUT_PASS = By.id("auth_pass");
    private final By LOGIN_INPUT_BUTTON = By.cssSelector(".auth-modal__submit");
    private final By SEARCH_FORM_ELEMENT = By.cssSelector(".search-form__input");
    private final By SEARCH_SUBMIT_ELEMENT = By.cssSelector(".search-form__submit");
    final By GOODS_LIST = By.className("goods-tile__inner");
    private final By GOODS_TITLE = By.className("goods-tile__inner");
    private final By BUY_BTN_LOCATOR = By.xpath("//*[@class='buy-button__label']");
    final By CART_LOCATOR = By.className("cart-modal__inner");
    final By CART_DUMMY_ELEMENT = By.className("cart-modal__dummy");
    final By CART_TITLE_ELEMENT = By.className("modal__title");
    final By CART_CONTENT_ELEMENT = By.className("cart-modal__content");
    private final By CART_REMOVE_ELEMENT = By.className("cart-modal__remove");
    private final By REMOVE_CONFIRM_ELEMENT = By.linkText("Удалить без сохранения");


    void getTheBasePage (String url, WebDriver webDriver){
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }
    void login (String email, String password, WebDriver webDriver){
        webDriver.findElement(USER_TOPLINE_ELEMENT).click();
        webDriver.findElement(LOGIN_INPUT_EMAIL).sendKeys(email);
        webDriver.findElement(LOGIN_INPUT_PASS).sendKeys(password);
        webDriver.findElement(LOGIN_INPUT_BUTTON).click();
    }
    void searchTheItem (String item, WebDriver webDriver){
        webDriver.findElement(SEARCH_FORM_ELEMENT).sendKeys(item);
        webDriver.findElement(SEARCH_SUBMIT_ELEMENT).click();
    }
    void addToCart (WebDriverWait webDriverWait) {
        WebElement webElement1 = webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated(GOODS_TITLE));
        webElement1.click();
        WebElement webElement2 = webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated(BUY_BTN_LOCATOR));
        webElement2.click();
    }
    void removeFromCart(WebDriverWait webDriverWait){
        WebElement webElement1 = webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated(CART_REMOVE_ELEMENT));
        webElement1.click();
        WebElement webElement2 = webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated(REMOVE_CONFIRM_ELEMENT));
        webElement2.click();
    }
}
