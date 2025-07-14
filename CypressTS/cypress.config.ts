import { defineConfig } from "cypress";

module.exports = defineConfig({
  e2e: {


    baseUrl: 'https://www.saucedemo.com',

    // viewport
    viewportWidth: 1000,
    viewportHeight: 660,

    // maximum wait time
    defaultCommandTimeout: 2000,
    responseTimeout: 1000,

    // for iFrame support, chrome browsers only
    chromeWebSecurity: false,

    // do not create videos
    video: false,

    // take screenshots on failure
    screenshotOnRunFailure: true,

    // enable 2 retries in run mode
    retries: {
      runMode: 2,
      openMode: 0,
    },

    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
