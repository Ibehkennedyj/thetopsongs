package app;

import domain.actions.ext.GetAllSongs;
import domain.models.Artist;
import domain.models.Song;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PrepareSongs {

    GetAllSongs songs;
    List<SongFilter> filters;

    public List<Song> getUsableList(String artistName) {
        return songs.getAllSongs(new Artist(artistName))
                .stream()
                .filter(song -> filters.stream().allMatch(filter -> filter.isUsable(song)))
                .collect(toList());
    }
}
