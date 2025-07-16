// e2e/pages/cartPage.ts
import { PageObjectModel, EnhancedPageObject } from 'nightwatch'

const cartPage = {
    elements: {
        noOfItemsInCart: {
            selector: '.cart_quantity',
        },
        itemPrice: {
            selector: '.inventory_item_price',
        },
        itemName: {
            selector: '.inventory_item_name',
        },
        checkoutButton: {
            selector: '.btn_action',
        }
    },
    props: {
        cartHeaderTitle: 'Your Cart'
    },
} satisfies PageObjectModel;

export interface CartPage extends EnhancedPageObject<typeof cartPage.elements> { }

export default cartPage;