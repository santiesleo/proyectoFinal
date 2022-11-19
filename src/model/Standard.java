package model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Standard extends Consumer implements Playable{
    private ArrayList<Playlist> playlists;
    private ArrayList<Audio> audios;
    private String[] advertising;
    private int counterPlaylist;
    private int counterAudios;
    private int counterSongs;

    /**
     *
     * @param nickname
     * @param id
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

    @Override
    public String playAudio(String name, ArrayList<Audio> audiosPrincipal) {
        String msg = "";
        boolean flag = false;
        for(int i=0; i<audiosPrincipal.size() && !flag; i++){
            if(audiosPrincipal.get(i).getName().equalsIgnoreCase(name)){
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
     * @return
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

    /**
     *
     * @return
     */
    public int getCounterPlaylist() {
        return counterPlaylist;
    }

    /**
     *
     * @param counterPlaylist
     */
    public void setCounterPlaylist(int counterPlaylist) {
        this.counterPlaylist = counterPlaylist;
    }

    /**
     *
     * @return
     */
    public int getCounterAudios() {
        return counterAudios;
    }

    /**
     *
     * @param counterAudios
     */
    public void setCounterAudios(int counterAudios) {
        this.counterAudios = counterAudios;
    }

    public String[] getAdvertising() {
        return advertising;
    }

    public void setAdvertising(String[] advertising) {
        this.advertising = advertising;
    }

    public int getCounterSongs() {
        return counterSongs;
    }

    public void setCounterSongs(int counterSongs) {
        this.counterSongs = counterSongs;
    }
}
