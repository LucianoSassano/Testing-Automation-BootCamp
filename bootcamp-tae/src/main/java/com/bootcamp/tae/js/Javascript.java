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

package com.bootcamp.tae.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.bootcamp.tae.driver.Drivers.getDriver;

/**
 * Javascript.
 */
public final class Javascript {

    /**
     * Executes a click on the element by javascript.
     *
     * @param webElement the {@link WebElement}
     */
    public static void click(WebElement webElement) {
        js().executeScript("arguments[0].click();", webElement);
    }

    /**
     * Creates an javascript executor.
     *
     * @return the {@link JavascriptExecutor}
     */
    private static JavascriptExecutor js() {
        return (JavascriptExecutor) getDriver().getWebDriver();
    }


}
