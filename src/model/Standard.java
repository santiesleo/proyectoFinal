package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Standard class
 */
public class Standard extends Consumer implements Playable{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;
    private String[] advertising;
    private int counterPlaylist;
    private int counterAudios;
    private int counterSongs;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Standard.<br>
     */
    public Standard(String nickname, String id) {
        super(nickname, id);
        playlists = new ArrayList<Playlist>();
        audios = new ArrayList<Audio>();
        advertising = new String[3];
        advertising[0] = "Nike - Just Do It";
        advertising[1] = "Coca-Cola - Open Happiness";
        advertising[2] = "M&Ms - Melts in Your Mouth, Not in Your Hands";
        setCounterPlaylist(0);
        setCounterAudios(0);
        setCounterSongs(0);
    }

    /**
     * <b>Play audio</b><br>
     * This method plays an specific audio.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> An audio has been reproduced.<br>
     * @param name Name of the song
     * @param audiosPrincipal Principal audios of the audio
     * @return message
     */
    @Override
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        boolean flag = false;
        for(int i=0; i<audiosPrincipal.size() && !flag; i++){
            if(audiosPrincipal.get(i).getName().equalsIgnoreCase(name)){
                audiosPrincipal.get(i).setNumberReproductions(audiosPrincipal.get(i).getNumberReproductions()+1);
                flag = true;
                int index = (int)(Math.random()*(3-1))+1;
                if(audiosPrincipal.get(i) instanceof Song){
                    counterSongs++;
                    if(counterSongs%2==0){
                        msg = "Reproduciendo\n" + audiosPrincipal.get(i).getName() + "\n" + "Sponsored by: " + advertising[index];
                    }else {
                        msg = "Reproduciendo\n" + audiosPrincipal.get(i).getName();
                    }
                }else {
                    msg = "Sponsored by: " + advertising[index] + "\n" + "Reproduciendo\n" + audiosPrincipal.get(i).getName() ;
                }
            }else {
                msg = "Audio no encontrado";
            }
        }
        return msg;
    }

    /**
     *
     * @return The attributes of the user Standard
     */
    @Override
    public String toString() {
        return "Standard{" +
                "playlists=" + playlists +
                ", audios=" + audios +
                ", counterPlaylist=" + counterPlaylist +
                ", counterAudios=" + counterAudios +
                '}';
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
     * @param playlists The playlists of the user Standard
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
     * @param audios The audios of the user Standard
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    /**
     *
     * @return counter playlist
     */
    public int getCounterPlaylist() {
        return counterPlaylist;
    }

    /**
     *
     * @param counterPlaylist The counter of playlists
     */
    public void setCounterPlaylist(int counterPlaylist) {
        this.counterPlaylist = counterPlaylist;
    }

    /**
     *
     * @return counter audios
     */
    public int getCounterAudios() {
        return counterAudios;
    }

    /**
     *
     * @param counterAudios The counter of audios
     */
    public void setCounterAudios(int counterAudios) {
        this.counterAudios = counterAudios;
    }

    /**
     *
     * @return advertising
     */
    public String[] getAdvertising() {
        return advertising;
    }

    /**
     *
     * @param advertising The advertising of the app
     */
    public void setAdvertising(String[] advertising) {
        this.advertising = advertising;
    }

    /**
     *
     * @return counter songs
     */
    public int getCounterSongs() {
        return counterSongs;
    }

    /**
     *
     * @param counterSongs The counter of songs
     */
    public void setCounterSongs(int counterSongs) {
        this.counterSongs = counterSongs;
    }
}
