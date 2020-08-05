package app;

import domain.models.Song;

public interface SongFilter {

    boolean isUsable(Song song);
}
