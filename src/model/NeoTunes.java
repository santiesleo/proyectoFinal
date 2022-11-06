package model;

import java.util.ArrayList;

/**
 *
 */
public class NeoTunes {
    private ArrayList<User> users;
    private ArrayList<Audio> audios;

    public NeoTunes() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
    }

    /**
     *
     * @param nickname
     * @param id
     * @param profilePicture
     * @param typeProducer
     * @return
     */
    public String addUser(String nickname, String id, String profilePicture, int typeProducer){
        String msg = "Usuario creado exitosamente";
        User objUser = searchUser(id);

        if (objUser != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            if(typeProducer==1){
                objUser = new Artist(nickname, id, profilePicture);
            }else {
                objUser = new Creator(nickname, id, profilePicture);
            }
            users.add(objUser);
        }
        return msg;
    }

    /**
     *
     * @param nickname
     * @param id
     * @param typeConsumer
     * @return
     */
    public String addUser(String nickname, String id, int typeConsumer){
        String msg = "Usuario creado exitosamente";
        User objUser = searchUser(id);

        if (objUser != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            if(typeConsumer==1){
                objUser = new Standard(nickname, id);
            }else {
                objUser = new Premium(nickname, id);
            }
            users.add(objUser);
        }
        return msg;
    }

    /**
     *
     * @param id
     * @param name
     * @param duration
     * @param album
     * @param albumCover
     * @param price
     * @param option
     * @return
     */
    public String addAudio(String id, String name, String duration, String album, String albumCover, double price, int option){
        String msg = "Audio creado exitosamente";
        Audio objAudio = searchAudio(name);

        if (objAudio != null){
            msg = "Error. El audio ya está creado.\n";
        }else{
            objAudio = new Song(name, duration, album, albumCover, price, option);
            audios.add(objAudio);
            Artist objArtist = (Artist) searchUser(id);
            objArtist.getSongs().add((Song) objAudio);
        }
        return msg;
    }

    /**
     *
     * @param id
     * @param name
     * @param duration
     * @param description
     * @param icon
     * @param option
     * @return
     */
    public String addAudio(String id, String name, String duration, String description, String icon, int option){
        String msg = "Audio creado exitosamente";
        Audio objAudio = searchAudio(name);

        if (objAudio != null){
            msg = "Error. El audio ya está creado.\n";
        }else{
            objAudio = new Podcast(name, duration, description, icon, option);
            audios.add(objAudio);
            Creator objCreator = (Creator) searchUser(id);
            objCreator.getPodcasts().add((Podcast) objAudio);
        }
        return msg;
    }



    /**
     *
     * @param id
     * @return
     */
    public User searchUser(String id){
        User objUser = null;
        boolean flag = false;
        for (int i = 0; i < users.size() && !flag; i++) {
            if (users.get(i) !=null && users.get(i).getId().equals(id)){
                objUser = users.get(i);
                flag = true;
            }
        }
        return objUser;
    }

    /**
     *
     * @param name
     * @return
     */
    public Audio searchAudio(String name){
        Audio objAudio = null;
        boolean flag = false;
        for (int i = 0; i < audios.size() && !flag; i++) {
            if (audios.get(i).getName().equals(name)){
                objAudio = audios.get(i);
                flag = true;
            }
        }
        return objAudio;
    }

    /**
     *
     * @return users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
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
     * @param audios
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
}
