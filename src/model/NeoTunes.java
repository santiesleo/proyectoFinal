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
         * <b>post:</b> An inform of the reproductions of Songs or Podcasts.<br>
         * @param option Type of audio
         * @return message
         */
    public String informReproductions(int option){
        String msg = "";
        int counter = 0;
        switch (option){//Song
            case 1:
                for(int i=0; i<audios.size(); i++){
                    if(audios.get(i) instanceof Song){
                        counter+=audios.get(i).getNumberReproductions();
                        int pos = i+1;
                        msg = pos + audios.get(i).getName() + "total de reproducciones: " + audios.get(i).getNumberReproductions() + "\n";
                    }
                }
                msg+= "El total de reproducciones de Canciones, es: " + counter;
            break;
            case 2:
                for(int i=0; i<audios.size(); i++){
                    if(audios.get(i) instanceof Podcast){
                        counter+=audios.get(i).getNumberReproductions();
                        int pos = i+1;
                        msg = pos + audios.get(i).getName() + "total de reproducciones: " + audios.get(i).getNumberReproductions() + "\n";
                    }
                }
                msg+= "El total de reproducciones de Podcast, es: " + counter;
        }
        return msg;
    }

        /**
         * <b>Inform genre of song most played</b><br>
         * This method inform the genre most played.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the genre most played.<br>
         * @return message
         */
    public String informMostGenrePlayed(){
        String msg = "";
        int[] genreType = new int[4];
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song song = (Song) audios.get(i);
                if (song.getTypeGenre().equals(Genre.values()[0])) { // ROCK
                    genreType[0] += song.getNumberReproductions();
                } else if (song.getTypeGenre().equals(Genre.values()[1])) { // POP
                    genreType[1] += song.getNumberReproductions();
                } else if (song.getTypeGenre().equals(Genre.values()[2])) { // TRAP
                    genreType[2] += song.getNumberReproductions();
                } else if (song.getTypeGenre().equals(Genre.values()[3])) { // HOUSE
                    genreType[3] += song.getNumberReproductions();
                }
            }
        }
        int max = 0;
        int pos = -1;
        for (int i = 0; i < genreType.length; i++) {
            if (genreType[i] > max) {
                max = genreType[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:
                msg = "El género más escuchado es: Rock, con un total de: " + max + " reproducciones";
                break;
            case 1:
                msg = "El género más escuchado es: Pop, con un total de: " + max + " reproducciones";
                break;
            case 2:
                msg = "El género más escuchado es: Trap, con un total de: " + max + " reproducciones";
                break;
            case 3:
                msg = "El género más escuchado es: House, con un total de: " + max + " reproducciones";
                break;
        }
        return msg;
    }

        /**
         * <b>show user most played Song Genre</b><br>
         * This method inform the genre most played.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the genre most played.<br>
         * @param idConsumer Identifier of the consumer
         * @return message
         */
    public String showUserMostPlayedSongGenre(String idConsumer) {
        String msg = "";
        User user = searchUser(idConsumer);
        int[] genreType = new int[4];
        if (user == null) {
            msg = "Error. El usuario no existe.";
        }  else {
            if (user instanceof Standard) {
                Standard standard = (Standard) user; // Downcasting of User to Standard
                for (int i = 0; i < standard.getAudios().size(); i++) {
                    if (standard.getAudios().get(i) instanceof Song) {
                        Song song = (Song) standard.getAudios().get(i);
                        if (song.getTypeGenre().equals(Genre.values()[0])) { // ROCK
                            genreType[0] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[1])) { // POP
                            genreType[1] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[2])) { // TRAP
                            genreType[2] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[3])) { // HOUSE
                            genreType[3] += 1;
                        }
                    }
                }
                int max = 0;
                int pos = -1;
                for (int i = 0; i < genreType.length; i++) {
                    if (genreType[i] > max) {
                        max = genreType[i];
                        pos = i;
                    }
                }
                switch (pos) {
                    case 0:
                        msg = "El género más escuchado es: Rock, con un total de: " + max + " reproducciones";
                        break;
                    case 1:
                        msg = "El género más escuchado es: Pop, con un total de: " + max + " reproducciones";
                        break;
                    case 2:
                        msg = "El género más escuchado es: Trap, con un total de: " + max + " reproducciones";
                        break;
                    case 3:
                        msg = "El género más escuchado es: House, con un total de: " + max + " reproducciones";
                        break;
                }
            } else if (user instanceof Premium) {
                Premium premium = (Premium) user; // Downcasting of User to Premium
                for (int i = 0; i < premium.getAudios().size(); i++) {
                    if (premium.getAudios().get(i) instanceof Song) {
                        Song song = (Song) premium.getAudios().get(i);
                        if (song.getTypeGenre().equals(Genre.values()[0])) { // ROCK
                            genreType[0] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[1])) { // POP
                            genreType[1] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[2])) { // TRAP
                            genreType[2] += 1;
                        } else if (song.getTypeGenre().equals(Genre.values()[3])) { // HOUSE
                            genreType[3] += 1;
                        }
                    }
                }
                int max = 0;
                int pos = -1;
                for (int i = 0; i < genreType.length; i++) {
                    if (genreType[i] > max) {
                        max = genreType[i];
                        pos = i;
                    }
                }
                switch (pos) {
                    case 0:
                        msg = "El género más escuchado es: Rock, con un total de: " + max + " reproducciones";
                        break;
                    case 1:
                        msg = "El género más escuchado es: Pop, con un total de: " + max + " reproducciones";
                        break;
                    case 2:
                        msg = "El género más escuchado es: Trap, con un total de: " + max + " reproducciones";
                        break;
                    case 3:
                        msg = "El género más escuchado es: House, con un total de: " + max + " reproducciones";
                        break;
                }
            }
        }
        return msg;
    }

        /**
         * <b>Show most played podcast category</b><br>
         * This method inform the category most played.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the category most played.<br>
         * @return message
         */
    public String showMostPlayedPodcastCategory() {
        String msg = "";
        int[] podcastCategory = new int[4];
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Podcast) {
                Podcast podcast = (Podcast) audios.get(i);
                if (podcast.getCategory().equals(Category.values()[0])) { // POLITICS
                    podcastCategory[0] += podcast.getNumberReproductions();
                } else if (podcast.getCategory().equals(Category.values()[1])) { // ENTERTAINMENT
                    podcastCategory[1] += podcast.getNumberReproductions();
                } else if (podcast.getCategory().equals(Category.values()[2])) { // VIDEOGAMES
                    podcastCategory[2] += podcast.getNumberReproductions();
                } else if (podcast.getCategory().equals(Category.values()[3])) { // FASHION
                    podcastCategory[3] += podcast.getNumberReproductions();
                }
            }
        }
        int max = 0;
        int pos = -1;
        for (int i = 0; i < podcastCategory.length; i++) {
            if (podcastCategory[i] > max) {
                max = podcastCategory[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:
                msg = "La categoría más escuchada es: Política, con un total de: " + max + " reproducciones";
                break;
            case 1:
                msg = "La categoría más escuchada es: Entretenimiento, con un total de: " + max + " reproducciones";
                break;
            case 2:
                msg = "La categoría más escuchada es: Videojuegos, con un total de: " + max + " reproducciones";
                break;
            case 3:
                msg = "La categoría más escuchada es: Moda, con un total de: " + max + " reproducciones";
                break;
        }
        return msg;
    }

        /**
         * <b>Show most played podcast category per user</b><br>
         * This method inform the category most played.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the category most played.<br>
         * @return message
         */
    public String showUserMostPlayedPodcastCategory(String nameUser) {
        String msg = "";
        User user = searchUser(nameUser);
        int[] podcastCategory = new int[4];
        if (user == null) {
            msg = "Error. El usuario no está creado";
        }  else {
            if (user instanceof Standard) {
                Standard standard = (Standard) user; // Downcasting of User to Standard
                for (int i = 0; i < standard.getAudios().size(); i++) {
                    if (standard.getAudios().get(i) instanceof Podcast) {
                        Podcast podcast = (Podcast) standard.getAudios().get(i);
                        if (podcast.getCategory().equals(Category.values()[0])) { // POLITICS
                            podcastCategory[0] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[1])) { // ENTERTAINMENT
                            podcastCategory[1] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[2])) { // VIDEOGAMES
                            podcastCategory[2] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[3])) { // FASHION
                            podcastCategory[3] += 1;
                        }
                    }
                }
                int max = 0;
                int pos = -1;
                for (int i = 0; i < podcastCategory.length; i++) {
                    if (podcastCategory[i] > max) {
                        max = podcastCategory[i];
                        pos = i;
                    }
                }
                switch (pos) {
                    case 0:
                        msg = "La categoría más escuchada es: Política, con un total de: " + max + " reproducciones";
                        break;
                    case 1:
                        msg = "La categoría más escuchada es: Entretenimiento, con un total de: " + max + " reproducciones";
                        break;
                    case 2:
                        msg = "La categoría más escuchada es: Videojuegos, con un total de: " + max + " reproducciones";
                        break;
                    case 3:
                        msg = "La categoría más escuchada es: Moda, con un total de: " + max + " reproducciones";
                        break;
                }
            } else if (user instanceof Premium) {
                Premium premium = (Premium) user; // Downcasting of User to Premium
                for (int i = 0; i < premium.getAudios().size(); i++) {
                    if (premium.getAudios().get(i) instanceof Podcast) {
                        Podcast podcast = (Podcast) premium.getAudios().get(i);
                        if (podcast.getCategory().equals(Category.values()[0])) { // POLITICS
                            podcastCategory[0] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[1])) { // ENTERTAINMENT
                            podcastCategory[1] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[2])) { // VIDEOGAMES
                            podcastCategory[2] += 1;
                        } else if (podcast.getCategory().equals(Category.values()[3])) { // FASHION
                            podcastCategory[3] += 1;
                        }
                    }
                }
                int max = 0;
                int pos = -1;
                for (int i = 0; i < podcastCategory.length; i++) {
                    if (podcastCategory[i] > max) {
                        max = podcastCategory[i];
                        pos = i;
                    }
                }
                switch (pos) {
                    case 0:
                        msg = "La categoría más escuchada es: Política, con un total de: " + max + " reproducciones";
                        break;
                    case 1:
                        msg = "La categoría más escuchada es: Entretenimiento, con un total de: " + max + " reproducciones";
                        break;
                    case 2:
                        msg = "La categoría más escuchada es: Videojuegos, con un total de: " + max + " reproducciones";
                        break;
                    case 3:
                        msg = "La categoría más escuchada es: Moda, con un total de: " + max + " reproducciones";
                        break;
                }
            }
        }
        return msg;
    }


    /**
     * <pre>
     * <strong>Description:</strong> The method bubbleSort allows to sort the array descending
     * <strong>pre:</strong> array must be initialized
     * <strong>pos:</strong> Sort the array descending
     * @param array </strong>int[]</strong> Array to sort
     */
    private void bubbleSort (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int currentItem = array[j],
                        nextItem = array[j + 1];
                if (currentItem < nextItem) {
                    array[j] = nextItem;
                    array[j + 1] = currentItem;
                }
            }
        }
    }

    /**
     * <strong>Description:</strong> The method isRepeated allows to check if the element is already inside the array
     * <strong>pre:</strong> array must be initialized
     * <strong>pos:</strong> Determine if the element is already inside the array
     * @param array </strong>int[]</strong> Array for save the elements without repeated
     * @param aux </strong>int</strong> Aux to search
     * @return stopFlag <strong>boolean</strong> Flag to know if the process was successful or not
     */
    private boolean isRepeated(int[] array, int aux) {
        boolean stopFlag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == aux) {
                return stopFlag = true;
            }
        }
        return stopFlag;
    }

        /**
         * <b>Show top artist</b><br>
         * This method show the top of artist.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the top 5 artist.<br>
         * @return message
         */
    public String showTopArtist() {
    ArrayList<Artist> artistsGlobal = new ArrayList<Artist>();
    int[] artistsGlobalPlayed = new int[users.size()], artistsGlobalPlayedWithoutRepeated = new int[users.size()];
    int count = 0, playedAux = 0, k = 0, top = 0;
    String msg = "";
    //Loop to fill array
    for (int i = 0; i < users.size(); i++) {
        if (users.get(i) instanceof Artist) {
            Artist artist = (Artist) users.get(i);
            if (artist.getTotalViews() != 0) {
                artistsGlobal.add(artist); // Fill array artist
                artistsGlobalPlayed[i] = artist.getTotalViews(); //Fill array global
            }
        }
    }
    //Bubble sort from largest to smallest
    bubbleSort(artistsGlobalPlayed);
    //Loop to remove duplicate elements
    for (int i = 0; i < artistsGlobalPlayed.length; i++) {
        playedAux = artistsGlobalPlayed[i];
        if  (!isRepeated(artistsGlobalPlayedWithoutRepeated, playedAux)) {
            artistsGlobalPlayedWithoutRepeated[k] = playedAux;
            k++;
        }
    }
    //Loop to compare and determine the podium
    for (int i = 0; i < artistsGlobalPlayedWithoutRepeated.length; i++) {
        for (int j = 0; j < artistsGlobal.size(); j++) {
            if (count < 5) {
                if (artistsGlobal.get(j).getTotalViews() == artistsGlobalPlayedWithoutRepeated[i]) {
                    msg += "\n" + (top+1) + ". " + artistsGlobal.get(j).getNickname() + "          " + artistsGlobal.get(j).getTotalViews();
                    count++;
                    top++;
                }
            }
        }
    }
    return msg;
    }

        /**
         * <b>Show top content creator</b><br>
         * This method show the top of content creator.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the top 5 content creator.<br>
         * @return message
         */
    public String showTopContentCreator() {
        ArrayList<Creator> contentCreatorsGlobal = new ArrayList<Creator>();
        int[] contentCreatorsGlobalPlayed = new int[users.size()], contentCreatorsGlobalPlayedWithoutRepeated = new int[users.size()];
        int count = 0, playedAux = 0, k = 0, top = 0;
        String msg = "";
        //Loop to fill array
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Creator) {
                Creator contentCreator = (Creator) users.get(i);
                if (contentCreator.getTotalViews() != 0) {
                    contentCreatorsGlobal.add(contentCreator); // Fill array artist
                    contentCreatorsGlobalPlayed[i] = contentCreator.getTotalViews(); //Fill array global
                }
            }
        }
        //Bubble sort from largest to smallest
        bubbleSort(contentCreatorsGlobalPlayed);
        //Loop to remove duplicate elements
        for (int i = 0; i < contentCreatorsGlobalPlayed.length; i++) {
            playedAux = contentCreatorsGlobalPlayed[i];
            if  (!isRepeated(contentCreatorsGlobalPlayedWithoutRepeated, playedAux)) {
                contentCreatorsGlobalPlayedWithoutRepeated[k] = playedAux;
                k++;
            }
        }
        //Loop to compare and determine the podium
        for (int i = 0; i < contentCreatorsGlobalPlayedWithoutRepeated.length; i++) {
            for (int j = 0; j < contentCreatorsGlobal.size(); j++) {
                if (count < 5) {
                    if (contentCreatorsGlobal.get(j).getTotalViews() == contentCreatorsGlobalPlayedWithoutRepeated[i]) {
                        msg += "\n" + (top+1) + ". " + contentCreatorsGlobal.get(j).getNickname() + "          " + contentCreatorsGlobal.get(j).getTotalViews();
                        count++;
                        top++;
                    }
                }
            }
        }
        return msg;
    }

        /**
         * <b>Show top song</b><br>
         * This method show the top of song.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the top 10 songs.<br>
         * @return message
         */
    public String showTopSong() {
        ArrayList<Song> songsGlobal = new ArrayList<Song>();
        int[] songsGlobalPlayed = new int[users.size()], songsGlobalPlayedWithoutRepeated = new int[users.size()];
        int count = 0, playedAux = 0, k = 0, top = 0;
        String msg = "";
        //Loop to fill array
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song song = (Song) audios.get(i);
                if (song.getNumberReproductions() != 0) {
                    songsGlobal.add(song); // Fill array artist
                    songsGlobalPlayed[i] = song.getNumberReproductions(); //Fill array global
                }
            }
        }
        //Bubble sort from largest to smallest
        bubbleSort(songsGlobalPlayed);
        //Loop to remove duplicate elements
        for (int i = 0; i < songsGlobalPlayed.length; i++) {
            playedAux = songsGlobalPlayed[i];
            if  (!isRepeated(songsGlobalPlayedWithoutRepeated, playedAux)) {
                songsGlobalPlayedWithoutRepeated[k] = playedAux;
                k++;
            }
        }
        //Loop to compare and determine the podium
        for (int i = 0; i < songsGlobalPlayedWithoutRepeated.length; i++) {
            for (int j = 0; j < songsGlobal.size(); j++) {
                if (count < 10) {
                    if (songsGlobal.get(j).getNumberReproductions() == songsGlobalPlayedWithoutRepeated[i]) {
                        msg += "\n" + (top+1) + ". " + songsGlobal.get(j).getName() + "          " + songsGlobal.get(j).getTypeGenre() + "          " + songsGlobal.get(j).getNumberReproductions();
                        count++;
                        top++;
                    }
                }
            }
        }
        return msg;
    }

        /**
         * <b>Show top podcast</b><br>
         * This method show the top of podcast.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the top 10 podcast.<br>
         * @return message
         */
    public String showTopPodcast() {
        ArrayList<Podcast> podcastsGlobal = new ArrayList<Podcast>();
        int[] podcastsGlobalPlayed = new int[users.size()], podcastsGlobalPlayedWithoutRepeated = new int[users.size()];
        int count = 0, playedAux = 0, k = 0, top = 0;
        String msg = "";
        //Loop to fill array
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Podcast) {
                Podcast podcast = (Podcast) audios.get(i);
                if (podcast.getNumberReproductions() != 0) {
                    podcastsGlobal.add(podcast); // Fill array artist
                    podcastsGlobalPlayed[i] = podcast.getNumberReproductions(); //Fill array global
                }
            }
        }
        //Bubble sort from largest to smallest
        bubbleSort(podcastsGlobalPlayed);
        //Loop to remove duplicate elements
        for (int i = 0; i < podcastsGlobalPlayed.length; i++) {
            playedAux = podcastsGlobalPlayed[i];
            if  (!isRepeated(podcastsGlobalPlayedWithoutRepeated, playedAux)) {
                podcastsGlobalPlayedWithoutRepeated[k] = playedAux;
                k++;
            }
        }
        //Loop to compare and determine the podium
        for (int i = 0; i < podcastsGlobalPlayedWithoutRepeated.length; i++) {
            for (int j = 0; j < podcastsGlobal.size(); j++) {
                if (count < 10) {
                    if (podcastsGlobal.get(j).getNumberReproductions() == podcastsGlobalPlayedWithoutRepeated[i]) {
                        msg += "\n" + (top+1) + ". " + podcastsGlobal.get(j).getName() + "          " + podcastsGlobal.get(j).getCategory() + "          " + podcastsGlobal.get(j).getNumberReproductions();
                        count++;
                        top++;
                    }
                }
            }
        }
        return msg;
    }

        /**
         * <b>Show info per genre song</b><br>
         * This method inform the statics for each genre.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform for each genre.<br>
         * @param genreType Genre type of the song
         * @return message
         */
    public String showInfoByGenreSong(int genreType) {
        int amountSales = 0;
        double sellTotalValue = 0;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song song = (Song) audios.get(i);
                if (song.getTypeGenre().equals(Genre.values()[genreType])) {
                    amountSales += song.getSalesNumber();
                    sellTotalValue += (song.getSalesNumber()*song.getPrice());
                }
            }
        }
        return "El número de canciones vendidas es: " + amountSales + " y el total en ventas es: $" + sellTotalValue;
    }

        /**
         * <b>Show best seller song</b><br>
         * This method show the best seller song.<br>
         * <b>pre:</b> Must enter the data type correctly.<br>
         * <b>post:</b> An inform of the best seller song.<br>
         * @return message
         */
    public String showBestSellerSong() {
        String msg = "Error, no hay canciones vendidas";
        Song max = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                Song song = (Song) audios.get(i);
                if (max == null) {
                    max = song;
                }
                if (song.getSalesNumber() > max.getSalesNumber()) {
                    max = song;
                }
            }
        }
        if (max != null) {
            if (max.getSalesNumber() > 0) {
                msg = "La canción más vendida es: " + max.getName() + ", con " + max.getSalesNumber() + " ventas, y el total en ventas es: $" + (max.getSalesNumber()*max.getPrice() + " ");
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
            if(objU == null){
                msg = "Error. El usuario no está creado";
            }else {
                double totalShop=pay-calculateCostSong(nameSong);
                if(totalShop<0){
                    msg = "Faltan: " + totalShop;
                }else {
                    if(objU instanceof Standard){
                        Standard objUser = (Standard) searchUser(idConsumer);
                        objUser.getAudios().add(objA);
                        objA.setSalesNumber(objA.getSalesNumber()+1);
                        Shop sale = new Shop(idConsumer);
                        sales.add(sale);
                        msg = "Compra realizada exitosamente, su devuelta es: " + totalShop;
                    }
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
        Audio objA = searchAudio(nameAudio);
        if(objU==null){
            msg="El usuario no está creado";
        }else{
            if(objU instanceof Premium){
                Premium objUser = (Premium) searchUser(idConsumer);
                msg = objUser.playAudio(nameAudio, audios);
            }else {
                Standard objUser = (Standard) searchUser(idConsumer);
                msg = objUser.playAudio(nameAudio, audios);
            }if(objA instanceof Song){
                Song song = (Song) objA;
                boolean flag = false;
                for(int i = 0; i<users.size() && !flag; i++){
                    if(users.get(i) instanceof Artist){
                        Artist artist = (Artist) users.get(i);
                        for(int j = 0; j<artist.getSongs().size()&&!flag; j++){
                            if(artist.getSongs().get(j).equals(song)){
                                artist.setTotalViews(artist.getTotalViews()+1);
                                artist.setTotalTimePlayed(artist.getTotalTimePlayed()+song.getDuration());
                                flag = true;
                            }
                        }
                    }
                }
            }else if(objA instanceof Podcast){
                Podcast podcast = (Podcast) objA;
                boolean flag = false;
                for(int i = 0; i<users.size() && !flag; i++){
                    if(users.get(i) instanceof Creator){
                        Creator creator = (Creator) users.get(i);
                        for(int j = 0; j<creator.getPodcasts().size() && !flag; j++){
                            if(creator.getPodcasts().get(j).equals(podcast)){
                                creator.setTotalViews(creator.getTotalViews()+1);
                                creator.setTotalTimePlayed(creator.getTotalTimePlayed()+podcast.getDuration());
                                flag = true;
                            }
                        }
                    }
                }
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
                objUser = new Premium(nickname, id, audios);
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
