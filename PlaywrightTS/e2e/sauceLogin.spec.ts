import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/loginPage';
import { Header } from '../pages/header';
import { ProductsPage } from '../pages/productsPage';
import { Globals } from '../pages/globals';

test.describe('Swag Labs login tests', () => {

  test('fail with invalid credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);

    await page.goto('/');
    await expect(page).toHaveTitle(loginPage.pageTitle);

    await loginPage.userName.fill(Globals.userName);
    await loginPage.loginButton.click();

    await expect(loginPage.errorMessage).toBeVisible();
    await expect(loginPage.errorMessage).toContainText(loginPage.passwordError);
  });

  test('login with valid credentials', async ({ page }) => {
    const loginPage = new LoginPage(page);
    const header = new Header(page);
    const productsPage = new ProductsPage(page);

    await page.goto('/');
    await expect(page).toHaveTitle(loginPage.pageTitle);

    await loginPage.userName.fill(Globals.userName);
    await loginPage.password.fill(Globals.userPassword);
    await loginPage.loginButton.click();

    await expect(page).toHaveURL(productsPage.path);
    await expect(header.subHeader).toHaveText(productsPage.productTitle);
    await expect(header.cart).toBeVisible();
  });

});