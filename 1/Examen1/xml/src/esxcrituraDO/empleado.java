/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esxcrituraDO;

import java.util.ArrayList;
import org.w3c.dom.NodeList;

/**
 *
 * @author FP
 */
public class empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private String ciudad;

    public empleado(int id, String nombre, String apellidos, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    //NodeList nList = document.getElementByTagName("empleado");
    ArrayList<empleado> listaEmpleados = new ArrayList();    
}
