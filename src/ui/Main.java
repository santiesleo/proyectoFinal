package ui;

import model.NeoTunes;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public NeoTunes neoTunes = new NeoTunes();

    public static void main(String[] args){
        NeoTunes neoTunes = new NeoTunes();
        System.out.println(neoTunes.addUser("Santi1714", "112233", "jadjadjjs", 1));
        System.out.println(neoTunes.addUser("Juan123", "123", "nasndnams", 2));
        System.out.println(neoTunes.addAudio("123", "Santiago Es El Mejor", "3", "Clásicos de Santiago", "jajdajkxax", 1));
        System.out.println(neoTunes.addAudio("112233", "Bellacoso", "3", "Hola", "jasjajsj", 19000, 2));
    }

    public void menu(){
        boolean flag = false;
        while (!flag){
            System.out.println("1. Registrar un usuario\n" + "2. ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerAudio();
                    break;
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

    public void registerProducer(String nickname, String id){
        System.out.println("Ingrese la foto de perfil: ");
        String profilePicture = sc.nextLine();
        System.out.println("1. Artista\n" + "2. Creador\n" + "Qué tipo de productor requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addUser(nickname, id, profilePicture, option));
    }

    public void registerConsumer(String nickname, String id){
        System.out.println("1. Estándar\n" + "2. Premium\n" + "Qué tipo de consumidor requiere registrar:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addUser(nickname, id, option));
    }

    public void registerAudio(){
        System.out.println("Digite el id del productor del audio: ");
        String idProducer = sc.nextLine();
        System.out.println("Digite el nombre del audio: ");
        String name = sc.nextLine();
        System.out.println("Digite la duración del audio: ");
        String duration = sc.nextLine();
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

    public void registerSong(String idProducer, String name, String duration){
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

    public void registerPodcast(String idProducer, String name, String duration){
        System.out.println("Digite una descripción del podcast:");
        String description = sc.nextLine();
        System.out.println("Digite el ícono del podcast:");
        String icon = sc.nextLine();
        System.out.println("1. Pítica\n" + "2. Entretenimiento\n" + "3. Videojuegos\n" + "4. Moda\n" + "Digite de qué tipo es el podcast:");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println(neoTunes.addAudio(idProducer, name, duration, description, icon, option));
    }

    public void pruebaMatriz(){
        int matriz[][],nFilas, nCol;

        nFilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas: "));
        nCol = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas: "));

        matriz = new int[nFilas][nCol];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz[i][j]= (int)(Math.random()*(10-1))+1;
            }
        }

        /**
         * System.out.println("Digite la matriz: ");
         *         for(int i = 0; i<nFilas;i++){
         *             for(int j = 0; j<nCol;j++){
         *                 System.out.print("Matriz ["+i+"] ["+j+"]: " );
         *                 matriz[i][j] = sc.nextInt();
         *             }
         *         }
         */

        System.out.println("\nLa matriz es: ");
        for(int i=0; i<nFilas;i++){ //Primer for, recorrer número de filas
            for(int j = 0; j<nCol;j++){  //Segundo for, recorrer número de columnas
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");
        StringBuilder code = new StringBuilder();

        for(int i = matriz[0].length-1; i>-1;i--){
            code.append(Integer.toString(matriz[i][0]));
        }for(int i = 1; i<5;i++){
            code.append(Integer.toString(matriz[i][i]));
        }for(int i = matriz[0].length-1;i>-1;i--){
            code.append(Integer.toString(matriz[i][5]));
        }
        System.out.println(code);
    }
}
