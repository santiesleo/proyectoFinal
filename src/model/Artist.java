package model;

import java.util.ArrayList;

/**
 *
 */
public class Artist extends Producer{
    private ArrayList <Song> songs;

    /**
     *
     * @param nickname
     * @param id
     * @param profilePicture
     */
    public Artist(String nickname, String id, String profilePicture) {
        super(nickname, id, profilePicture);
        songs = new ArrayList<Song>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     *
     * @param songs
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
