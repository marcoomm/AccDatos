/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso3.fw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class Repaso3FW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        File fichero = new File("empleados.txt");
        BufferedReader texto = new BufferedReader(new FileReader(fichero));

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre, apellido, jefe y departamento");
        String nombre = teclado.nextLine();
        String apellido = teclado.nextLine();
        String jefe = teclado.nextLine();
        String departamento = teclado.nextLine();

        String carta = ""; 
        String parrafo;
        while ((parrafo = texto.readLine()) != null) {
            parrafo = parrafo.replace("$nombre", nombre)
                    .replace("$apellidos", apellido)
                    .replace("$jefe", jefe)
                    .replace("$departamento", departamento);
            
            carta += parrafo + "\n";
        }
        texto.close();

        FileWriter fw = new FileWriter(fichero);
        fw.write(carta);
        fw.close();

    }

}
