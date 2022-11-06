package model;

import java.util.ArrayList;

/**
 *
 */
public class Playlist {
    private String name;
    private ArrayList <Audio> audios;
    private int[][] matrixCode;
    private String code;
    private TypePlaylist typePlaylist;

    public Playlist(String name, int option) {
        this.name = name;
        audios = new ArrayList<Audio>();
        matrixCode = new int[6][6];
        code = "";
        switch (option){
            case 1:
                typePlaylist = TypePlaylist.SONG;
                break;
            case 2:
                typePlaylist = TypePlaylist.PODCAST;
                break;
            case 3:
                typePlaylist = TypePlaylist.BOTH;
                break;
        }

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public int[][] getMatrixCode() {
        return matrixCode;
    }

    public void setMatrixCode(int[][] matrixCode) {
        this.matrixCode = matrixCode;
    }

    public TypePlaylist getTypePlaylist() {
        return typePlaylist;
    }

    public void setTypePlaylist(TypePlaylist typePlaylist) {
        this.typePlaylist = typePlaylist;
    }
}
