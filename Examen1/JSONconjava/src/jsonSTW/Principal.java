/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {

        Pelicula peli1 = new Pelicula("The Empire Strikes Back", "5", "It is a dark time for the\r\nRebellion. Although the Death\r\nStar has been destroyed,\r\nImperial troops have driven the\r\nRebel forces from their hidden\r\nbase and pursued them across\r\nthe galaxy.\r\n\r\nEvading the dreaded Imperial\r\nStarfleet, a group of freedom\r\nfighters led by Luke Skywalker\r\nhas established a new secret\r\nbase on the remote ice world\r\nof Hoth.\r\n\r\nThe evil lord Darth Vader,\r\nobsessed with finding young\r\nSkywalker, has dispatched\r\nthousands of remote probes into\r\nthe far reaches of space....", "Irvin Kershner");
        Pelicula peli2 = new Pelicula("Revenge of the Sith", "3", "War! The Republic is crumbling\r\nunder attacks by the ruthless\r\nSith Lord, Count Dooku.\r\nThere are heroes on both sides.\r\nEvil is everywhere.\r\n\r\nIn a stunning move, the\r\nfiendish droid leader, General\r\nGrievous, has swept into the\r\nRepublic capital and kidnapped\r\nChancellor Palpatine, leader of\r\nthe Galactic Senate.\r\n\r\nAs the Separatist Droid Army\r\nattempts to flee the besieged\r\ncapital with their valuable\r\nhostage, two Jedi Knights lead a\r\ndesperate mission to rescue the\r\ncaptive Chancellor....", "George Lucas");

        Personaje p1 = new Personaje("Luke Skywalker", "172");
        p1.agregarPelicula(peli1);
        p1.agregarPelicula(peli2);

        JSONObject jsonPersonaje = new JSONObject();

        jsonPersonaje.put("name", p1.getNombre());
        jsonPersonaje.put("height", p1.getAltura());

        JSONArray jsonPeliculas = new JSONArray();

        for (Pelicula info : p1.getPeliculas()) {

            JSONObject jsonPelicula = new JSONObject();
            jsonPelicula.put("title", info.getTitulo());
            jsonPelicula.put("episode_id", info.getEpisodio());
            jsonPelicula.put("opening_crawl", info.getOpening());
            jsonPelicula.put("director", info.getDirector());

            jsonPeliculas.put(jsonPelicula);
        }
        jsonPersonaje.put("films", jsonPeliculas);

        Especie esp1 = new Especie("Human", "mammal", "sentient", "180", "caucasian, black, asian, hispanic", "blonde, brown, black, red", "120", "Galactic Basic");
        p1.agregarEspecie(esp1);

        JSONArray jsonEspecies = new JSONArray();
        for (Especie info : p1.getEspecie()) {
            JSONObject jsonEspecie = new JSONObject();
            jsonEspecie.put("name", info.getNombre());
            jsonEspecie.put("classification", info.getClasificacion());
            jsonEspecie.put("designation", info.getDesig());
            jsonEspecie.put("average_height", info.getMedia());
            jsonEspecie.put("skin_colors", info.getPiel());
            jsonEspecie.put("hair_colors", info.getPelo());
            jsonEspecie.put("average_lifespan", info.getVida());
            jsonEspecie.put("language", info.getIdioma());

            jsonEspecies.put(jsonEspecie);
        }
        jsonPersonaje.put("species", jsonEspecies);
        
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("prueba.json"), jsonPersonaje.toString(4).getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
