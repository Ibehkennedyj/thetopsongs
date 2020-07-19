
package deezer.handler;

import deezer.model.Response;
import lombok.RequiredArgsConstructor;

import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;

import static deezer.model.Response.of;
import static java.net.http.HttpResponse.BodyHandlers.ofInputStream;
import static javax.json.Json.createReader;

@RequiredArgsConstructor
public class RequestHandler {

    private final HttpClient client;

    public Response processRequest(HttpRequest request) throws InterruptedException, ExecutionException {
        var body = client.sendAsync(request, ofInputStream())
                .thenApply(HttpResponse::body)
                .thenApply(this::toJson)
                .get();
        return of(body);
    }

    private JsonObject toJson(InputStream s) {
        try (JsonReader reader = createReader(s)) {
            return reader.readObject();
        }
    }
}
