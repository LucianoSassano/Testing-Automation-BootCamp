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

package com.bootcamp.tae.browser;

import org.openqa.selenium.Capabilities;

/**
 * GetCapabilities represents a contract for any new Browser to be supported.
 */
public interface GetCapabilities {

    /**
     * Gets capabilities.
     *
     * @return the {@link Capabilities}
     */
    Capabilities getCapabilities();

}
