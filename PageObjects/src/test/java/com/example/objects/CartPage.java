package com.example.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    private By linkCheckout = By.id("checkout");
    private By inputFirstName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By inputPostalCode = By.id("postal-code");
    private By linkContinue = By.id("continue");
    private By classSummaryTotal = By.className("summary_total_label");
    private By linkFinish = By.id("finish");
    private By classComplete = By.className("complete-text");

    private By linkBack = By.name("back-to-products");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
        driver.findElement(linkCheckout).click();
    }

    public void fillShipping(String first, String last, String postcode) {
        WebElement element = driver.findElement(inputFirstName);
        element.clear();
        element.sendKeys(first);

        element = driver.findElement(inputLastName);
        element.clear();
        element.sendKeys(last);

        element = driver.findElement(inputPostalCode);
        element.clear();
        element.sendKeys(postcode);

        driver.findElement(linkContinue).click();
    }

    public String getTotalValue() {
        return driver.findElement(classSummaryTotal).getText();
    }
    
    public void finish() {
        driver.findElement(linkFinish).click();
    }
    
    public String getCompleteText() {
        return driver.findElement(classComplete).getText();
    }


    
    

}
