package model;

import java.util.ArrayList;

    /**
     * The controller class
     */
    public class NeoTunes {
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Shop> sales;

    /**
     * <b>Constructor</b><br>
     * This method is the constructor of the class Neotunes.<br>
     * <b>post:</b> A new object of the class Neotunes has been created.<br>
     */
    public NeoTunes() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
        sales = new ArrayList<Shop>();
    }

        /**
         * <b>Inform number reproductions</b><br>
         * This method inform the total number of reproductions.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> A inform of the reproductions of Songs or Podcasts.<br>
         * @param option Type of audio
         * @return message
         */
    public String informReproductions(int option){
        String msg = "";
        switch (option){//Song
            case 1:
                for(int i=0; i<audios.size(); i++){
                    if(audios.get(i) instanceof Song){
                        int pos = i+1;
                        msg = pos + audios.get(i).getName() + "total de reproducciones: " + audios.get(i).getNumberReproductions() + "\n";
                    }
                }
            break;
            case 2:
                for(int i=0; i<audios.size(); i++){
                    if(audios.get(i) instanceof Podcast){
                        int pos = i+1;
                        msg = pos + audios.get(i).getName() + "total de reproducciones: " + audios.get(i).getNumberReproductions() + "\n";
                    }
                }
        }
        return msg;
    }

    /**
     * <b>Create Playlist</b><br>
     * This method create a playlist.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A new object of the class Playlist has been created.<br>
     * @param idConsumer Identifier of the consumer
     * @param namePlaylist Name of the playlist
     * @param optionPlaylist Type of playlist
     * @return message of confirmation
     */
    public String createPlaylist(String idConsumer, String namePlaylist, int optionPlaylist){
        String msg = "Playlist creada exitosamente";
        User objU = searchUser(idConsumer);
        if(objU==null){
            msg = "El usuario no está creado, no se puede añadir playlist";
        }else{
            if(objU instanceof Standard){//Consumidor estándar
                Standard objUser = (Standard) searchUser(idConsumer);
                if(objUser.getCounterPlaylist()<=20){
                    Playlist playlist = new Playlist(namePlaylist, optionPlaylist);
                    objUser.getPlaylists().add(playlist);
                    objUser.setCounterPlaylist(+1);
                }else
                    msg = "El usuario " + idConsumer + " ya tiene el total de playlists creadas";
            }else{
                Premium objUser = (Premium) searchUser(idConsumer);
                Playlist playlist = new Playlist(namePlaylist, optionPlaylist);
                objUser.getPlaylists().add(playlist);
            }
        }
        return msg;
    }

        /**
         * <b>Add or delete an audio of the playlist</b><br>
         * This method delete or add an audio of the playlist of the user.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An audio has been added or deleted from a specific playlist of the user.<br>
         * @param idConsumer Identifier of consumer
         * @param namePlaylist Name of tha playlist
         * @param nameAudio Name of the audio
         * @param option Action to do (add or delete)
         * @return message of confirmation
         */
    public String addDeleteAudioPlaylist(String idConsumer, String namePlaylist, String nameAudio, int option){
        String msg = "Cambio realizado exitosamente";
        User objU = searchUser(idConsumer);
        Audio objA = searchAudio(nameAudio);

        if(objU==null){
            msg = "El usuario no está creado, no se puede añadir playlist";
        }else {
            if(option==2){//add
                if(objU instanceof Standard){
                    Standard objUser = (Standard) searchUser(idConsumer);
                    for(Playlist playlist : objUser.getPlaylists()){
                        if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                            playlist.getAudios().add(objA);
                        }
                    }
                }else {
                    Premium objUser = (Premium) searchUser(idConsumer);
                    for(Playlist playlist : objUser.getPlaylists()){
                        if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                            playlist.getAudios().add(objA);
                        }
                    }
                }
            } else if (option==3) {
                if(objU instanceof Standard){
                    Standard objUser = (Standard) searchUser(idConsumer);
                    for(Playlist playlist : objUser.getPlaylists()){
                        if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                            playlist.getAudios().remove(objA);
                        }
                    }

                }else {
                    Premium objUser = (Premium) searchUser(idConsumer);
                    for(Playlist playlist : objUser.getPlaylists()){
                        if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                            playlist.getAudios().remove(objA);
                        }
                    }
                }
            }
        }
        return msg;
    }

        /**
         * <b>Edit Name Playlist</b><br>
         * This edit the name of a playlist.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> The name of the playlist has been changed.<br>
         * @param idConsumer Identifier of the consumer
         * @param namePlaylist Name of tha playlist
         * @param newNamePlaylist New name of the playlist
         * @return message
         */
    public String editNamePlaylist(String idConsumer, String namePlaylist, String newNamePlaylist){
        String msg = "Nombre de playlist actualizado correctamente";
        User objU = searchUser(idConsumer);
        if(objU==null){
            msg = "El usuario no está creado, no se puede añadir playlist";
        }else {
            if(objU instanceof Standard){
                Standard objUser = (Standard) searchUser(idConsumer);
                for(Playlist playlist : objUser.getPlaylists()){
                    if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                        playlist.setName(newNamePlaylist);
                    }
                }
            }else {
                if(objU instanceof Premium){
                    Premium objUser = (Premium) searchUser(idConsumer);
                    for(Playlist playlist : objUser.getPlaylists()){
                        if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                            playlist.setName(newNamePlaylist);
                        }
                    }
                }
            }
        }
        return msg;
    }

        /**
         * <b>Calculate cost song</b><br>
         * This method calculate the cost of a song.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> The cost of a specific song.<br>
         * @param nameSong Name of the song
         * @return price of the song
         */
    public double calculateCostSong(String nameSong){
        double price = 0;
        Song objA = (Song) searchAudio(nameSong);
        price = objA.getPrice();
        return price;
    }

        /**
         * <b>Buy song</b><br>
         * This method buy a song for a specific user.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> The song has been added to the list of audios of the user.<br>
         * @param idConsumer Identifier of the consumer
         * @param nameSong Name of the song
         * @param pay Value to pay
         * @return message
         */
    public String buySong(String idConsumer, String nameSong, double pay){
        String msg = "";
        Song objA = (Song) searchAudio(nameSong);
        User objU = searchUser(idConsumer);
        if(objA==null){
            msg = "La canción no está disponible";
        }else {
            double totalShop=pay-calculateCostSong(nameSong);
            if(totalShop<0){
                msg = "Faltan: " + totalShop;
            }else {
                if(objU instanceof Standard){
                    Standard objUser = (Standard) searchUser(idConsumer);
                    objUser.getAudios().add(objA);
                    Shop sale = new Shop(idConsumer);
                    sales.add(sale);
                    msg = "Compra realizada exitosamente, su devuelta es: " + totalShop;
                }
            }
        }
        return msg;
    }

    /**
     * <b>Share playlist</b><br>
     * This method share the code of the playlist, according to a playlist type.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> The code according to the type of playlist, and tha matrix.<br>
     * @param idConsumer Identifier of the consumer
     * @param namePlaylist Name of the playlist
     * @return code
     */
    public String sharePlaylist(String idConsumer, String namePlaylist){
        String msg = "";
        User objU = searchUser(idConsumer);
        if(objU==null){
            msg = "El usuario no está creado, no se puede compartir playlist";
        }else {
            if(objU instanceof Standard){
                Standard objUser = (Standard) searchUser(idConsumer);
                for(Playlist playlist : objUser.getPlaylists()){
                    if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                        if (playlist.getTypePlaylist()==TypePlaylist.SONG){
                            msg = playlist.generateCodeN().toString();
                        }else if (playlist.getTypePlaylist()==TypePlaylist.PODCAST){
                            msg = playlist.generateCodeT();
                        }else{
                            msg = playlist.generateCodeStaggered();
                        }
                    }else {
                        msg = "La playlist no está creada, no se puede compartir playlist";
                    }
                }
            }
            if(objU instanceof Premium){
                Premium objUser = (Premium) searchUser(idConsumer);
                for(Playlist playlist : objUser.getPlaylists()){
                    if(playlist.getName().equalsIgnoreCase(namePlaylist)){
                        if (playlist.getTypePlaylist()==TypePlaylist.SONG){
                            msg = playlist.generateCodeN().toString();
                        }else if (playlist.getTypePlaylist()==TypePlaylist.PODCAST){
                            msg = playlist.generateCodeT();
                        }else{
                            msg = playlist.generateCodeStaggered();
                        }
                    }else {
                        msg = "La playlist no está creada, no se puede compartir playlist";
                    }
                }
            }

        }
        return msg;
    }

    /**
     * <b>Reproduce audio</b><br>
     * This method reproduce an audio.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> Reproduce an especific audio.<br>
     * @param idConsumer Identifier of the consumer
     * @param nameAudio Name of the audio
     * @return message
     */
    public String reproduceAudio(String idConsumer, String nameAudio){
        String msg = "";
        User objU = searchUser(idConsumer);
        if(objU==null){
            msg="El usuario no está creado";
        }else{
            if(objU instanceof Premium){
                Premium objUser = (Premium) searchUser(idConsumer);
                msg = objUser.playAudio(nameAudio, audios);
            }else {
                Standard objUser = (Standard) searchUser(idConsumer);
                msg = objUser.playAudio(nameAudio, audios);
            }
        }
        return msg;
    }

    /**
     * <b>Add user</b><br>
     * This method create a user of type producer.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A new object of type producer has been created.<br>
     * @param nickname Nickname of the producer
     * @param id Identifier of the producer
     * @param profilePicture Profile picture of the producer
     * @param typeProducer Type of producer
     * @return message
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
     * <b>Add user</b><br>
     * This method create a user of type consumer.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A new object of type consumer has been created.<br>
     * @param nickname Nickname of the consumer
     * @param id Identifier of the consumer
     * @param typeConsumer Type of consumer
     * @return message
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
     * <b>Add audio</b><br>
     * This method create an audio of type Song.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A new object of type song has been created.<br>
     * @param id Identifier of the song
     * @param name Name of the song
     * @param duration Duration of the song
     * @param album Album of the song
     * @param albumCover Album cover of the song
     * @param price Price of the song
     * @param option Type of the song
     * @return message
     */
    public String addAudio(String id, String name, int duration, String album, String albumCover, double price, int option){
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
     * <b>Add audio</b><br>
     * This method create an audio of type podcast.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A new object of type podcast has been created.<br>
     * @param id Identifier of the podcast
     * @param name Name of the podcast
     * @param duration Duration of the podcast
     * @param description Description of the podcast
     * @param icon Icon of the podcast
     * @param option Type of the podcast
     * @return message
     */
    public String addAudio(String id, String name, int duration, String description, String icon, int option){
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
     * <b>Search user</b><br>
     * This method search if a user is created.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A object of type User has been found.<br>
     * @param id Identifier of the user
     * @return User
     */
    public User searchUser(String id){
        User objUser = null;
        boolean flag = false;
        for (int i = 0; i < users.size() && !flag; i++) {
            if (users.get(i).getId().equals(id)){
                objUser = users.get(i);
                flag = true;
            }
        }
        return objUser;
    }

    /**
     * <b>Search audio</b><br>
     * This method search if an audio is created.<br>
     * <b>pre:</b> Must enter the data type correctly.<br>
     * <b>post:</b> A object of type Audio has been found.<br>
     * @param name Name of the audio
     * @return Audio
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
     * @param users The users of the app
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
         * @param audios the audios of the app
         */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

        /**
         *
         * @return sales
         */
    public ArrayList<Shop> getSales() {
        return sales;
    }

        /**
         *
         * @param sales The sales of the app
         */
    public void setSales(ArrayList<Shop> sales) {
        this.sales = sales;
    }
}
