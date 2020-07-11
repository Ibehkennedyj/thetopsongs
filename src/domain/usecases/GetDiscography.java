package domain.usecases;

import domain.actions.ext.GetAllSongs;
import domain.component.SongVerifier;
import domain.models.Artist;
import domain.models.Song;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class GetDiscography {

    GetAllSongs songs;
    SongVerifier verify;

    private Set<Song> getAllSongs(Artist artist) {
        return songs.getAllSongs(artist)
                .stream()
                .filter(verify::isOriginal)
                .collect(toSet());
    }
}
