// e2e/pages/productsPage.ts
import { PageObjectModel, EnhancedPageObject } from 'nightwatch'

const productsPageCommands = {
    loginWithCookie(username: string) {
        var future = Date.now() + 300000;
        browser.cookies.set({
            name: 'session-username',
            value: username.toString(),
            path: '/',
            domain: 'www.saucedemo.com',
            secure: false,
            httpOnly: false,
            expiry: future
        })
    }
};

const productsPage = {
    url: 'https://www.saucedemo.com/inventory.html',
    commands: [productsPageCommands],
    elements: {
        shoppingCart: {
            selector: '.shopping_cart_container',
        },
        item: {
            selector: '.inventory_item',
        },
        itemName: {
            selector: '.inventory_item_name',
        },
        shoppingCartBadge: {
            selector: '.shopping_cart_badge',
        },
        filter: {
            selector: '.product_sort_container',
        },
        itemPrice: {
            selector: '.inventory_item_price',
        },
        itemBackpack: {
            selector: '#add-to-cart-sauce-labs-backpack',
        },
        itemBikeLight: {
            selector: '#add-to-cart-sauce-labs-bike-light',
        }
    },
    props: {
        productTitle: 'Products',
        path: '/inventory.html'
    },
} satisfies PageObjectModel;

export interface productsPage extends EnhancedPageObject<typeof productsPageCommands, typeof productsPage> { }

export default productsPage;