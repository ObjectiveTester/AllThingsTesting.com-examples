package com.example.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class BrowserBase {

    public BrowserBase() {
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
    public void loadPage() {
        driver.get("https://www.saucedemo.com");
    }
    
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    //shared methods for testing
    //get title
    public String getPageTitle() {
        return driver.getTitle();
    }

    //scroll element into view
    public void scrollTo(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //screenshot
    public void takeScreenshot(String dir, String fileName) {
        try {
            new File(dir).mkdirs();
            try ( FileOutputStream output = new FileOutputStream(dir + File.separator + "screenshot" + fileName + ".png")) {
                output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException ex) {
        }
    }

}
