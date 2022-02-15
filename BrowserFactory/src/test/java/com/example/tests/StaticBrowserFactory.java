package com.example.tests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class StaticBrowserFactory {

    private static WebDriver browserObject;
    private static URL gridAddress;

    public static enum browserType {
        FIREFOX, CHROME, SAFARI, EDGE
    }

    public static final WebDriver buildBrowser() {

        String browser = System.getProperty("browser", "").toLowerCase();
        switch (browser) {

            case "firefox":
                browserObject = StaticBrowserFactory.buildBrowser(browserType.FIREFOX);
                break;

            case "safari":
                browserObject = StaticBrowserFactory.buildBrowser(browserType.SAFARI);
                break;

            case "edge":
                browserObject = StaticBrowserFactory.buildBrowser(browserType.EDGE);
                break;

            default:
                browserObject = StaticBrowserFactory.buildBrowser(browserType.CHROME);
                break;
        }

        return browserObject;
    }

    public static final WebDriver buildBrowser(browserType name) {
        MutableCapabilities options = null;
        String gridProperty = System.getProperty("grid", "");
        try {
            gridAddress = new URL(gridProperty);
        } catch (MalformedURLException e) {
        }

        String platform = System.getProperty("platform", "");
        String version = System.getProperty("version", "");

        switch (name) {

            case CHROME:
                options = new ChromeOptions();
                break;

            case FIREFOX:
                options = new FirefoxOptions();
                break;

            case SAFARI:
                options = new SafariOptions();
                break;

            case EDGE:
                options = new EdgeOptions();
                break;
        }

        if (!version.isBlank()) {
            options.setCapability(CapabilityType.BROWSER_VERSION, version);
        }

        if (!platform.isBlank()) {
            options.setCapability(CapabilityType.PLATFORM_NAME, platform);
        }

        if (gridAddress != null) {
            browserObject = RemoteWebDriver.builder().oneOf(options).address(gridAddress).build();
        } else {
            browserObject = RemoteWebDriver.builder().oneOf(options).build();
        }

        return browserObject;
    }

}
