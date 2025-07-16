describe('Swag Labs login tests', function () {
  const loginPage = browser.page.loginPage();
  const header = browser.page.header();
  const productsPage = browser.page.productsPage();

  it('should fail with invalid credentials', function () {
    loginPage.navigate();
    loginPage.assert.titleContains(loginPage.props.pageTitle);
    
    loginPage
      .sendKeys('@userName', [browser.globals.userName])
      .click('@loginButton');

    loginPage.assert.visible('@errorMessage');
    loginPage.expect.element('@errorMessage').text.to.contain(loginPage.props.passwordError);
  });

  it('should login with valid credentials', function () {
    loginPage.navigate();
    loginPage.assert.titleContains(loginPage.props.pageTitle);
    
    loginPage
      .sendKeys('@userName', [browser.globals.userName])
      .sendKeys('@password', [browser.globals.userPassword])
      .click('@loginButton');

    productsPage.assert.urlContains(productsPage.props.path);
    header.expect.element('@subHeader').text.to.contain(productsPage.props.productTitle);
    header.assert.visible('@cart');
  });

});