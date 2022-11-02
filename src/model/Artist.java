package model;

import java.util.ArrayList;

public class Artist extends Producer{
    private ArrayList <Song> songs;

    public Artist(String nickname, String id, String name, String profilePicture) {
        super(nickname, id, name, profilePicture);
        songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
