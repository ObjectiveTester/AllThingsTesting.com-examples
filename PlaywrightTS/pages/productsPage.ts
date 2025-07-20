import { expect, type Locator, type Page } from '@playwright/test';
import { Context } from 'vm';

export class ProductsPage {
  readonly page: Page;
  readonly shoppingCart: Locator;
  readonly item: Locator;
  readonly itemName: Locator;
  readonly shoppingCartBadge: Locator;
  readonly filter: Locator;
  readonly itemPrice: Locator;
  readonly itemBackpack: Locator;
  readonly itemBikeLight: Locator;

  readonly productTitle = 'Products';
  readonly path = 'https://www.saucedemo.com/inventory.html';


  constructor(page: Page) {
    this.page = page;
    this.shoppingCart = page.locator('.shopping_cart_container');
    this.item = page.locator('.inventory_item');
    this.itemName = page.locator('.inventory_item_name');
    this.shoppingCartBadge = page.locator('.shopping_cart_badge');
    this.filter = page.locator('.product_sort_container');
    this.itemPrice = page.locator('.inventory_item_price');
    this.itemBackpack = page.locator('#add-to-cart-sauce-labs-backpack');
    this.itemBikeLight = page.locator('#add-to-cart-sauce-labs-bike-light');
  }

  async goto() {
    await this.page.goto('https://www.saucedemo.com/inventory.html');
  }

  async loginWithCookie(username: String, context: Context) {
    await context.addCookies([
      { name: 'session-username', value: username, path: '/', domain: 'www.saucedemo.com' }
    ]);
    await this.goto();
  }

  async pageObjectModel() {
    await this.shoppingCart.isEnabled();
  }
}