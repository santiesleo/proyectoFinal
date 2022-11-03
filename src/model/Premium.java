package model;

import java.util.ArrayList;

/**
 *
 */
public class Premium extends Consumer{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;

    public Premium(String nickname, String id, String name) {
        super(nickname, id, name);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
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
}
