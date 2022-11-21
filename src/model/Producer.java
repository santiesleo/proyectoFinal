package model;

/**
 *
 */
public abstract class Producer extends User{
    private String profilePicture;
    private int totalViews;
    private int totalTimePlayed;
    public Producer(String nickname, String id, String profilePicture) {
        super(nickname, id);
        this.profilePicture = profilePicture;
        totalViews = 0;
        totalTimePlayed = 0;
    }

    @Override
    public String toString() {
        return "Producer{" +
                super.toString() +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }

    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }
    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
