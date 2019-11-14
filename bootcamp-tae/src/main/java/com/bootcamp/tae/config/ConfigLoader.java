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

package com.bootcamp.tae.config;

import com.bootcamp.tae.browser.Browsers;
import com.bootcamp.tae.exceptions.ConfigLoaderException;
import com.bootcamp.tae.logger.Loggeable;
import com.bootcamp.tae.platform.Platform;

import java.util.Optional;

import static com.bootcamp.tae.browser.Browsers.CHROME;
import static com.bootcamp.tae.platform.Platform.WEB;
import static com.bootcamp.tae.utils.FileUtils.loadFromFile;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;

public enum ConfigLoader implements Loggeable {

    CONFIG;

    private static final String ENVIRONMENT = "environment";
    private static final String PLATFORM = "platform";
    private static final String BROWSER = "browser";
    private static final String DEFAULT_ENVIRONMENT = "qa";

    private Config config;

    ConfigLoader() {
        String file = getEnvironment();
        Optional<Config> config = loadFromFile(file, Config.class);
        if (config.isPresent()) {
            info("Initializing framework config ...");
            this.config = config.get();
        } else {
            throw new ConfigLoaderException(file);
        }
    }

    public Config get() {
        return config;
    }

    public String getBaseURL() {
        return get().getBaseURL();
    }

    public String getRemoteServerURL() {
        return get().getRemoteServerURL();
    }

    public String getAppiumURL() {
        return get().getAppiumURL();
    }

    public Integer getImplicitWait() {
        return get().getImplicitWait();
    }

    public Integer getExplicitWait() {
        return get().getExplicitWait();
    }

    public Integer getPollingEvery() {
        return get().getPollingEvery();
    }

    public Integer getPageLoadTimeout() {
        return get().getPageLoadTimeout();
    }

    public Integer getScriptTimeout() {
        return get().getScriptTimeout();
    }

    public String getEnvironment() {
        return get(ENVIRONMENT) == null ? DEFAULT_ENVIRONMENT : get(ENVIRONMENT);
    }

    public Platform getPlatform() {
        return get(PLATFORM) == null ? WEB : Platform.valueOf(get(PLATFORM).toUpperCase());
    }

    public Browsers getBrowser() {
        return get(BROWSER) == null ? CHROME : Browsers.valueOf(get(BROWSER).toUpperCase());
    }

    private String get(String key) {
        String environment = getProperty(key);
        if (environment == null) {
            environment = getenv(key);
        }
        return environment;
    }
}
