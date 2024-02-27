package com.github.shymega.java.tito_sdk.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.shymega.java.tito_sdk.domain.TitoApiBaseModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Client {
    // API token for Tito API
    protected static String API_TOKEN = null;
    // ObjectMapper for JSON serialization/deserialization
    protected final ObjectMapper OBJ_MAPPER = new ObjectMapper();
    // HttpClient for making HTTP requests
    protected final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    // Base URL for Tito API, can be changed if needed
    protected URI HTTP_BASE_URL = null;
    // Default HttpRequest with common headers
    protected HttpRequest.Builder HTTP_REQUEST = HttpRequest.newBuilder()
            .header("Content-Type", "application/json")
            .header("Accept", "application/json")
            .header("User-Agent", "Tito Java SDk");


    protected Client(final Endpoint endpoint, final String apiToken) {
        API_TOKEN = apiToken;
        this.HTTP_BASE_URL = URI.create(endpoint.getValue());
        this.HTTP_REQUEST = HTTP_REQUEST.header("Authorization", "Token token=" + API_TOKEN);
    }

    protected URL addToUrl(final URL baseUrl, final String extraPath) throws MalformedURLException, URISyntaxException {
        URI uri = baseUrl.toURI();
        if (uri.getPath().endsWith("/") && extraPath.startsWith("/")) {
            String newPath = uri.getPath() + extraPath.substring(1);
            return new URL(uri.getScheme(), uri.getHost(), uri.getPort(), newPath);
        } else if (!uri.getPath().endsWith("/") && !extraPath.startsWith("/")) {
            String newPath = uri.getPath() + "/" + extraPath;
            return new URL(uri.getScheme(), uri.getHost(), uri.getPort(), newPath);
        }
        return new URL(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath() + extraPath);

    }

    protected <T extends TitoApiBaseModel> T newRequestToPojo(final HttpRequest request, final Class<T> clazz) throws IOException, InterruptedException {
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        T pojo = deserialize(response.body(), clazz);
        assert pojo != null;

        pojo.httpStatusCode = response.statusCode();

        return deserialize(response.body(), clazz);
    }

    /**
     * Method for deserializing JSON into an object of a given class.
     *
     * @param json  JSON string to be deserialized
     * @param clazz Class of the object to be created
     * @return Object of the given class
     * @throws RuntimeException if deserialization fails
     */
    protected <T extends TitoApiBaseModel> T deserialize(final String json, final Class<T> clazz) {
        try {
            return OBJ_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for serializing an object into a JSON string.
     *
     * @param object Object to be serialized
     * @return JSON string
     * @throws RuntimeException if serialization fails
     */
    protected String serialize(final Object object) {
        try {
            return OBJ_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
