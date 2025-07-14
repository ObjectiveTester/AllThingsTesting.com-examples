import * as loginPage from "../pages/loginPage";
import * as header from "../pages/header";
import * as productsPage from "../pages/productsPage";
import * as user from "../fixtures/user.json";

describe('Swag Labs login tests', () => {

    it('should fail with invalid credentials', function () {
        cy.visit('');
        cy.title().should('eq', loginPage.elements.pageTitle);

        cy.get(loginPage.elements.userName).type(user.userName);
        cy.get(loginPage.elements.loginButton).click();

        cy.get(loginPage.elements.errorMessage).should('be.visible').and('contain.text', loginPage.elements.passwordError);
    });

    it('should login with valid credentials', function () {
        cy.visit('');
        cy.get(loginPage.elements.userName).type(user.userName);
        cy.get(loginPage.elements.passWord).type(user.userPassword);
        cy.get(loginPage.elements.loginButton).click();

        cy.location().its('pathname').should('equal', productsPage.elements.path);
        cy.get(header.elements.subHeader).should('contain.text', productsPage.elements.productTitle);
        cy.get(header.elements.cart).should('be.visible');
    });

})
