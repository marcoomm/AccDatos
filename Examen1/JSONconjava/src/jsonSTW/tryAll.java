/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonSTW;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author marke
 */
public class tryAll {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción: 1 - Leer, 2 - Insertar, 3 - Actualizar, 4 - Borrar");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        try {
            String contenido = new String(Files.readAllBytes(Paths.get("starwars.json")));
            JSONArray personajes = new JSONArray(contenido);

            switch (opcion) {
                case 1: // Leer
                    for (int i = 0; i < personajes.length(); i++) {
                        System.out.println(personajes.getJSONObject(i).toString(4));
                    }
                    break;

                case 2: // Insertar
                    insertarPersonaje(personajes);
                    Files.write(Paths.get("starwars.json"), personajes.toString(4).getBytes());
                    break;

                case 3: // Actualizar
                    System.out.println("Introduce el nombre del personaje a actualizar:");
                    String nombreActualizar = scanner.nextLine();
                    actualizarPersonaje(personajes, nombreActualizar);
                    Files.write(Paths.get("starwars.json"), personajes.toString(4).getBytes());
                    break;

                case 4: // Borrar
                    System.out.println("Introduce el nombre del personaje a borrar:");
                    String nombreBorrar = scanner.nextLine();
                    borrarPersonaje(personajes, nombreBorrar);
                    Files.write(Paths.get("starwars.json"), personajes.toString(4).getBytes());
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void insertarPersonaje(JSONArray personajes) {
        // Aquí puedes agregar el código para crear un personaje como lo hacías antes.
        // Ejemplo:
        JSONObject nuevoPersonaje = new JSONObject();
        nuevoPersonaje.put("nombre", "Nuevo Personaje");
        nuevoPersonaje.put("height", "180");
        personajes.put(nuevoPersonaje);
    }

    private static void actualizarPersonaje(JSONArray personajes, String nombre) {
        for (int i = 0; i < personajes.length(); i++) {
            JSONObject personaje = personajes.getJSONObject(i);
            if (personaje.getString("nombre").equalsIgnoreCase(nombre)) {
                // Actualiza los campos del personaje según sea necesario.
                personaje.put("name", "200"); // Ejemplo de actualización
                System.out.println("Personaje actualizado.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    private static void borrarPersonaje(JSONArray personajes, String nombre) {
        for (int i = 0; i < personajes.length(); i++) {
            JSONObject personaje = personajes.getJSONObject(i);
            if (personaje.getString("nombre").equalsIgnoreCase(nombre)) {
                personajes.remove(i);
                System.out.println("Personaje borrado.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }
}
