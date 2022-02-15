package com.example.tests;

import com.example.objects.CartPage;
import com.example.objects.LoginPage;
import com.example.objects.InventoryPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PurchaseTest extends BrowserBase {

    LoginPage loginPage;
    CartPage cartPage;
    InventoryPage storePage;


    public PurchaseTest() {
        loginPage = new LoginPage(driver.get());
        cartPage = new CartPage(driver.get());
        storePage = new InventoryPage(driver.get());
    }

    @Test
    public void addBackpackCheckout() {
        System.out.println("add backpack");

        //login
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        //check image exists
        assertEquals("https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", storePage.getImageBackpack().getAttribute("src"));

        //add to cart
        storePage.addBackpack();

        //check cart count
        assertEquals("1", storePage.getCart().getText());

        //go to cart
        storePage.getCart().click();

        cartPage.checkout();

        //checkout
        cartPage.fillShipping("John", "Smith", "90210");

        assertEquals("Total: $32.39", cartPage.getTotalValue());

        cartPage.finish();

        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", cartPage.getCompleteText());
    }

}
