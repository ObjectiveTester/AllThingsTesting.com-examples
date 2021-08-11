
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RefactoredTest {

    public RefactoredTest() {
    }
    WebElement element;
    Alert alert;
    Select selector;
    static WebDriver driver;
    static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "/Users/steve/Downloads/chromedriver");
        driver = new ChromeDriver();
        
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeEach
    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void badLogin() {
        //click:login-button
        driver.findElement(By.id("login-button")).click();

        //find:.error-message-container.error
        element = driver.findElement(By.cssSelector(".error-message-container.error"));
        //assert:"Epic sadface: Username is required"
        assertEquals("Epic sadface: Username is required", element.getText());
    }

    @Test
    public void loginAndOut() {
        //find:user-name
        element = driver.findElement(By.id("user-name"));
        element.clear();
        element.sendKeys("standard_user");

        //find:password
        element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys("secret_sauce");

        //click:login-button
        driver.findElement(By.id("login-button")).click();

        //find:product_sort_container
        element = driver.findElement(By.className("product_sort_container"));
        //assert:"az"
        assertEquals("az", element.getAttribute("value"));

        //find:react-burger-menu-btn
        element = driver.findElement(By.id("react-burger-menu-btn"));
        //change this to get text
        assertEquals("Open Menu", element.getText());

        //click:react-burger-menu-btn
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //click:logout_sidebar_link
        driver.findElement(By.id("logout_sidebar_link")).click();

        //find:login-button
        element = driver.findElement(By.id("login-button"));
        //assert:"Login"
        assertEquals("Login", element.getAttribute("value"));
    }

    @Test
    public void purchaseTest() {
        //find:user-name
        element = driver.findElement(By.id("user-name"));
        element.clear();
        element.sendKeys("standard_user");

        //find:password
        element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys("secret_sauce");

        //click:login-button
        driver.findElement(By.id("login-button")).click();

        //find:[alt='Sauce Labs Backpack']
        element = driver.findElement(By.cssSelector("[alt='Sauce Labs Backpack']"));
        //assert:"https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg"
        assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg",element.getAttribute("src"));

        //click:add-to-cart-sauce-labs-backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //find:shopping_cart_container
        element = driver.findElement(By.id("shopping_cart_container"));
        //assert:"1"
        assertEquals("1", element.getText());

        //click:shopping_cart_container
        driver.findElement(By.id("shopping_cart_container")).click();

        //click:checkout
        driver.findElement(By.id("checkout")).click();

        //find:first-name
        element = driver.findElement(By.id("first-name"));
        element.clear();
        element.sendKeys("John");

        //find:last-name
        element = driver.findElement(By.id("last-name"));
        element.clear();
        element.sendKeys("Smith");

        //find:postal-code
        element = driver.findElement(By.id("postal-code"));
        element.clear();
        element.sendKeys("90210");

        //click:continue
        driver.findElement(By.id("continue")).click();

        //find:summary_total_label
        element = driver.findElement(By.className("summary_total_label"));
        //assert:"Total: $32.39"
        assertEquals("Total: $32.39", element.getText());

        //click:finish
        driver.findElement(By.id("finish")).click();

        //find:complete-text
        element = driver.findElement(By.className("complete-text"));
        //assert:"Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", element.getText());

        //click:back-to-products
        driver.findElement(By.id("back-to-products")).click();

        //click:react-burger-menu-btn
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //click:logout_sidebar_link
        driver.findElement(By.id("logout_sidebar_link")).click();

        //find:login-button
        element = driver.findElement(By.id("login-button"));
        //assert:"Login"
        assertEquals("Login", element.getAttribute("value"));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    public static void switchWin(WebDriver driver, String title) {
        String target = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(title)) {
                target = handle;
            }
        }
        driver.switchTo().window(target);
    }
}

