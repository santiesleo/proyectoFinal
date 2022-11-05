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

    public String addUser(String nickname, String id, String name, String profilePicture, int typeProducer){
        String msg = "Usuario creado exitosamente";
        User objUser = searchUser(id);

        if (objUser != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            if(typeProducer==1){
                objUser = new Creator(nickname, id, name, profilePicture);
            }else {
                objUser = new Artist(nickname, id, name, profilePicture);
            }
            users.add(objUser);
        }
        return msg;
    }

    public String addUser(String nickname, String id, String name, int typeConsumer){
        String msg = "Usuario creado exitosamente";
        User objUser = searchUser(id);

        if (objUser != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            if(typeConsumer==1){
                objUser = new Standard(nickname, id, name);
            }else {
                objUser = new Premium(nickname, id, name);
            }
            users.add(objUser);
        }
        return msg;
    }

    public String addAudio(String name, String duration, String album, String albumCover, double price, Genre typeGenre){
        String msg = "Audio creado exitosamente";
        Audio objAudio = searchAudio(name);

        if (objAudio != null){
            msg = "Error. El audio ya está creado.\n";
        }else{
            objAudio = new Song(name, duration, album, albumCover, price, typeGenre);
            audios.add(objAudio);
        }
        return msg;
    }

    public String addAudio(String name, String duration, String description, String icon, Category category){
        String msg = "Audio creado exitosamente";
        Audio objAudio = searchAudio(name);

        if (objAudio != null){
            msg = "Error. El audio ya está creado.\n";
        }else{
            objAudio = new Podcast(name, duration, description, icon, category);
            audios.add(objAudio);
        }
        return msg;
    }

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
