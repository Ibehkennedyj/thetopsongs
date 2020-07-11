package domain.usecases;

import domain.actions.db.PersistSong;
import domain.actions.db.GetSongScore;
import domain.models.Song;

import java.util.List;

public class UpdateRankedSongs {

    GetSongScore score;
    PersistSong persister;

    public void update(List<Song> songs){
        int maxScore = songs.size();

        for (int i = 0; i < maxScore; i++) {
            Song song = songs.get(i);
            song.setScore(score.getScore(song) + maxScore - i);
            persister.persist(song);
        }
    }
}
