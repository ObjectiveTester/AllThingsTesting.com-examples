import { expect, type Locator, type Page } from '@playwright/test';

export class Header {
  readonly page: Page;
  readonly burger: Locator;
  readonly cart: Locator;
  readonly subHeader: Locator;

  constructor(page: Page) {
    this.page = page;
    this.burger = page.locator('.react-gurger-menu-btn');
    this.cart = page.locator('#shopping_cart_container');
    this.subHeader = page.locator('.header_secondary_container .title');    
  }

  async pageObjectModel() {
    await this.burger.isEnabled();
  }
}