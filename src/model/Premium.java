package model;

import java.util.ArrayList;

/**
 *
 */
public class Premium extends Consumer implements Playable{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;

    /**
     *
     * @param nickname
     * @param id
     */
    public Premium(String nickname, String id) {
        super(nickname, id);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
    }

    @Override
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        for(Audio audio : audiosPrincipal){
            if(audio.getName().equalsIgnoreCase(name)){
                msg = "Reproduciendo\n" + audio.getName();
            }else {
                msg = "Audio no encontrado";
            }
        }
        return msg;
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
}
