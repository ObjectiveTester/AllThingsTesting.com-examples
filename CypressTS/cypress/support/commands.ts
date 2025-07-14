// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

declare global {
    namespace Cypress {
        interface Chainable<Subject = any> {
            /**
             * Logs in a user by setting a session cookie and navigating to the inventory page.
             * @param username - The username of the user to log in.
             */
            cookieLogin(username: string): Chainable<void>;

            /**
             * Yields the body element of an iframe.
             * @param subject - The iframe element.
             */
            iframe(): Chainable<JQuery<HTMLBodyElement>>;
        }
    }
}

/**
 * Logs in a user by setting a session cookie and navigating to the inventory page.
 * @param username - The username of the user to log in.
 */
Cypress.Commands.add('cookieLogin', (username: string) => {
    cy.setCookie("session-username", username)
        .visit('/inventory.html', { failOnStatusCode: false })
        .location().its('pathname').should('equal', '/inventory.html');
});

/**
 * Yields the body element of an iframe.
 * example: cy.get('[name="dynamic"]').iframe().find('[type="submit"]').click();
 */
Cypress.Commands.add('iframe' as any, { prevSubject: 'element' }, ($frame) => {
    return new Cypress.Promise((resolve, reject) => {
        try {
            const body = $frame.contents().find("body");
            if (body.length === 0) {
                throw new Error("Body element not found in the iframe.");
            }
            resolve(body);
        } catch (error) {
            reject(error);
        }
    });
});

export { };