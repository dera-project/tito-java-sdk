package com.github.shymega.java.tito_sdk.client;

import com.github.shymega.java.tito_sdk.domain.admin.v3_0.HelloResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public final class TitoAdmin30Client extends Client {
    public TitoAdmin30Client(final Endpoint endpoint, final String apiToken) {
        super(endpoint, apiToken);
    }

    public HelloResponse hello() throws IOException, InterruptedException, URISyntaxException {
        System.out.println(super.HTTP_BASE_URL);
        System.out.println(super.HTTP_BASE_URL.resolve("/hello"));
        HttpRequest request = super.HTTP_REQUEST
                .uri(super.addToUrl(super.HTTP_BASE_URL.toURL(), "/hello").toURI())
                .GET()
                .build();
        return this.newRequestToPojo(request, HelloResponse.class);
    }
}
