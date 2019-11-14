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

package com.bootcamp.tae.exceptions;

import static java.lang.String.format;

public class ConfigLoaderException extends RuntimeException {

    private static final String MESSAGE = "Unable to load configuration file '%s'.";

    public ConfigLoaderException(String file) {
        super(format(MESSAGE, file));
    }
}
