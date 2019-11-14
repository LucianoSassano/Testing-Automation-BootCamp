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

package com.bootcamp.tae.page.mobile;

import com.bootcamp.tae.page.CommonOperations;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import static com.bootcamp.tae.driver.Drivers.getDriver;

public abstract class MobileOperations extends CommonOperations {

    /**
     * Types on the element.
     *
     * @param mobileElement the {@link MobileElement}
     * @param text          the text
     */
    protected void type(MobileElement mobileElement, String text) {
        isClickable(mobileElement);
        mobileElement.setValue(text);
    }

    /**
     * Tap on element.
     *
     * @param mobileElement the {@link MobileElement}
     */
    protected void tap(MobileElement mobileElement) {
        isClickable(mobileElement);
        touchActions().singleTap(mobileElement);
    }

    private TouchActions touchActions() {
        return new TouchActions(getDriver().getWebDriver());
    }

}
