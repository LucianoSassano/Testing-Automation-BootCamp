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

public class Config {

    private String baseURL;

    private String remoteServerURL;

    private String appiumURL;

    private Integer implicitWait;

    private Integer explicitWait;

    private Integer pollingEvery;

    private Integer pageLoadTimeout;

    private Integer scriptTimeout;

    public String getBaseURL() {
        return baseURL;
    }

    public String getRemoteServerURL() {
        return remoteServerURL;
    }

    public String getAppiumURL() {
        return appiumURL;
    }

    public Integer getImplicitWait() {
        return implicitWait;
    }

    public Integer getExplicitWait() {
        return explicitWait;
    }

    public Integer getPollingEvery() {
        return pollingEvery;
    }

    public Integer getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public Integer getScriptTimeout() {
        return scriptTimeout;
    }

    @Override
    public String toString() {
        return "Config{" +
                "baseURL='" + baseURL + '\'' +
                ", remoteServerURL='" + remoteServerURL + '\'' +
                ", appiumURL='" + appiumURL + '\'' +
                ", implicitWait=" + implicitWait +
                ", explicitWait=" + explicitWait +
                ", pollingEvery=" + pollingEvery +
                ", pageLoadTimeout=" + pageLoadTimeout +
                ", scriptTimeout=" + scriptTimeout +
                '}';
    }
}
