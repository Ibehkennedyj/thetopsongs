package deezer.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.json.JsonObject;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Value
@AllArgsConstructor
public class Response {

    public JsonObject body;
    public boolean hasError;
    public String nextPage;

    public static Response of(JsonObject body) {
        boolean hasError = body.containsKey("error");
        String key = "next";
        var nextPage = body.containsKey(key) ? body.getString(key) : null;
        return new Response(body, hasError, nextPage);
    }

    public Optional<HttpRequest> getNextPage() {
        return ofNullable(nextPage)
                .map(URI::create)
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build);
    }

    public boolean isSuccessful() {
        return !hasError;
    }
}
