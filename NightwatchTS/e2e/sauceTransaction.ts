describe('Swag Labs transaction tests', function () {
    const header = browser.page.header();
    const productsPage = browser.page.productsPage();
    const cartPage = browser.page.cartPage();
    const checkoutPage = browser.page.checkoutPage();

  it('should have 6 items on the inventory page', function () {
    productsPage.navigate();
    productsPage.loginWithCookie([browser.globals.userName]);
    productsPage.navigate();

    productsPage.assert.urlContains(productsPage.props.path);
    header.expect.element('@subHeader').text.to.contain(productsPage.props.productTitle);
    header.assert.visible('@cart');
    productsPage.expect.elements('@item').count.to.equal(6);
  });

  it('should complete the purchase process of an item from the inventory', function () {
    productsPage.navigate();
    productsPage.loginWithCookie([browser.globals.userName]);
    productsPage.navigate();

    productsPage.click('@itemBikeLight');
    productsPage.expect.element('@shoppingCartBadge').text.to.contain('1');

    productsPage.click('@shoppingCart');
    header.expect.element('@subHeader').text.to.contain(cartPage.props.cartHeaderTitle);

    cartPage.expect.element('@noOfItemsInCart').text.to.contain('1');
    cartPage.expect.element('@itemName').text.to.contain('Sauce Labs Bike Light');
    cartPage.expect.element('@itemPrice').text.to.contain('$9.99');
    cartPage.element('@checkoutButton').click();
 
    header.expect.element('@subHeader').text.to.contain(checkoutPage.props.checkout1Title);

    checkoutPage.element('@firstName').sendKeys(browser.globals.firstName);
    checkoutPage.element('@lastName').sendKeys(browser.globals.lastName);
    checkoutPage.element('@postalCode').sendKeys(browser.globals.postalCode);
    checkoutPage.element('@continueButton').click();

    header.expect.element('@subHeader').text.to.contain(checkoutPage.props.checkout2Title);

    checkoutPage.expect.element('@subTotal').text.to.contain('9.99');
    checkoutPage.expect.element('@tax').text.to.contain('0.80');
    checkoutPage.expect.element('@summaryTotal').text.to.contain('10.79');

    checkoutPage.element('@checkoutButton').click();
    header.expect.element('@subHeader').text.to.contain(checkoutPage.props.checkoutCompleteTitle);
  });

});