package com.example.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebDriver driver;

    private By selectSort = By.className("product_sort_container");
    private By buttonMenu = By.id("react-burger-menu-btn");
    private By menuLogout = By.id("logout_sidebar_link");

    private By imageBackpack = By.cssSelector("[alt='Sauce Labs Backpack']");
    private By inputAddBackpack = By.id("add-to-cart-sauce-labs-backpack");

    private By linkShoppingCart = By.id("shopping_cart_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getMenuButton() {
        return driver.findElement(buttonMenu);
    }

    public WebElement getLogout() {
        return driver.findElement(menuLogout);
    }

    public void doLogout() {
        driver.findElement(buttonMenu).click();
        driver.findElement(menuLogout).click();
    }

    public WebElement getImageBackpack() {
        return driver.findElement(imageBackpack);
    }

    public void addBackpack() {
        driver.findElement(inputAddBackpack).click();
    }

    public WebElement getCart() {
        return driver.findElement(linkShoppingCart);
    }

    public WebElement getSelectSort() {
        return driver.findElement(selectSort);
    }

}
