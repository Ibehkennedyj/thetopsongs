package deezer.component;

import java.net.http.HttpRequest;

import static java.lang.String.format;
import static java.net.URI.create;
import static java.net.URLEncoder.encode;
import static java.net.http.HttpRequest.newBuilder;
import static java.nio.charset.StandardCharsets.UTF_8;

public class SearchRequestBuilder {
    private static final String SEARCH_ENDPOINT = "https://api.deezer.com/search";

    public static HttpRequest buildRequest(String query) {
        return newBuilder(
                create(format("%s?q=%s", SEARCH_ENDPOINT, encode(format("%s", removeBlacklistedChars(query)), UTF_8)))
        ).build();
    }

    private static String removeBlacklistedChars(String query) {
        final String blacklistedCharsRegex = "[\":\\\\]";
        return query.replaceAll(blacklistedCharsRegex, "").trim();
    }
}
