// e2e/pages/loginPage.ts
import { PageObjectModel, EnhancedPageObject } from 'nightwatch'

const loginPage = {
    url: 'https://saucedemo.com',
    elements: {
        userName: {
            selector: '[data-test=username]',
        },
        password: {
            selector: '[data-test=password]',
        },
        loginButton: {
            selector: '#login-button',
        },
        errorMessage: {
            selector: '[data-test=error]',
        }
    },
    props: {
        usernameError: 'Username is required',
        passwordError: 'Password is required',
        incorrectError: 'Username and password do not match any user in this service',
        pageTitle: 'Swag Labs'
    },
} satisfies PageObjectModel;

export interface loginPage extends EnhancedPageObject<typeof loginPage> { }

export default loginPage;
