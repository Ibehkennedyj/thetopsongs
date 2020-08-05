package app.request;

import domain.models.Song;

import java.util.List;

public class RankRequest {

    private List<Song> rankings;

    public List<Song> getRankings() {
        return rankings;
    }
}
