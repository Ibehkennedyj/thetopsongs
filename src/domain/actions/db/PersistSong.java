package domain.actions.db;

import domain.models.Song;

public interface PersistSong {

    void persist(Song song);
}
