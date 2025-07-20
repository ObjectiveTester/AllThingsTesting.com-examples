import { expect, type Locator, type Page } from '@playwright/test';

export class LoginPage {
  readonly page: Page;
  readonly userName: Locator;
  readonly password: Locator;
  readonly loginButton: Locator;
  readonly errorMessage: Locator;
  
  readonly usernameError = 'Username is required';
  readonly passwordError = 'Password is required';
  readonly incorrectError = 'Username and password do not match any user in this service';
  readonly pageTitle = 'Swag Labs';

  constructor(page: Page) {
    this.page = page;
    this.userName = page.locator('#user-name');
    this.password = page.locator('#password');
    this.loginButton = page.locator('input[type="submit"]');
    this.errorMessage = page.locator('.error-message-container');
  }

  async pageObjectModel() {
    await this.userName.isEnabled();
  }
}