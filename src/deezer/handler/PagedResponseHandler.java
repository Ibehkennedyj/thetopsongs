package deezer.handler;

import deezer.model.Response;
import lombok.RequiredArgsConstructor;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.List.of;

@RequiredArgsConstructor
public class PagedResponseHandler {

    private final HttpRequest initialRequest;
    private final RequestHandler handler;

    public List<Response> gather() {
        return gather(new ArrayList<>(), initialRequest, handler);
    }

    public List<Response> gather(List<Response> bucket, HttpRequest initialRequest, RequestHandler handler) {
        try {
            var response = handler.processRequest(initialRequest);
            bucket.add(response);
            response.getNextPage().ifPresent(nextRequest -> gather(bucket, nextRequest, handler));
            return bucket;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return of();
        }
    }
}
