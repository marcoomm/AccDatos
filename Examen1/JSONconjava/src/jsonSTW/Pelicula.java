/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

/**
 *
 * @author marke
 */
class Pelicula {

   private String titulo;
   private String episodio;
   private String opening;
   private String director;

   public String getTitulo() {
       return titulo;
   }
   public void setTitulo(String titulo) {
       this.titulo = titulo;
   }
   public String getEpisodio() {
       return episodio;
   }
   public void setEpisodio(String episodio) {
       this.episodio = episodio;
   }
   public String getOpening() {
       return opening;
   }
   public void setOpening(String opening) {
       this.opening = opening;
   }
   public String getDirector() {
       return director;
   }
   public void setDirector(String director) {
       this.director = director;
   }
   public Pelicula(String titulo, String episodio, String opening, String director) {
       this.titulo = titulo;
       this.episodio = episodio;
       this.opening = opening;
       this.director = director;
   }
}
