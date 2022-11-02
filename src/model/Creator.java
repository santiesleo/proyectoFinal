package model;

import java.util.ArrayList;

public class Creator extends Producer{
    private ArrayList <Podcast> podcasts;

    public Creator(String nickname, String id, String name, String profilePicture, ArrayList<Podcast> podcasts) {
        super(nickname, id, name, profilePicture);
        podcasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
