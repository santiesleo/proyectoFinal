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
        User objU = searchUser(id);

        if (objU != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            boolean status = isAvailableUser();
            if (status){
                boolean flag = false;
                for (int i = 0; i < users.size() && !flag; i++){
                    if(users.get(i) == null){
                        if(typeProducer==1){
                            users.set(i, new Creator(nickname, id, name, profilePicture));
                        }else {
                            users.set(i, new Artist(nickname, id, name, profilePicture));
                        }
                        flag=true;
                    }
                }
            }else
                msg = "Error. No existen espacios disponibles para crear otro usuario.\n";
        }
        return msg;
    }

    public String addUser(String nickname, String id, String name, int typeConsumer){
        String msg = "Usuario creado exitosamente";
        User objUser = searchUser(id);

        if (objUser != null){
            msg = "Error. El usuario ya está creado.\n";
        }else{
            boolean status = isAvailableUser();
            if (status){
                boolean flag = false;
                for (int i = 0; i < users.size() && !flag; i++){
                    if(users.get(i) == null){
                        if(typeConsumer==1){
                            users.set(i, new Standard(nickname, id, name));
                        }else {
                            users.set(i, new Premium(nickname, id, name));
                        }
                        flag=true;
                    }
                }
            }else
                msg = "Error. No existen espacios disponibles para crear otro usuario.\n";
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

    public boolean isAvailableUser(){
        boolean flag=false;
        for (int i = 0; i < users.size() && !flag; i++) {
            if(users.get(i) == null){
                flag=true;
            }
        }
        return flag;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
}
