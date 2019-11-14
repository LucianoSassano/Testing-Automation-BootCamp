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

public class CapabilitiesLoaderException extends RuntimeException {

    private static final String MESSAGE = "Unable to load capability file '%s'.";

    public CapabilitiesLoaderException(String file) {
        super(format(MESSAGE, file));
    }
}
