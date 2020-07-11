package domain.actions.ext;

import domain.models.Artist;
import domain.models.Song;

import java.util.List;

public interface GetAllSongs {

    List<Song> getAllSongs(Artist artist);
}
