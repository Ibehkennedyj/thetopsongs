package domain.usecases;

import domain.actions.ext.GetAllSongs;
import domain.component.SongVerifier;
import domain.models.Artist;
import domain.models.Song;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetDiscography {

    GetAllSongs songs;
    SongVerifier verify;

    public List<Song> getAllSongs(Artist artist) {
        return songs.getAllSongs(artist)
                .stream()
                .filter(verify::isOriginal)
                .collect(toList());
    }
}
