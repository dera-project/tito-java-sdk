package com.github.shymega.java.tito_sdk.client;

import lombok.Getter;

@Getter
public enum Endpoint {
    ADMIN_3_0("https://api.tito.io/v3/"),
    ADMIN_3_1("https://api.tito.io/v3/"),
    CHECK_IN("https://checkin.tito.io/");

    private final String value;

    Endpoint(final String value) {
        this.value = value;
    }

    public String toString() {
        return this.getValue();
    }
}