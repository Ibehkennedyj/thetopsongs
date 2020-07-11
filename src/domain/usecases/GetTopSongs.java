package domain.usecases;

import domain.actions.db.FindSongs;
import domain.models.Artist;
import domain.models.Song;

import java.util.List;

import static domain.Constants.LIST_SIZE;
import static java.util.stream.Collectors.toList;

public class GetTopSongs {

    FindSongs songs;

    List<Song> getTopSongs(Artist artist) {
        return songs.find(artist)
                .stream()
                .sorted()
                .limit(LIST_SIZE)
                .collect(toList());
    }
}
