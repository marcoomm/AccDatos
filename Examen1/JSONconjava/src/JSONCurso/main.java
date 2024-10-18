/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSONCurso;

import java.io.IOException;
import jsonconjava.Proyecto;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FP
 */
public class main {

    
    public static void main(String[] args) throws IOException {

        // Crear usuarios
        UsuarioAvanzado modulo1
                = new UsuarioAvanzado("Jude Bellingham", 21, 0.0);
        UsuarioAvanzado modulo2
                = new UsuarioAvanzado("Kylian Mbappé", 25, 0.0);

        //Crear proyecto con participante
        Curso curso = new Curso("temporada 24/25 ");
        curso.agregarModulo(modulo1);
        curso.agregarModulo(modulo2);

        JSONObject jsonProyecto = new JSONObject();
        jsonProyecto.put("curso", curso.getNombre());

        JSONArray jsonCursos = new JSONArray();
        for (UsuarioAvanzado variable : curso.getModulo()) {
            JSONObject jsonCurso = new JSONObject();
            jsonCurso.put("nombre", variable.getNombre());
            jsonCurso.put("horas", variable.getHoras());
            jsonCurso.put("nota", variable.getNota());
            jsonCursos.put(jsonCurso);

        }
        jsonProyecto.put("Participantes", jsonCursos);
        java.nio.file.Files.write(java.nio.file.Paths.get("proyecto.json"), jsonProyecto.toString().getBytes());
    }
    
    

    
}
