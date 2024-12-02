/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package cdm.demo;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author FP
 */
public interface RepositorioAlumno extends CrudRepository<Alumno, Long> {
    
}
