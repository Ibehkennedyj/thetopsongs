package deezer.action;

import deezer.model.Track;

import java.util.Set;

public interface GetTracks {

    Set<Track> getTracks(String artist);
}
