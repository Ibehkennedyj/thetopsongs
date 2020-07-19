package deezer.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.json.JsonObject;

@Data
@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class Track {

    private final String title;
    private final String artist;
    private final String album;

    public static Track from(JsonObject json) {
        return Track.builder()
                .title(json.getString("title"))
                .artist(json.getJsonObject("artist").getString("name"))
                .album(json.getJsonObject("album").getString("title"))
                .build();
    }

}
