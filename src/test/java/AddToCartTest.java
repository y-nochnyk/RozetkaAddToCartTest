import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class AddToCartTest {

    // Specifying the test data
    private static final String USER_NAME = "Automation Tester";
    private static final String USER_EMAIL = "automation.qa.404@gmail.com";
    private static final String USER_PASS = "Strongpass123";
    private static final String SEARCH_QUERY = "Кроссовки Reebok";
    private static final String MODAL_TITLE = "Корзина";
    private static final String EMPTY_CART_TEXT = "Корзина пуста";

    // Setting up Page, webDriver and webDriverWait instances
    private Page page;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;


    @BeforeClass
    public void setUp(){
        page = new Page();

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

//        webDriver = new FirefoxDriver();
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 20);

        // Getting to the base page
        // Takes the URL and webDriver instance as the arguments
        page.getTheBasePage("https://rozetka.com.ua/", webDriver);
    }

    @Test(priority = 1)
    public void login(){
        // Login method takes as arguments: user email, user password, webDriver instance
        page.login(USER_EMAIL, USER_PASS, webDriver);

        // Wait explicitly for visibility of the element with link text equals to the user name
        WebElement webElement = webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.linkText("Automation Tester")));

        // Validation if the link text is equal to the user name, which means the user is logged in
        String actual = webElement.getText();
        assertEquals(actual, USER_NAME);
    }

    @Test(priority = 2)
    public void searchTheItem(){
        // Searching for the good "Кроссовки Reebok"
        page.searchTheItem(SEARCH_QUERY, webDriver);

        // Validation if there's a text "Кроссовки Reebok" within the list of found goods specified by its class name
        List<WebElement> list = webDriver.findElements(page.GOODS_LIST);
        for (WebElement el: list){
            String actual = el.getText();
            assertTrue(actual.contains(SEARCH_QUERY));
        }
    }

    @Test(priority = 3)
    public void addToCart() {
        // Adding first element from the list of goods
        // Method takes webDriverWait instance as an argument
        page.addToCart(webDriverWait);

        // Validation if there's a text "Корзина" equal to the expected cart title
        WebElement webElement = webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(page.CART_LOCATOR));
        String actualModalTitle = webElement.findElement(page.CART_TITLE_ELEMENT).getText();
        assertEquals(actualModalTitle, MODAL_TITLE);

        // Validation if a text equals to the search query is present at the good's link text,
        // specifying that there's a proper good inside a cart
        String actualModalContent = webElement.findElement(page.CART_CONTENT_ELEMENT).getText();
        assertTrue(actualModalContent.contains(SEARCH_QUERY));
    }

    @Test(priority = 4)
    public void removeFromCart(){
        // Removal of an item from the cart
        page.removeFromCart(webDriverWait);

        // Validation if there's a text "Корзина пуста" equals to the expected empty cart text
        WebElement webElement = webDriverWait.until
                (ExpectedConditions.presenceOfElementLocated(page.CART_DUMMY_ELEMENT));
        String actual = webElement.getText();
        assertTrue(actual.contains(EMPTY_CART_TEXT));
    }

    @AfterClass
    public void tearDown(){
        // Closing the webDriver
        webDriver.close();
    }
}
