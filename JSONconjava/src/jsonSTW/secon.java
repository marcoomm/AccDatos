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

            Pelicula re1 = new Pelicula("", "", "", "");
            Pelicula re2 = new Pelicula("", "", "", "");

            Especie e1 = new Especie("", "", "", "", "", "", "", "");
            Especie e2 = new Especie("", "", "", "", "", "", "", "");

            JSONObject jsonPersonaje = new JSONObject();
            jsonPersonaje.put("nombre", p1.getNombre());
            jsonPersonaje.put("height", p1.getAltura());

            p1.agregarPelicula(re1);
            p1.agregarPelicula(re2);
            p1.agregarEspecie(e1);
            p1.agregarEspecie(e2);

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
                
                String contenido = new String(Files.readAllBytes(Paths.get("starwars.json")));
                JSONArray personajes;
                
                personajes = new JSONArray(contenido);
                
                for (JSONObject personaje : personajesList) {
                    personajes.put(personaje);
                }

                Files.write(Paths.get("starwars.json"), personajes.toString(4).getBytes());

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }


