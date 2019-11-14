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

package com.bootcamp.tae.server;

import com.bootcamp.tae.logger.Loggeable;
import org.openqa.grid.internal.utils.configuration.StandaloneConfiguration;
import org.openqa.selenium.remote.server.SeleniumServer;

import java.util.logging.LogManager;

import static java.lang.Runtime.getRuntime;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.OFF;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * SeleniumStandaloneServer makes possible to start and stop a selenium standalone server instance.
 */
public enum SeleniumStandaloneServer implements Loggeable {

    SERVER;

    private SeleniumServer seleniumServer;

    private boolean notStarted = true;

    /**
     * Starts the {@link SeleniumServer} using the standalone configuration.
     */
    public void start() {
        if (notStarted) {
            seleniumServer = new SeleniumServer(new StandaloneConfiguration());
            getRuntime().addShutdownHook(new Thread(this::stop));

            seleniumServer.boot();
            info("Initializing local Selenium Server Standalone ...");

            notStarted = false;
        }
        warn("Selenium server is already started.");
    }

    /**
     * Stops the {@link SeleniumServer}.
     */
    public void stop() {
        seleniumServer.stop();
        notStarted = true;
    }

}
