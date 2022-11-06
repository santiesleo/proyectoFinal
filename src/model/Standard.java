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

    /**
     *
     * @param nickname
     * @param id
     */
    public Standard(String nickname, String id) {
        super(nickname, id);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
        setCounterPlaylist(0);
        setCounterAudios(0);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Standard{" +
                "playlists=" + playlists +
                ", audios=" + audios +
                ", counterPlaylist=" + counterPlaylist +
                ", counterAudios=" + counterAudios +
                '}';
    }

    /**
     *
     * @return
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     *
     * @param playlists
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     *
     * @return
     */
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    /**
     *
     * @param audios
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    /**
     *
     * @return
     */
    public int getCounterPlaylist() {
        return counterPlaylist;
    }

    /**
     *
     * @param counterPlaylist
     */
    public void setCounterPlaylist(int counterPlaylist) {
        this.counterPlaylist = counterPlaylist;
    }

    /**
     *
     * @return
     */
    public int getCounterAudios() {
        return counterAudios;
    }

    /**
     *
     * @param counterAudios
     */
    public void setCounterAudios(int counterAudios) {
        this.counterAudios = counterAudios;
    }
}
