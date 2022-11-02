package model;

public class Producer extends User{
    private String name;
    private String profilePicture;

    public Producer(String nickname, String id, String name, String profilePicture) {
        super(nickname, id);
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}