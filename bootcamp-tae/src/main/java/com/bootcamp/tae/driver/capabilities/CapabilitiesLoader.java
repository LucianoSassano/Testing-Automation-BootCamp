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

package com.bootcamp.tae.driver.capabilities;

import com.bootcamp.tae.exceptions.CapabilitiesLoaderException;
import com.bootcamp.tae.logger.Loggeable;

import java.util.Map;
import java.util.Optional;

import static com.bootcamp.tae.utils.FileUtils.loadFromFile;

/**
 * CapabilitiesLoader loads a set of optional capabilities (could be empty) specified in a YAML file per browser or device.
 */
public enum CapabilitiesLoader implements Loggeable {

    CAPABILITIES;

    /**
     * Reads capabilities from file.
     *
     * @param file the file name
     * @return a {@link Map} with the capabilities, key value pair
     */
    public Map<String, String> readCapabilities(String file) {
        Optional<Capabilities> capabilities = loadFromFile(file, Capabilities.class);
        if (capabilities.isPresent()) {
            info(String.format("Reading capabilities for '%s' ...", file));
            return capabilities.get().getCapabilities();
        } else {
            throw new CapabilitiesLoaderException(file);
        }
    }

}
