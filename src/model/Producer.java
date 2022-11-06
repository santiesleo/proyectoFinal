package model;

/**
 *
 */
public abstract class Producer extends User{
    private String profilePicture;

    public Producer(String nickname, String id, String profilePicture) {
        super(nickname, id);
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Producer{" +
                super.toString() +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
