// e2e/pages/header.ts
import { PageObjectModel, EnhancedPageObject } from 'nightwatch'

const header = {

    elements: {
        burger: {
            selector: '.react-gurger-menu-btn',
        },
        cart: {
            selector: '#shopping_cart_container',
        },
        subHeader: {
            selector: '.header_secondary_container .title',
        }
    }
} satisfies PageObjectModel;

export interface header extends EnhancedPageObject<typeof header> { }

export default header;