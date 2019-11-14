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

package com.bootcamp.tae.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import static java.lang.Thread.currentThread;
import static java.util.Optional.empty;

public final class FileUtils {

    public static <T> Optional<T> loadFromFile(String file, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            InputStream input = currentThread().getContextClassLoader().getResourceAsStream(file + ".yml");
            T obj = objectMapper.readValue(input, clazz);
            return Optional.of(obj);
        } catch (IOException e) {
            return empty();
        }
    }
}
