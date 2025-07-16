// e2e/pages/checkoutPage.ts
import { PageObjectModel, EnhancedPageObject } from 'nightwatch'

const checkoutPage = {
    elements: {
        firstName: {
            selector: '[data-test=firstName]',
        },
        lastName: {
            selector: '[data-test=lastName]',
        },
        postalCode: {
            selector: '[data-test=postalCode]',
        },
        subTotal: {
            selector: '.summary_subtotal_label',
        },
        tax: {
            selector: '.summary_tax_label',
        },
        summaryTotal: {
            selector: '.summary_total_label',
        },
        continueButton: {
            selector: '#continue',
        },
        checkoutButton: {
            selector: '.btn_action',
        }
    },
    props: {
        checkout1Title: 'Checkout: Your Information',
        checkout2Title: 'Checkout: Overview',
        checkoutCompleteTitle: 'Checkout: Complete!',
    },
} satisfies PageObjectModel;


export interface CheckoutPage extends EnhancedPageObject<typeof checkoutPage.elements> { }

export default checkoutPage;