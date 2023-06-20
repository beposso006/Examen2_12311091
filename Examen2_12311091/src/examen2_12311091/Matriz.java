/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2_12311091;

/**
 *
 * @author CARMEN POSSO
 */
public class Matriz {
    private int[][] matriz;
    private int[] pares;
    private int[] impares;
    private int filas;
    private int columnas;

    public Matriz(int[][] matriz) {
        this.matriz = matriz;
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
    }
}
