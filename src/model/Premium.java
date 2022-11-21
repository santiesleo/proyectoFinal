package model;

import java.util.ArrayList;

/**
 * The premium class
 */
public class Premium extends Consumer implements Playable{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Premium.<br>
     */
    public Premium(String nickname, String id) {
        super(nickname, id);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
    }

    /**
     * <b>Play audio</b><br>
     * This method plays an specific audio.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> An audio has been reproduced.<br>
     * @param name name of the audio
     * @param audiosPrincipal Principal audios of the app
     * @return message
     */
    @Override
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        boolean flag = false;
        for(int i=0; i<audiosPrincipal.size() && !flag; i++){
            if(audiosPrincipal.get(i).getName().equalsIgnoreCase(name)){
                flag = true;
                audiosPrincipal.get(i).setNumberReproductions(audiosPrincipal.get(i).getNumberReproductions()+1);
                msg = "Reproduciendo\n" + audiosPrincipal.get(i).getName();
            }else {
                msg = "Audio no encontrado";
            }
        }
        return msg;
    }

    /**
     *
     * @return playlists
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     *
     * @param playlists The playlists of the user
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     *
     * @return audios
     */
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    /**
     *
     * @param audios The audios of the user
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
}
