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
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bootcamp.tae.driver.capabilities.CapabilitiesLoader.CAPABILITIES;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.iedriver;
import static java.util.Collections.synchronizedList;
import static org.openqa.selenium.remote.DesiredCapabilities.iphone;

/**
 * Browsers supports the process of getting the capabilities per platform and browsers.
 *
 * It uses {@link io.github.bonigarcia.wdm.WebDriverManager} to download the required version of driver binary.
 */
public enum Browsers implements GetCapabilities {

    CHROME {
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(CHROME)) {
                chromedriver().setup();
                BINARY_DOWNLOADED.add(CHROME);
            }

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();

            Map<String, String> extraCapabilities = CAPABILITIES.readCapabilities("chrome");
            String[] arguments = String.valueOf(extraCapabilities.get(ARGUMENTS)).split(",");
            extraCapabilities.remove(ARGUMENTS);
            extraCapabilities.forEach((key, value) -> capabilities.setCapability(key, value));

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(capabilities);
            for (String argument : arguments) {
                chromeOptions.addArguments("--" + argument);
            }

            return chromeOptions;
        }
    },
    FIREFOX {
        @Override
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(FIREFOX)) {
                firefoxdriver().setup();
                BINARY_DOWNLOADED.add(FIREFOX);
            }

            return new FirefoxOptions();
        }
    },
    IE {
        @Override
        public Capabilities getCapabilities() {
            if (!BINARY_DOWNLOADED.contains(IE)) {
                iedriver().setup();
                BINARY_DOWNLOADED.add(IE);
            }

            return new InternetExplorerOptions();
        }
    },
    ANDROID {
        @Override
        public Capabilities getCapabilities() {
            MutableCapabilities capabilities = new MutableCapabilities();
            Map<String, String> extraCapabilities = CAPABILITIES.readCapabilities("android");
            extraCapabilities.forEach((key, value) -> capabilities.setCapability(key, value));
            return capabilities;
        }
    },
    IPHONE {
        @Override
        public Capabilities getCapabilities() {
            return iphone();
        }
    };

    private static final String ARGUMENTS = "arguments";

    private static final List<Browsers> BINARY_DOWNLOADED = synchronizedList(new ArrayList());

}
