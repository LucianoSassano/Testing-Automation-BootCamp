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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.bootcamp.tae.driver.Drivers.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.or;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public abstract class WaitOperations {

    /**
     * Verifies if an element is clickable before clicking on it.
     *
     * @param webElement the {@link WebElement}
     * @return the {@link WebElement}
     */
    protected boolean isClickable(WebElement webElement) {
        return waiting().until(elementToBeClickable(webElement)).isEnabled();
    }

    /**
     * Verifies if an element is visible before interacting with it.
     *
     * @param webElement the {@link WebElement}
     * @return the {@link WebElement}
     */
    protected boolean isVisible(WebElement webElement) {
        return waiting().until(visibilityOf(webElement)).isDisplayed();
    }

    /**
     * Verifies if all elements are visible before interacting with it.
     *
     * @param webElements a {@link List} of {@link WebElement}
     * @return the list of elements
     */
    protected boolean areVisible(List<WebElement> webElements) {
        return waiting().until(visibilityOfAllElements(webElements)).stream().allMatch(element -> element.isDisplayed());
    }

    /**
     * Verifies if the expected text is present in the element.
     *
     * @param webElement the {@link WebElement}
     * @param text       the expected text
     * @return {@code TRUE} if the text is present
     */
    protected boolean isTextPresent(WebElement webElement, String text) {
        return waiting().until(or(textToBePresentInElement(webElement, text), textToBePresentInElementValue(webElement, text)));
    }

    private WebDriverWait waiting() {
        return getDriver().getWebDriverWait();
    }
}
