/*
 * Copyright (c) 2019, Damián Emilio Moga. All rights reserved.
 * Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.bootcamp.tae.driver;

import com.bootcamp.tae.browser.Browsers;
import com.bootcamp.tae.platform.Platform;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.bootcamp.tae.config.ConfigLoader.CONFIG;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Driver is the container of the {@link WebDriver} instance and the {@link Platform} information.
 */
public final class Driver {

    private Platform platform;

    private Browsers browsers;

    private WebDriver webDriver;

    private WebDriverWait webDriverWait;

    /**
     * Default constructor.
     *
     * @param platform  the {@link Platform}
     * @param browsers  the {@link Browsers}
     * @param webDriver the {@link WebDriver}
     */
    public Driver(Platform platform, Browsers browsers, WebDriver webDriver) {
        this.platform = platform;
        this.browsers = browsers;
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, CONFIG.getExplicitWait());
        webDriverWait
                .pollingEvery(Duration.of(CONFIG.getPollingEvery(), SECONDS))
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NotFoundException.class);
    }

    public Platform getPlatform() {
        return platform;
    }

    public Browsers getBrowsers() {
        return browsers;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
