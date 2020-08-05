package app;

import app.request.RankRequest;
import domain.models.Artist;
import domain.models.Song;
import domain.usecases.GetTopSongs;
import domain.usecases.UpdateRankedSongs;

import java.util.List;

public class Controller {

    PrepareSongs songs;
    UpdateRankedSongs update;
    GetTopSongs topSongs;

    // GET /discography/{artistName}
    public List<Song> getSongs(String artistName) {
        return songs.getUsableList(artistName);
    }

    // POST /songs
    public void rankSongs(RankRequest request) {
        update.update(request.getRankings());
    }

    // GET /songs/top?artist={artistName}
    public List<Song> getRankings(String artistName) {
        return topSongs.getTopSongs(new Artist(artistName));
    }
}
