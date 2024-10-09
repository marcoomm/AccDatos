/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

/**
 *
 * @author FP
 */
class PeliAvanzada {
    
    private String title;
    private String episode;
    private String opening;
    private String director;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
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

    public PeliAvanzada(String title, String episode, String opening, String director) {
        this.title = title;
        this.episode = episode;
        this.opening = opening;
        this.director = director;
    }
    
    
    
}
