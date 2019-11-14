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

package com.bootcamp.tae.logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Loggeable supports logging operations.
 */
public interface Loggeable {

    /**
     * Logs a message at INFO level.
     *
     * @param message the message to be logged
     */
    default void info(String message) {
        getLogger(getClass()).info(message);
    }

    /**
     * Logs a message at DEBUG level.
     *
     * @param message the message to be logged
     */
    default void debug(String message) {
        getLogger(getClass()).debug(message);
    }

    /**
     * Logs a message at WARN level.
     *
     * @param message the message to be logged
     */
    default void warn(String message) {
        getLogger(getClass()).warn(message);
    }

    /**
     * Logs a message at ERROR level.
     *
     * @param message the message to be logged
     */
    default void error(String message) {
        getLogger(getClass()).error(message);
    }
}
