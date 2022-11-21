package model;

import java.util.ArrayList;

/**
 * The playlist class
 */
public class Playlist {
    private String name;
    private ArrayList <Audio> audios;
    private int[][] matrixCode;
    private StringBuilder code;
    private TypePlaylist typePlaylist;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Playlist.<br>
     */
    public Playlist(String name, int option) {
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

    /**
     * This method show the matrix
     * @return
     */
    public String showMatrix(){
        String msg = "";
        for(int i=0; i<matrixCode.length;i++){ //Primer for, recorrer número de filas
            for(int j = 0; j<matrixCode.length;j++){  //Segundo for, recorrer número de columnas
                msg+=(matrixCode[i][j]);
            }
            msg+="\n";
        }
        return msg;
    }

    /**
     * This method generate the code in a path in N
     * @return
     */
    public StringBuilder generateCodeN(){
        code = new StringBuilder("Código: " );
        for(int i = matrixCode[0].length-1; i>-1;i--){
            code.append(Integer.toString(matrixCode[i][0]));
        }for(int i = 1; i<5;i++){
            code.append(Integer.toString(matrixCode[i][i]));
        }for(int i = matrixCode[0].length-1;i>-1;i--){
            code.append(Integer.toString(matrixCode[i][5]));
        }
        return new StringBuilder(showMatrix()  + "\n" + code);
    }

    /**
     * This method generate the code in a path in T
     * @return
     */
    public String generateCodeT() {

        code = new StringBuilder("Código: " );
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
        return showMatrix()  + "\n" + code;
    }

    /**
     * This method generate the code in a path staggered
     * @return
     */
    public String generateCodeStaggered() {

        code = new StringBuilder("Código: " );
        for (int i = matrixCode.length -1; i >= 0; i--) {
            for (int j = matrixCode.length -1; j >= 0 ; j--) {
                if (((i + j) % 2 != 0) && ((i + j) > 1)) {
                    code.append(matrixCode[i][j]);
                }
            }
        }
        return showMatrix()  + "\n" + code;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name The name of the playlist
     */
    public void setName(String name) {
        this.name = name;
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
     * @param audios audios of the playlist
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    /**
     * @return code
     */
    public StringBuilder getCode() {
        return code;
    }

    /**
     *
     * @param code The code of the playlist
     */
    public void setCode(String code) {
        this.code = new StringBuilder(code);
    }

    /**
     *
     * @return matrix code
     */
    public int[][] getMatrixCode() {
        return matrixCode;
    }

    /**
     *
     * @param matrixCode The matrix code of the playlist
     */
    public void setMatrixCode(int[][] matrixCode) {
        this.matrixCode = matrixCode;
    }

    /**
     *
     * @return type playlist
     */
    public TypePlaylist getTypePlaylist() {
        return typePlaylist;
    }

    /**
     *
     * @param typePlaylist The type of the playlist
     */
    public void setTypePlaylist(TypePlaylist typePlaylist) {
        this.typePlaylist = typePlaylist;
    }

}
