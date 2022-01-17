package com.example.tests;

import com.example.objects.LoginPage;
import com.example.objects.InventoryPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BrowserBase {

    LoginPage loginPage;
    InventoryPage storePage;

    public LoginTest() {
        loginPage = new LoginPage((WebDriver)driver.get());
        storePage = new InventoryPage((WebDriver)driver.get());
    }

    @Test
    public void badLogin() {
        System.out.println("bad login");

        loginPage.clickLogin();
        assertTrue(loginPage.getErrorMessageContainer().isDisplayed());
        assertEquals("Epic sadface: Username is required", loginPage.getErrorMessageContainer().getText());
    }

    @Test
    public void loginLogout() {
        System.out.println("login and logout");

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        assertEquals("Open Menu", storePage.getMenuButton().getText());
        assertEquals("az", storePage.getSelectSort().getAttribute("value"));

        storePage.getMenuButton().click();

        storePage.getLogout().click();

        assertTrue(loginPage.getLoginButton().isDisplayed());
    }

}
