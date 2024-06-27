package com.github.shymega.java.tito_sdk;

import com.github.shymega.java.tito_sdk.client.*;

public final class ClientFactory {
    @SuppressWarnings({"unchecked"})
    public static <T extends Client> T getClient(final Endpoint endpoint, final String apiToken) {
        if (endpoint == null) throw new IllegalArgumentException("Endpoint variant null. Pass a valid variant.");
        if (apiToken == null || apiToken.isEmpty())
            throw new IllegalArgumentException("API token null or empty. Pass a valid API token.");

        return (T) switch (endpoint) {
            case ADMIN_3_0 -> new TitoAdmin30Client(endpoint, apiToken);
            case ADMIN_3_1 -> new TitoAdmin31Client(endpoint, apiToken);
            case CHECK_IN -> new TitoCheckInClient(endpoint, apiToken);
        };
    }

}
