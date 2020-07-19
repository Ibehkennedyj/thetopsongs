package deezer;

import deezer.action.GetTracks;
import deezer.handler.PagedResponseHandler;
import deezer.handler.RequestHandler;
import deezer.mapper.TrackMapper;
import deezer.model.Response;
import deezer.model.Track;
import lombok.RequiredArgsConstructor;

import java.net.http.HttpClient;
import java.util.Collection;
import java.util.Set;

import static deezer.component.SearchRequestBuilder.buildRequest;
import static java.util.stream.Collectors.toSet;


@RequiredArgsConstructor
public class DeezerTrackService implements GetTracks {

    private final HttpClient client;

    public Set<Track> getTracks(String artist) {
        var tracks = new TrackMapper();

        return new PagedResponseHandler(buildRequest(artist), new RequestHandler(client))
                .gather()
                .stream()
                .filter(Response::isSuccessful)
                .map(Response::getBody)
                .map(tracks::from)
                .flatMap(Collection::stream)
                .collect(toSet());
    }
}
