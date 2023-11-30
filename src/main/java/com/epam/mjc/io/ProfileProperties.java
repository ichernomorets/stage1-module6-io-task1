package com.epam.mjc.io;

import java.util.HashMap;
import java.util.Map;

public class ProfileProperties {

    private final Map<String, String> properties;

    public ProfileProperties() {
        properties = new HashMap<>();
    }

    public void put(String name, String value) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }

        properties.put(name, value);
    }

    public String getString(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        return properties.get(name);
    }

    public Integer getInteger(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        String value = properties.get(name);

        return value != null ? Integer.parseInt(value) : null;
    }

    public Long getLong(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        String value = properties.get(name);

        return value != null ? Long.parseLong(value) : null;
    }

}
