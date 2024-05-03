package com.github.shymega.java.tito_sdk.domain.admin.v3_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LookupMode {
    LIVE("LIVE"),
    TEST("TEST");

    private final String lookupMode;

    LookupMode(String lookupMode) {
        this.lookupMode = lookupMode;
    }

    @JsonCreator
    public static LookupMode fromString(String lookupMode) {
        return lookupMode == null
                ? null
                : LookupMode.valueOf(lookupMode.toUpperCase());
    }

    @JsonValue
    public String getLookupMode() {
        return lookupMode.toUpperCase();
    }
}
