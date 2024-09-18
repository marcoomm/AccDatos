/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author FP
 */
public class Repaso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //palabra
        //caracteres sin espacios
        //caracteres con espacios
        //lineas

        /*String linea="";
       int palabra=0;
       int lineas=0; 
       int longitud=0;
       int espacios=0;
       int longitudsin=0;*/
 /*longitud=longitud+ parrafo.length();
        /*
        for(int i=0;i<=lineas;i++){
            if(linea==" "){
                espacios+=1;
                parrafo+=1;
               
            }
            
        }
        parrafo+=1;
        lineas+=1;
         *//*
        int i=0;
        while((linea=texto.readLine())!=null){
            
            if(linea.charAt(parrafo)==" "){
                
            }
        }
         */
       //Número de líneas
        /*System.out.println("Num lineas: "+lineas);  
    System.out.println("Num de c con espacios: "+longitud);
    System.out.println("Num de c sin espacios: "+longitudsin);
         */
        
        
        
        //Fichero de tipo File
        File f = new File("fichero.txt");
        
        //BufferedReader + FileReader
        BufferedReader texto = new BufferedReader(new FileReader(f));
        
        //Bucle while
        String parrafo;
        String parrafoSin;
        int caracteres = 0;
        int caracteresSin=0;
        int veces = 0;
        double lineasD = 0.0;
        while ((parrafo = texto.readLine()) != null) {
            veces++;
            caracteres += parrafo.length();
            parrafoSin = parrafo;
            parrafoSin=parrafoSin.replace(" ","");
            caracteresSin+=parrafoSin.length();
            
            
             
        }   
        //contar lineas con redondo hacia arriba
        lineasD=(double)caracteres/95;
        int lineasFinal= (int) Math.ceil(lineasD);
        System.out.println("Caracteres totales sin espacio: " + caracteresSin);
        System.out.println("Caracteres totales: " + caracteres);
        System.out.println("Número de párrafos: " + veces);
        System.out.println("Número de lineas: "+lineasFinal);
 

    }

}
