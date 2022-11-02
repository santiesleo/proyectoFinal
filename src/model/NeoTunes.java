package model;

import java.util.ArrayList;

public class NeoTunes {
    private ArrayList<User> users;
    private ArrayList<Audio> audios;

    public NeoTunes() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
}
