package com.example.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    private By usernameTextField = By.id("user-name");
    private By passwordTextField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorContainer = By.cssSelector(".error-message-container.error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username) {
        WebElement element = driver.findElement(usernameTextField);
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordTextField);
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(password);
        }
    }

    public void clickLogin() {
        WebElement element = driver.findElement(loginButton);
        if (element.isDisplayed()) {
            element.click();
        }
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement getErrorMessageContainer() {
        return driver.findElement(errorContainer);
    }
}
