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

package com.bootcamp.tae.testsuite;

import com.bootcamp.tae.logger.Loggeable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.net.MalformedURLException;

import static com.bootcamp.tae.config.ConfigLoader.CONFIG;
import static com.bootcamp.tae.driver.Drivers.dispose;
import static com.bootcamp.tae.driver.Drivers.populateDriver;
import static com.bootcamp.tae.platform.Platform.WEB;
import static com.bootcamp.tae.server.SeleniumStandaloneServer.SERVER;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * BaseTestSuite represents the base suite for all the test suites in the test automation project.
 * A new suite should inherit BaseTestSuite functionality.
 */
public abstract class BaseTestSuite implements Loggeable {

    @BeforeClass
    public static void beforeClass() {
        if (WEB.equals(CONFIG.getPlatform())) {
            SERVER.start();
        }
    }

    @AfterClass
    public static void afterClass() {
        if (WEB.equals(CONFIG.getPlatform())) {
            SERVER.stop();
        }
    }

    @Before
    public void before() {
        try {
            populateDriver(CONFIG.getPlatform(), CONFIG.getBrowser());
        } catch (MalformedURLException e) {
            fail("Unable to populate an instance of the required driver, please check log and  configuration.");
        }
    }

    @After
    public void after() {
        dispose();
    }

    /**
     * Checks for the equality of two Strings.
     *
     * @param expected the expected String
     * @param actual   the actual String
     */
    protected void checkEquals(String expected, String actual) {
        assertEquals(format("Error: Expected '%s', but was '%s'", expected, actual), expected, actual);
    }

}
