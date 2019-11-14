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

package com.bootcamp.tae.page;

import org.openqa.selenium.WebElement;

import static com.bootcamp.tae.driver.Drivers.getDriver;
import static java.util.stream.Stream.of;

public abstract class CommonOperations extends WaitOperations {

    /**
     * Navigates back.
     */
    protected void back() {
        getDriver().getWebDriver().navigate().back();
    }

    /**
     * Clicks on the element.
     *
     * @param webElement the {@link WebElement}
     */
    protected void click(WebElement webElement) {
        isClickable(webElement);
        webElement.click();
    }

    /**
     * Gets the text from the web element.
     *
     * @param webElement the {@link WebElement}
     * @return the text
     */
    protected String getText(WebElement webElement) {
        isVisible(webElement);
        return webElement.getText();
    }

    /**
     * Verifies if the WebElement's text matches all the criteria.
     *
     * @param webElement the {@link WebElement}
     * @param texts      the expected texts
     * @return {@code TRUE} if WebElement's text matches the criteria
     */
    protected boolean match(WebElement webElement, String... texts) {
        return of(texts).allMatch(text -> getText(webElement).toLowerCase().contains(text.toLowerCase()));
    }

}
