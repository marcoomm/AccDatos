/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jsonconjava;

import org.json.*;
import static java.nio.file.Files.lines;

/**
 *
 * @author FP
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear usuarios
        UsuarioAvanzado usuario1
                = new UsuarioAvanzado("Jude Bellingham", 21);
        UsuarioAvanzado usuario2
                = new UsuarioAvanzado("Kylian Mbappé", 25);

        //Crear proyecto con participante
        Proyecto proyecto = new Proyecto("Copa de Europa 24/25 ");
        proyecto.agregarParticipante(usuario1);
        proyecto.agregarParticipante(usuario2);

        JSONObject jsonProyecto = new JSONObject();
        jsonProyecto.put("nombre", proyecto.getNombre());

        JSONArray jsonParticipantes = new JSONArray();
        for (UsuarioAvanzado participante : proyecto.getParticipantes()) {
            JSONObject jsonParticipante = new JSONObject();
            jsonParticipante.put("nombre", participante.getNombre());
            jsonParticipante.put("edad", participante.getEdad());
            jsonParticipantes.put(jsonParticipante);

        }
        jsonProyecto.put("Participantes", jsonParticipantes);
        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("proyecto.json"), jsonProyecto.toString().getBytes());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
