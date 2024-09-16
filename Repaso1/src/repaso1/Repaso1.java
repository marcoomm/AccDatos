/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso1;

import java.io.File;

/**
 *
 * @author FP
 */
public class Repaso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File f = new File("WINDOWS\\fortnite.xml");

        System.out.println("Nombre: " + f.getName());
        System.out.println("Ruta: " + f.getAbsolutePath());
        System.out.println("Directorio padre: " + f.getParent());
        System.out.println("Directorio: " + f.getPath());

        //System.out.println("Es un directorio?: "+ f.isDirectory());
        if (f.isDirectory() == false) {
            System.out.println(f.getName() + " No es un directorio");
        } else {
            System.out.println(f.getName() + " Es un directorio");
        }

        //System.out.println("El fichero existe?: "+ f.isFile());
        if (f.isFile() == false) {
            System.out.println(f.getName() + " No es un fichero");
        } else {
            System.out.println(f.getName() + " Es un fichero");
        }

        //System.out.println("El fichero existe?: "+ f.exists());
        if (f.exists() == false) {
            System.out.println(f.getName() + " El fichero no existe");
        } else {
            System.out.println(f.getName() + " El fichero existe");
        }

    }

}
