 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package cdm.demo;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author FP
 */
@Service
public class ServicioUsuario {
    
    private final RepositorioAlumno repositorioAlumno;

    public ServicioUsuario(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }
    
    
    
    public List<Alumno> obtenerTodos(){
        return (List<Alumno>) repositorioAlumno.findAll();
    }
    
}
