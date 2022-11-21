package model;

import java.util.ArrayList;

/**
 * The creator class
 */
public class Creator extends Producer{
    private ArrayList <Podcast> podcasts;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Creator.<br>
     */
    public Creator(String nickname, String id, String profilePicture) {
        super(nickname, id, profilePicture);
        podcasts = new ArrayList<Podcast>();
    }

    /**
     *
     * @return podcasts
     */
    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    /**
     *
     * @param podcasts The podcasts
     */
    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
}
