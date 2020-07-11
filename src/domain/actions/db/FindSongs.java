package domain.actions.db;

import domain.models.Artist;
import domain.models.Song;

import java.util.List;

public interface FindSongs {

    List<Song> find(Artist artist);
}
