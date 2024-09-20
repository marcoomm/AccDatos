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
        String nombre = teclado.next();
        String apellido = teclado.next();
        String jefe = teclado.next();
        String departamento = teclado.next();

        String parrafo;
        
        while ((parrafo = texto.readLine()) != null) {
            if (parrafo.contains("$nombre")) {
                FileWriter fw = new FileWriter(fichero);
                fw.write(parrafo.replace("$nombre\n", nombre));
                fw.close();
            } /*else if (parrafo.contains("$apellido")) {
                parrafo.replace("$apellido", apellido);
            } else if (parrafo.contains("$jefe")) {
                parrafo.replace("$jefe", jefe);
            } else if (parrafo.contains("$departamento")) {
                parrafo.replace("$departamento", departamento);
            }else{
                
            }*/
        }
        
    }

}
