package model;

import java.util.Arrays;

/**
 *
 */
public class Standard extends Consumer{
    private Playlist[] playlists;
    private Audio[] audios;

    public Standard(String nickname, String id, String name) {
        super(nickname, id, name);
        playlists = new Playlist[20];
        audios = new Audio[100];
    }

    @Override
    public String toString() {
        return "Standard{" +
                super.toString() +
                "playlists=" + Arrays.toString(playlists) +
                ", audios=" + Arrays.toString(audios) +
                '}';
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    public Audio[] getAudios() {
        return audios;
    }

    public void setAudios(Audio[] audios) {
        this.audios = audios;
    }
}
