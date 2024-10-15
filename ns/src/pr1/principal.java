/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author marke
 */
public class principal {

    public static void main(String[] args) throws FileNotFoundException {

        File fichero = new File("fichero.txt");
        BufferedReader texto = new BufferedReader(new FileReader(fichero));

        Scanner teclado = new Scanner (System.in);

        System.out.println("insertar -1 \n leer -2");
        int opcion=0;
        
        if(opcion==1){
            System.out.println("Introduce el párrafo");
            String tarea = teclado.nextLine();
        }
    }
}
