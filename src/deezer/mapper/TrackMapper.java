package deezer.mapper;

import deezer.model.Track;

import javax.json.JsonObject;
import javax.json.JsonValue;
import java.util.Collection;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class TrackMapper {

    public Collection<Track> from(JsonObject response) {
        return response.getJsonArray("data")
                .stream()
                .map(JsonValue::asJsonObject)
                .map(Track::from)
                .collect(toUnmodifiableSet());
    }
}
