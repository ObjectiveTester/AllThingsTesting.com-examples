import { expect, type Locator, type Page } from '@playwright/test';

export class CartPage {
  readonly page: Page;
  readonly noOfItemsInCart: Locator;
  readonly itemPrice: Locator;
  readonly itemName: Locator;
  readonly checkoutButton: Locator;
  readonly cartHeaderTitle = 'Your Cart';

  constructor(page: Page) {
    this.page = page;
    this.noOfItemsInCart = page.locator('.cart_quantity');
    this.itemPrice = page.locator('.inventory_item_price');
    this.itemName = page.locator('.inventory_item_name');
    this.checkoutButton = page.locator('.btn_action');
  }

  async pageObjectModel() {
    await this.checkoutButton.isEnabled();
  }
}