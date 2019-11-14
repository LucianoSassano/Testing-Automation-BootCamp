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
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;

import static com.bootcamp.tae.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobilePage extends CommonOperations {

    protected MobilePage() {
        WebDriver webDriver = getDriver().getWebDriver();
        initElements(new AppiumFieldDecorator(webDriver), this);
    }

}
