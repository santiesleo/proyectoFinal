package model;

import java.util.ArrayList;

/**
 *
 */
public class Playlist {
    private String identifier;
    private String name;
    private ArrayList <Audio> audios;
    private int[][] matrixCode;
    private StringBuilder code;
    private TypePlaylist typePlaylist;

    public Playlist(String name, int option, String identifier) {
        this.identifier = identifier;
        this.name = name;
        audios = new ArrayList<Audio>();
        matrixCode = new int[6][6];
        for(int i = 0; i < matrixCode.length; i++){
            for(int j = 0; j < matrixCode.length; j++){
                matrixCode[i][j]= (int)(Math.random()*(10-1))+1;
            }
        }
        code = new StringBuilder("");
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

    public StringBuilder generateCodeN(){
        code = new StringBuilder();
        for(int i = matrixCode[0].length-1; i>-1;i--){
            code.append(Integer.toString(matrixCode[i][0]));
        }for(int i = 1; i<5;i++){
            code.append(Integer.toString(matrixCode[i][i]));
        }for(int i = matrixCode[0].length-1;i>-1;i--){
            code.append(Integer.toString(matrixCode[i][5]));
        }
        return code;
    }

    public String generateCodeT() {

        code = new StringBuilder();
        for (int j = 0; j < matrixCode.length -4; j++) { // Gets the values of the first row, since column zero until column two
            code.append(matrixCode[0][j]);
        }
        for (int i = 0; i < matrixCode.length; i++) { // Gets the values of the column two
            code.append(matrixCode[i][2]);
        }
        for (int i = matrixCode.length; i > 0; i--) { // Gets the values of the column three
            code.append(matrixCode[i - 1][3]);
        }
        for (int j = matrixCode.length -2; j < matrixCode.length; j++ ) { // Gets the values of the first row, since column four until column five
            code.append(matrixCode[0][j]);
        }
        return code.toString();
    }

    public String generateCodeStaggered() {

        code = new StringBuilder();
        for (int i = matrixCode.length -1; i >= 0; i--) {
            for (int j = matrixCode.length -1; j >= 0 ; j--) {
                if (((i + j) % 2 != 0) && ((i + j) > 1)) {
                    code.append(matrixCode[i][j]);
                }
            }
        }
        return code.toString();
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
     * @return
     */
    public StringBuilder getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = new StringBuilder(code);
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
