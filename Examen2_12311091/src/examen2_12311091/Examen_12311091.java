/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2_12311091;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Examen_12311091 extends JFrame {
    private int[][] matriz;

    public Examen_12311091(int[][] matriz) {
        this.matriz = matriz;
        setTitle("Menú de Matriz");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton creacionBtn = new JButton("Creación");
        JButton modificacionBtn = new JButton("Modificación");
        JButton salirBtn = new JButton("Salir");

        creacionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] pares = obtenerPares();
                int[] impares = obtenerImpares();
                int[][] matrizOrdenada = ordenarMatriz(pares, impares);
                print(matrizOrdenada);
            }
        });

        modificacionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarMatriz();
            }
        });

        salirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(new FlowLayout());
        add(creacionBtn);
        add(modificacionBtn);
        add(salirBtn);
    }

    private int[] obtenerPares() {
        int count = 0;
        for (int[] filas : matriz) {
            for (int num : filas) {
                if (num % 2 == 0) {
                    count++;
                }
            }
        }

        int[] pares = new int[count];
        int index = 0;
        for (int[] filas : matriz) {
            for (int num : filas) {
                if (num % 2 == 0) {
                    pares[index] = num;
                    index++;
                }
            }
        }

        return pares;
    }

    private int[] obtenerImpares() {
        int count = 0;
        for (int[] filas : matriz) {
            for (int num : filas) {
                if (num % 2 != 0) {
                    count++;
                }
            }
        }

        int[] impares = new int[count];
        int index = 0;
        for (int[] filas : matriz) {
            for (int num : filas) {
                if (num % 2 != 0) {
                    impares[index] = num;
                    index++;
                }
            }
        }

        return impares;
    }

    private int[][] ordenarMatriz(int[] pares, int[] impares) {
        int filas = matriz.length;
        int cols = matriz[0].length;
        int[][] matrizOrdenada = new int[filas][cols];

        Arrays.sort(pares);
        Arrays.sort(impares);

        int parIndex = 0;
        int imparIndex = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                if (j % 2 == 0) {
                    if (parIndex < pares.length) {
                        matrizOrdenada[i][j] = pares[parIndex];
                        parIndex++;
                    } else {
                        matrizOrdenada[i][j] = 0;
                    }
                } else {
                    if (imparIndex < impares.length) {
                        matrizOrdenada[i][j] = impares[imparIndex];
                        imparIndex++;
                    } else {
                        matrizOrdenada[i][j] = -1;
                    }
                }
            }
        }

        return matrizOrdenada;
    }

    
    public String print(int[][] matriz) {
        StringBuilder resu = new StringBuilder();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resu.append("[").append(matriz[i][j]).append("]");
            }
            resu.append("\n");
        }
        return resu.toString();
    }
    private void modificarMatriz() {
        int rows = matriz.length;
        int cols = matriz[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String input = JOptionPane.showInputDialog("Ingrese el nuevo valor para matriz[" + i + "][" + j + "]");
                int newValue = Integer.parseInt(input);
                matriz[i][j] = newValue;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

         Examen_12311091 examen2_12311091 = new Examen_12311091(matriz);
        examen2_12311091.setVisible(true);
    }
}

