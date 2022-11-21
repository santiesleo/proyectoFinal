package ui;

import model.NeoTunes;
import javax.swing.*;
import java.util.Scanner;

public class Main {

    /**
     * A global variable to read the data supplied by the user
     */
    public static Scanner sc = new Scanner(System.in);
    public NeoTunes neoTunes = new NeoTunes();

    /**
     * <b>Main</b><br>
     * This method runs the entire program.<br>
     * @param args array receiving data from command line
     */
    public static void main(String[] args) {
        NeoTunes neoTunes = new NeoTunes();
        Main main = new Main();
        main.menu();
        System.out.println(neoTunes.addUser("Santi1714", "112233", "jadjadjjs", 1));
        System.out.println(neoTunes.addUser("Juan123", "123", "nasndnams", 2));
        System.out.println(neoTunes.addUser("Juan", "999", 1));
        System.out.println(neoTunes.addAudio("123", "Santiago", 3, "No sé", "jajdajkxax", 1));
        System.out.println(neoTunes.addAudio("123", "Santiago2", 3, "No sé", "jajdajkxax", 1));
        System.out.println(neoTunes.addAudio("112233", "The Nights", 3, "Hola", "jasjajsj", 19000, 2));
        System.out.println(neoTunes.addAudio("112233", "The Nights", 3, "Hola", "jasjajsj", 19000, 2));
        System.out.println(neoTunes.createPlaylist("999", "Hola", 2));
        System.out.println(neoTunes.sharePlaylist("999", "Hola"));
        System.out.println(neoTunes.reproduceAudio("999", "The Nights"));
        System.out.println(neoTunes.reproduceAudio("999", "The Nights"));
        System.out.println(neoTunes.reproduceAudio("999", "Santiago2"));
    }

