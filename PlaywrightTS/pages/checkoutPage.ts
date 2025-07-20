import { expect, type Locator, type Page } from '@playwright/test';

export class CheckoutPage {
  readonly page: Page;
  readonly shoppingCart: Locator;
  readonly firstName: Locator;
  readonly lastName: Locator;
  readonly postalCode: Locator;
  readonly subTotal: Locator;
  readonly tax: Locator;
  readonly summaryTotal: Locator;
  readonly continueButton: Locator;
  readonly checkoutButton: Locator;

  readonly checkout1Title = 'Checkout: Your Information';
  readonly checkout2Title = 'Checkout: Overview';
  readonly checkoutCompleteTitle = 'Checkout: Complete!';

  constructor(page: Page) {
    this.page = page;
    this.firstName = page.locator('[data-test=firstName]');
    this.lastName = page.locator('[data-test=lastName]');
    this.postalCode = page.locator('[data-test=postalCode]');
    this.subTotal = page.locator('.summary_subtotal_label');
    this.tax = page.locator('.summary_tax_label');
    this.summaryTotal = page.locator('.summary_total_label');
    this.continueButton = page.locator('#continue');
    this.checkoutButton = page.locator('.btn_action');
  }

  async pageObjectModel() {
    await this.shoppingCart.isEnabled();
  }
}