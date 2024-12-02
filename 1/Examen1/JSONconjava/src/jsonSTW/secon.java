/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FP
 */
public class secon {

    public static void main(String[] args) {
        // Crear una lista para almacenar los personajes
        ArrayList<JSONObject> personajesList = new ArrayList<>();

        // Crear un personaje
        Personaje p1 = new Personaje("Comandante Nail", "enano");
        Personaje p2 = new Personaje("Soldier of God, Rick", "Gigant");

        Pelicula re1 = new Pelicula("1", "2", "3", "4");
        Pelicula re2 = new Pelicula("1", "2", "3", "4");

        Especie e1 = new Especie("1", "5", "7", "9", "1", "1", "1", "1");
        Especie e2 = new Especie("1", "34", "", "25", "1", "1", "1", "1");

        JSONObject jsonPersonaje = new JSONObject();
        jsonPersonaje.put("nombre", p1.getNombre());
        jsonPersonaje.put("height", p1.getAltura());

        JSONObject jsonPersonaje2 = new JSONObject();
        jsonPersonaje2.put("nombre", p2.getNombre());
        jsonPersonaje2.put("height", p2.getAltura());

        p1.agregarPelicula(re1);
        p2.agregarPelicula(re2);
        p1.agregarEspecie(e1);
        p2.agregarEspecie(e2);

        JSONArray jsonPeliculas = new JSONArray();
        JSONArray jsonEspecies = new JSONArray();

        for (Pelicula info : p1.getPeliculas()) {
            JSONObject jsonPelicula = new JSONObject();
            jsonPelicula.put("title", info.getTitulo());
            jsonPelicula.put("episode_id", info.getEpisodio());
            jsonPelicula.put("opening", info.getOpening());
            jsonPelicula.put("director", info.getDirector());
            jsonPeliculas.put(jsonPelicula);
        }

        jsonPersonaje.put("films", jsonPeliculas);

        for (Especie info : p1.getEspecie()) {
            JSONObject jsonEspecie = new JSONObject();
            jsonEspecie.put("name", info.getNombre());
            jsonEspecie.put("classification", info.getClasificacion());
            jsonEspecie.put("designation", info.getDesig());
            jsonEspecie.put("average_height", info.getMedia());
            jsonEspecie.put("skin_color", info.getPiel());
            jsonEspecie.put("hair_color", info.getPelo());
            jsonEspecie.put("average_lifespan", info.getVida());
            jsonEspecie.put("language", info.getIdioma());
            jsonEspecies.put(jsonEspecie);
        }

        jsonPersonaje.put("species", jsonEspecies);

        personajesList.add(jsonPersonaje);

        try {
            JSONArray personajes = new JSONArray();

            for (JSONObject personaje : personajesList) {
                personajes.put(personaje);
            }
            System.out.println("Lectura: ");
            System.out.println("*******************************************");
            for (int i = 0; i < personajes.length(); i++) {
                System.out.println(personajes.getJSONObject(i).toString(4));
                System.out.println("____________________________________________");
            }

            Files.write(Paths.get("starwars.json"), personajes.toString(4).getBytes());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
        /*JSONArray jsonPeliculas2 = new JSONArray();
        JSONArray jsonEspecies2 = new JSONArray();

        for (Pelicula info : p2.getPeliculas()) {
            JSONObject jsonPelicula = new JSONObject();
            jsonPelicula.put("title", info.getTitulo());
            jsonPelicula.put("episode_id", info.getEpisodio());
            jsonPelicula.put("opening", info.getOpening());
            jsonPelicula.put("director", info.getDirector());
            jsonPeliculas2.put(jsonPelicula);
        }

        jsonPersonaje2.put("films", jsonPeliculas2);

        for (Especie info : p2.getEspecie()) {
            JSONObject jsonEspecie = new JSONObject();
            jsonEspecie.put("name", info.getNombre());
            jsonEspecie.put("classification", info.getClasificacion());
            jsonEspecie.put("designation", info.getDesig());
            jsonEspecie.put("average_height", info.getMedia());
            jsonEspecie.put("skin_color", info.getPiel());
            jsonEspecie.put("hair_color", info.getPelo());
            jsonEspecie.put("average_lifespan", info.getVida());
            jsonEspecie.put("language", info.getIdioma());
            jsonEspecies2.put(jsonEspecie);
        }
personajesList.add(jsonPersonaje2);
        jsonPersonaje2.put("species", jsonEspecies2);*/
