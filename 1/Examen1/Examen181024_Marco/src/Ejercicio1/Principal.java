package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    private static void procesarLineaConfiguracion(String linea) {
        String[] partes = linea.split("=");
        if (partes.length == 2) {
            if (linea.startsWith("#") == false) {
                String parte1 = partes[0].trim();
                String parte2 = partes[1].trim();
                System.out.println("Parte1: "+parte1+ " Parte2: "+parte2);
            }
        } 
        else {
        }
    }

    public static void main(String[] args) {
        //String archivoConfiguracion = "C:\\Users\\FP\\Desktop\\AccDatos\\Examen181024_Marco\\src\\Ejercicio1\\vsftpd.conf";
        String archivoConfiguracion = "C:\\Users\\marke\\Desktop\\AccDatos\\Examen181024_Marco\\src\\Ejercicio1\\vsftpd.conf";
        try (BufferedReader lector
                = new BufferedReader(
                        new FileReader(archivoConfiguracion))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                procesarLineaConfiguracion(linea);
            }
        } catch (IOException e) {
            System.err.println("Error..." + e.getMessage());
        }
    }
}
