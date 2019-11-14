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

package com.bootcamp.tae.page.web;

import com.bootcamp.tae.driver.Driver;

import static com.bootcamp.tae.driver.Drivers.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebPage extends WebOperations {

    protected WebPage() {
        Driver driver = getDriver();
        initElements(driver.getWebDriver(), this);
    }

}
