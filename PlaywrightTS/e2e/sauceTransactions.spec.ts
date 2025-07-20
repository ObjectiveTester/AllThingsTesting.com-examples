import { test, expect } from '@playwright/test';
import { Header } from '../pages/header';
import { CartPage } from '../pages/CartPage';
import { ProductsPage } from '../pages/productsPage';
import { Globals } from '../pages/globals';
import { CheckoutPage } from '../pages/checkoutPage';

test.describe('Swag Labs transaction tests', () => {

  test('6 items on the inventory page', async ({ page, context }) => {
    const header = new Header(page);
    const productsPage = new ProductsPage(page);

    await productsPage.loginWithCookie(Globals.userName, context);

    await expect(page).toHaveURL(productsPage.path);
    await expect(header.subHeader).toHaveText(productsPage.productTitle);
    await expect(header.cart).toBeVisible();
    await expect(productsPage.item).toHaveCount(6);
  });

  test('complete the purchase process of an item from the inventory', async ({ page, context }) => {
    const header = new Header(page);
    const productsPage = new ProductsPage(page);
    const cartPage = new CartPage(page);
    const checkoutPage = new CheckoutPage(page);

    await productsPage.loginWithCookie(Globals.userName, context);

    await productsPage.itemBikeLight.click();
    await expect(productsPage.shoppingCartBadge).toHaveText('1');

    await productsPage.shoppingCart.click();
    await expect(header.subHeader).toHaveText(cartPage.cartHeaderTitle);

    await expect(cartPage.noOfItemsInCart).toHaveText('1');
    await expect(cartPage.itemName).toHaveText('Sauce Labs Bike Light');
    await expect(cartPage.itemPrice).toHaveText('$9.99');
    await cartPage.checkoutButton.click();

    await expect(header.subHeader).toHaveText(checkoutPage.checkout1Title);

    await checkoutPage.firstName.fill(Globals.firstName);
    await checkoutPage.lastName.fill(Globals.lastName);
    await checkoutPage.postalCode.fill(Globals.postalCode);
    await checkoutPage.checkoutButton.click();

    await expect(header.subHeader).toHaveText(checkoutPage.checkout2Title);

    await expect(checkoutPage.subTotal).toContainText('$9.99');
    await expect(checkoutPage.tax).toContainText('$0.80');
    await expect(checkoutPage.summaryTotal).toContainText('$10.79');

    await checkoutPage.checkoutButton.click();
    await expect(header.subHeader).toHaveText(checkoutPage.checkoutCompleteTitle);
  });

});