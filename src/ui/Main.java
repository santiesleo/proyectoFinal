package ui;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
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
