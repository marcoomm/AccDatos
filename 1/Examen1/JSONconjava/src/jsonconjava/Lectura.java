/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsonconjava;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FP
 */
public class Lectura {
    public static void main(String[] args) {
        
        try{
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("proyecto.json")));
            JSONObject jsonLeido = new JSONObject(contenido);
            String nombreProyecto = jsonLeido.getString("nombre");
            
            JSONArray jsonParticipantesLeidos =jsonLeido.getJSONArray("Participantes");

            Proyecto proyectoLeido = new Proyecto(nombreProyecto);
            for(int i=0;i<jsonParticipantesLeidos.length();i++){
                JSONObject jsonParticipante = jsonParticipantesLeidos.getJSONObject(i);
                String nombreParticipante = jsonParticipante.getString("nombre");
                int edadParticipante = jsonParticipante.getInt("edad");
                
                UsuarioAvanzado participanteLeido = new UsuarioAvanzado(nombreParticipante,edadParticipante);
                proyectoLeido.agregarParticipante(participanteLeido);
                
                System.out.println("Proyecto: "+proyectoLeido.getNombre());
                System.out.println("Participantes: ");
                for(UsuarioAvanzado participante : proyectoLeido.getParticipantes()){
                    System.out.println("- "+participante.getNombre()+ ", Edad: "+participante.getEdad());
                    
                }
            }
        }catch(java.io.IOException e){
            e.printStackTrace();
        }
    }
}
