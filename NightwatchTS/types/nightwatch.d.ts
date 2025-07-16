// types/nightwatch.d.ts
import 'nightwatch';
import { LoginPage } from '../pages/loginPage';
import { header } from '../pages/header';
import { productsPage } from '../pages/productsPage';
import { cartPage } from '../pages/cartPage';
import { checkoutPage } from '../pages/checkoutPage';

declare module 'nightwatch' {
  interface NightwatchCustomPageObjects {
    loginPage(): LoginPage;
    header(): header;
    productsPage(): ProductsPage;
    cartPage(): cartPage;
    checkoutPage(): CheckoutPage;
  }

}