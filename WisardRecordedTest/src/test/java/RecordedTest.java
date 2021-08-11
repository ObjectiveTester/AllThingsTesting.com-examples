
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
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class RecordedTest {

    public RecordedTest() {
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
        driver.get("https://www.saucedemo.com");
    }

    @Test
    @Order(1)
    public void test1() {
        //click:login-button
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Order(2)
    public void test2() {
        //find:.error-message-container.error
        element = driver.findElement(By.cssSelector(".error-message-container.error"));
        //assert:"Epic sadface: Username is required"
        assertEquals("Epic sadface: Username is required", element.getText());
    }

    @Test
    @Order(3)
    public void test3() {
        //find:user-name
        element = driver.findElement(By.id("user-name"));
        element.clear();
        element.sendKeys("standard_user");
    }

    @Test
    @Order(4)
    public void test4() {
        //find:password
        element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys("secret_sauce");
    }

    @Test
    @Order(5)
    public void test5() {
        //click:login-button
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Order(6)
    public void test6() {
        //find:product_sort_container
        element = driver.findElement(By.className("product_sort_container"));
        //assert:"az"
        assertEquals("az", element.getAttribute("value"));
    }

    @Test
    @Order(7)
    public void test7() {
        //find:react-burger-menu-btn
        element = driver.findElement(By.id("react-burger-menu-btn"));
        //assert:""
        assertEquals("", element.getAttribute("value"));
    }

    @Test
    @Order(8)
    public void test8() {
        //click:react-burger-menu-btn
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Test
    @Order(9)
    public void test9() {
        //click:logout_sidebar_link
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Test
    @Order(10)
    public void test10() {
        //find:login-button
        element = driver.findElement(By.id("login-button"));
        //assert:"Login"
        assertEquals("Login", element.getAttribute("value"));
    }

    @Test
    @Order(11)
    public void test11() {
        //find:user-name
        element = driver.findElement(By.id("user-name"));
        element.clear();
        element.sendKeys("standard_user");
    }

    @Test
    @Order(12)
    public void test12() {
        //find:password
        element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys("secret_sauce");
    }

    @Test
    @Order(13)
    public void test13() {
        //click:login-button
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    @Order(14)
    public void test14() {
        //find:[alt='Sauce Labs Backpack']
        element = driver.findElement(By.cssSelector("[alt='Sauce Labs Backpack']"));
        //assert:"https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg"
        assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", element.getAttribute("src"));
    }

    @Test
    @Order(15)
    public void test15() {
        //click:add-to-cart-sauce-labs-backpack
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Test
    @Order(16)
    public void test16() {
        //find:shopping_cart_container
        element = driver.findElement(By.id("shopping_cart_container"));
        //assert:"1"
        assertEquals("1", element.getText());
    }

    @Test
    @Order(17)
    public void test17() {
        //click:shopping_cart_container
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Test
    @Order(18)
    public void test18() {
        //click:checkout
        driver.findElement(By.id("checkout")).click();
    }

    @Test
    @Order(19)
    public void test19() {
        //find:first-name
        element = driver.findElement(By.id("first-name"));
        element.clear();
        element.sendKeys("John");
    }

    @Test
    @Order(20)
    public void test20() {
        //find:last-name
        element = driver.findElement(By.id("last-name"));
        element.clear();
        element.sendKeys("Smith");
    }

    @Test
    @Order(21)
    public void test21() {
        //find:postal-code
        element = driver.findElement(By.id("postal-code"));
        element.clear();
        element.sendKeys("90210");
    }

    @Test
    @Order(22)
    public void test22() {
        //click:continue
        driver.findElement(By.id("continue")).click();
    }

    @Test
    @Order(23)
    public void test23() {
        //find:summary_total_label
        element = driver.findElement(By.className("summary_total_label"));
        //assert:"Total: $32.39"
        assertEquals("Total: $32.39", element.getText());
    }

    @Test
    @Order(24)
    public void test24() {
        //click:finish
        driver.findElement(By.id("finish")).click();
    }

    @Test
    @Order(25)
    public void test25() {
        //find:complete-text
        element = driver.findElement(By.className("complete-text"));
        //assert:"Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", element.getText());
    }

    @Test
    @Order(26)
    public void test26() {
        //click:back-to-products
        driver.findElement(By.id("back-to-products")).click();
    }

    @Test
    @Order(27)
    public void test27() {
        //click:react-burger-menu-btn
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @Test
    @Order(28)
    public void test28() {
        //click:logout_sidebar_link
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Test
    @Order(29)
    public void test29() {
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
