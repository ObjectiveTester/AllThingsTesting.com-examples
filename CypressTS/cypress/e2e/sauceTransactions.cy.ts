import * as checkout from "../pages/checkoutPage";
import * as header from "../pages/header";
import * as cart from "../pages/cartPage";
import * as productsPage from "../pages/productsPage";
import * as user from "../fixtures/user.json";

describe('Swag Labs transaction tests', () => {

    it('should have 6 items on the inventory page', function () {
        cy.cookieLogin(user.userName);

        cy.location().its('pathname').should('equal', productsPage.elements.path);
        cy.get(header.elements.subHeader).should('contain.text', productsPage.elements.productTitle);
        cy.get(header.elements.cart).should('be.visible');
        cy.get(productsPage.elements.item).its('length').should('eq', 6);
    });

    it('should complete the purchase process of an item from the inventory', function () {
        cy.cookieLogin(user.userName);

        cy.get(productsPage.elements.itemBikeLight).click();
        cy.get(productsPage.elements.shoppingCartBadge).should('contain.text', '1');

        cy.get(productsPage.elements.shoppingCart).click();
        cy.get(header.elements.subHeader).should('contain.text', cart.elements.cartHeaderTitle);

        cy.get(cart.elements.noOfItemsInCart).should('contain.text', '1');
        cy.get(cart.elements.itemName).should('contain.text', 'Sauce Labs Bike Light');
        cy.get(cart.elements.itemPrice).should('contain.text', '$9.99');
        cy.get(cart.elements.checkoutButton).click();
        
        cy.get(header.elements.subHeader).should('contain.text', checkout.elements.checkout1Title);

        cy.get(checkout.elements.firstName).type(user.firstName);
        cy.get(checkout.elements.lastName).type(user.lastName);
        cy.get(checkout.elements.postalCode).type(user.postalCode);
        cy.get(checkout.elements.continueButton).contains('Continue').click();

        cy.get(header.elements.subHeader).should('contain.text', checkout.elements.checkout2Title);

        cy.get(checkout.elements.subTotal).should('contain.text', '9.99');
        cy.get(checkout.elements.tax).should('contain.text', '0.80');
        cy.get(checkout.elements.summaryTotal).should('contain.text', '10.79');

        cy.get(checkout.elements.checkoutButton).contains('Finish').click();
        cy.get(header.elements.subHeader).should('contain.text', checkout.elements.checkoutCompleteTitle);
    })
})
