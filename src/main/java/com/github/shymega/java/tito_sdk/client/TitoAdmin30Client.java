package com.github.shymega.java.tito_sdk.client;

import com.github.shymega.java.tito_sdk.domain.admin.v3_0.HelloResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public final class TitoAdmin30Client extends Client {

    public TitoAdmin30Client(final Endpoint endpoint, final String apiToken) {
        super(endpoint, apiToken);
    }

    public HelloResponse hello() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest req = newHttpRequestBuilder(URI.create("/hello"), API_TOKEN)
                .GET()
                .build();

        return newRequestToPojo(req, HelloResponse.class);
    }
}
