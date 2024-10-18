/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSONCurso;

import java.util.ArrayList;

/**
 *
 * @author FP
 */
public class Curso {

    private String curso;
    private ArrayList<UsuarioAvanzado> modulo;

    public Curso(String curso) {
        this.curso = curso;
        this.modulo = new ArrayList<UsuarioAvanzado>();
    }
    public String getNombre() {
        return curso;
    }
    public void setNombre(String nombre) {
        this.curso = nombre;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ArrayList<UsuarioAvanzado> getModulo() {
        return modulo;
    }

    public void setModulo(ArrayList<UsuarioAvanzado> modulo) {
        this.modulo = modulo;
    }

    public boolean agregarModulo(UsuarioAvanzado e) {
        return modulo.add(e);
    }

}
