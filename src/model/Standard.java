package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Standard extends Consumer{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;
    private int counterPlaylist;
    private int counterAudios;

    public Standard(String nickname, String id) {
        super(nickname, id);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
        setCounterPlaylist(0);
        setCounterAudios(0);
    }

    @Override
    public String toString() {
        return "Standard{" +
                "playlists=" + playlists +
                ", audios=" + audios +
                ", counterPlaylist=" + counterPlaylist +
                ", counterAudios=" + counterAudios +
                '}';
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public int getCounterPlaylist() {
        return counterPlaylist;
    }

    public void setCounterPlaylist(int counterPlaylist) {
        this.counterPlaylist = counterPlaylist;
    }

    public int getCounterAudios() {
        return counterAudios;
    }

    public void setCounterAudios(int counterAudios) {
        this.counterAudios = counterAudios;
    }
}
