/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

/**
 *
 * @author marke
 */
public class Especie {
    private String nombre;
    private String clasificacion;
    private String desig;
    private String media;
    private String piel;
    private String pelo;
    private String vida;
    private String idioma;
   

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getDesig() {
        return desig;
    }
    public void setDesig(String desig) {
        this.desig = desig;
    }
    public String getMedia() {
        return media;
    }
    public void setMedia(String media) {
        this.media = media;
    }
    public String getPiel() {
        return piel;
    }
    public void setPiel(String piel) {
        this.piel = piel;
    }
    public String getPelo() {
        return pelo;
    }
    public void setPelo(String pelo) {
        this.pelo = pelo;
    }
    public String getVida() {
        return vida;
    }
    public void setVida(String vida) {
        this.vida = vida;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Especie(String nombre, String clasificacion, String desig, String media, String piel, String pelo, String vida, String idioma) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.desig = desig;
        this.media = media;
        this.piel = piel;
        this.pelo = pelo;
        this.vida = vida;
        this.idioma = idioma;
    }
    
    

}
