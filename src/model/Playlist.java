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

    /**
     *
     */
    public Playlist() {
        name="";
        audios = new ArrayList<Audio>();
        code="";
        matrixCode = new int[6][6];
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
}
