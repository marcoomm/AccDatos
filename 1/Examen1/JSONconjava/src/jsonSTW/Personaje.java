 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

import java.util.ArrayList;

/**
 *
 * @author FP
 */
public class Personaje {

   private String nombre;
   private String altura;
   private ArrayList<Pelicula> peliculas;
   private ArrayList<Especie> especie;

   public String getNombre() {
       return nombre;
   }

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getAltura() {
       return altura;
   }

   public void setAltura(String altura) {
       this.altura = altura;
   }

   public ArrayList<Pelicula> getPeliculas() {
       return peliculas;
   }

   public void setPeliculas(ArrayList<Pelicula> peliculas) {
       this.peliculas = peliculas;
   }

   public Personaje(String nombre, String altura) {
       this.nombre = nombre;
       this.altura = altura;
       this.peliculas = new ArrayList<>();
        this.especie = new ArrayList<>();
   }

    public ArrayList<Especie> getEspecie() {
        return especie;
    }

    public void setEspecie(ArrayList<Especie> especie) {
        this.especie = especie;
    }
  
   public boolean agregarPelicula(Pelicula e) {
       return peliculas.add(e);
   }
   
   public boolean agregarEspecie(Especie e){
       return especie.add(e);
   }
   
}
