package domain.actions.db;

import domain.models.Song;

public interface GetSongScore {

    int getScore(Song song);
}