    /**
     * This method displays all the options menu
     */
    public void menu(){
        boolean flag = false;
        while (!flag){
            System.out.println("1. Registrar un usuario\n" + "2. Registrar un audio\n" + "3. Crear una playlist\n" + "4. Editar una playlist\n" + "5. Compartir una playlist\n"
                    + "6. Reproducir un audio\n" + "7. Comprar una canción\n" + "Ingrese la opción que desea realizar:");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerAudio();
                    break;
                case 3:
                    createPlaylist();
                    break;
                case 4:
                    editPlaylist();
                    break;
                case 5:
                    sharePlaylist();
                    break;
                case 6:
                    reproduceAudio();
                    break;
                case 7:
                    buySong();
                    break;
                case 8:

                case 10:
                    System.out.println("¡Hasta luego!");
                    flag = true;
                    break;
                default:
                    System.out.println("Opción desconocida, ingrese otra");
                    break;
            }
        }
    }

    /**
     * This method register a user
     */
    public void registerUser(){
        System.out.println("Digite el nickname del usuario: ");
        String nickname = sc.nextLine();
        System.out.println("Digite el id del usuario: ");
        String id = sc.nextLine();
        System.out.println("1. Productor\n" + "2. Consumidor\n" + "Qué tipo de usuario requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1:
                registerProducer(nickname, id);
                break;
            case 2:
                registerConsumer(nickname, id);
                break;
            default:
                System.out.println("Opción desconocida, ingrese otra.");
                break;
        }
    }

    /**
     * This method register a producer
     */
    public void registerProducer(String nickname, String id){
        System.out.println("Ingrese la foto de perfil: ");
        String profilePicture = sc.nextLine();
        System.out.println("1. Artista\n" + "2. Creador\n" + "Qué tipo de productor requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addUser(nickname, id, profilePicture, option));
    }

    /**
     * This method register a consumer
     */
    public void registerConsumer(String nickname, String id){
        System.out.println("1. Estándar\n" + "2. Premium\n" + "Qué tipo de consumidor requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addUser(nickname, id, option));
    }

    /**
     * This method register an audio
     */
    public void registerAudio(){
        System.out.println("Digite el id del productor del audio: ");
        String idProducer = sc.nextLine();
        System.out.println("Digite el nombre del audio: ");
        String name = sc.nextLine();
        System.out.println("Digite la duración del audio: ");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.println("1. Canción\n" + "2. Podcast\n" + "Qué tipo de audio requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1:
                registerSong(idProducer, name, duration);
                break;
            case 2:
                registerPodcast(idProducer, name, duration);
                break;
            default:
                System.out.println("Opción desconocida, ingrese otra.");
                break;
        }
    }

    /**
     * This method register a song
     */
    public void registerSong(String idProducer, String name, int duration){
        System.out.println("Digite el nombre del álbum:");
        String album = sc.nextLine();
        System.out.println("Ingrese la caratula del álbum:");
        String albumCover = sc.nextLine();
        System.out.println("Digite el precio de la canción:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("1. Rock\n" + "2. Pop\n" + "3. Trap\n" + "4. House\n" + "Digite de qué tipo es la canción:");
        int typeSong = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addAudio(idProducer, name, duration, album, albumCover, price, typeSong));
    }

    /**
     * This method register a podcast
     */
    public void registerPodcast(String idProducer, String name, int duration){
        System.out.println("Digite una descripción del podcast:");
        String description = sc.nextLine();
        System.out.println("Digite el ícono del podcast:");
        String icon = sc.nextLine();
        System.out.println("1. Pítica\n" + "2. Entretenimiento\n" + "3. Videojuegos\n" + "4. Moda\n" + "Digite de qué tipo es el podcast:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addAudio(idProducer, name, duration, description, icon, option));
    }

    /**
     * This method create a playlist
     */
    public void createPlaylist(){
        System.out.println("Digite el identificador del usuario:");
        String idConsumer = sc.nextLine();
        System.out.println("Digite el nombre de la playlist:");
        String namePlaylist = sc.nextLine();
        System.out.println("1. Song\n2. Podcast\n3. Ambos\nIngrese el tipo de playlist:");
        int optionPlaylist = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.createPlaylist(idConsumer, namePlaylist, optionPlaylist));
    }

    /**
     * This method edit a playlist
     */
    public void editPlaylist(){
        System.out.println("Ingrese el identificador del usuario:");
        String idConsumer = sc.nextLine();
        System.out.println("Ingrese el nombre de la playlist:");
        String namePlaylist = sc.nextLine();
        System.out.println("1. Cambiar el nombre de la playlist\n2. Añadir una canción\n3. Eliminar una canción\nIngrese la opción que desea realizar:");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1:
                System.out.println("Ingrese el nuevo nombre de la playlist:");
                String newNamePlaylist = sc.nextLine();
                System.out.println(neoTunes.editNamePlaylist(idConsumer, namePlaylist, newNamePlaylist));
                break;
            case 2:
                System.out.println("Ingrese el nombre del audio:");
                String nameAudio = sc.nextLine();
                System.out.println(neoTunes.addDeleteAudioPlaylist(idConsumer, namePlaylist, nameAudio, option));
                break;
            case 3:
                System.out.println("Ingrese el nombre del audio:");
                String nameAudio2 = sc.nextLine();
                System.out.println(neoTunes.addDeleteAudioPlaylist(idConsumer, namePlaylist, nameAudio2, option));
                break;
            default:
                System.out.println("Opción desconocida");
                break;
        }
    }

    /**
     * This method shares the playlist code
     */
    public void sharePlaylist(){
        System.out.println("Ingrese el identificador del usuario:");
        String idConsumer = sc.nextLine();
        System.out.println("Ingrese el nombre de la playlist");
        String namePlaylist = sc.nextLine();
        System.out.println(neoTunes.sharePlaylist(idConsumer, namePlaylist));
    }

    /**
     * This method reproduces an audio
     */
    public void reproduceAudio(){
        System.out.println("Ingrese el identificador del usuario:");
        String idConsumer = sc.nextLine();
        System.out.println("Ingrese el nombre del audio:");
        String nameAudio = sc.nextLine();
        System.out.println(neoTunes.reproduceAudio(idConsumer, nameAudio));
    }

    /**
     * This method buys a song
     */
    public void buySong() {
        System.out.println("Ingrese el identificador del usuario:");
        String idConsumer = sc.nextLine();
        System.out.println("Ingrese el nombre de la canción:");
        String nameSong = sc.nextLine();
        System.out.println("El valor a pagar por esa canción, es: " + neoTunes.calculateCostSong(nameSong));
        System.out.println("Ingrese el pago que va a realizar:");
        double pay = sc.nextDouble();
        sc.nextLine();
        System.out.println(neoTunes.buySong(idConsumer, nameSong, pay));
    }
}
