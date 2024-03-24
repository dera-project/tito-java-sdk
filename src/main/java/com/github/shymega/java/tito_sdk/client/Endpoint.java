package com.github.shymega.java.tito_sdk.client;

import lombok.Getter;

@Getter
public enum Endpoint {
    ADMIN_3_0("https://api.tito.io/v3/") {
        @Override
        public Client getClient(final String apiToken) {
            return new TitoAdmin30Client(this, apiToken);
        }
    },
    ADMIN_3_1("https://api.tito.io/v3/") {
        @Override
        public Client getClient(final String apiToken) {
            return new TitoAdmin31Client(this, apiToken);
        }
    },

    CHECK_IN("https://checkin.tito.io/") {
        @Override
        public Client getClient(final String apiToken) {
            return new TitoCheckInClient(this, apiToken);
        }
    };

    private final String value;

    Endpoint(final String value) {
        this.value = value;
    }

    public String toString() {
        return this.getValue();
    }

    public abstract Client getClient(String apiToken);
}