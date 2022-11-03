package model;

import java.util.ArrayList;

/**
 *
 */
public class Playlist {
    private String name;
    private ArrayList <Audio> audios;
    private String code;

    /**
     *
     */
    public Playlist() {
        name="";
        audios = new ArrayList<Audio>();
        code="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
