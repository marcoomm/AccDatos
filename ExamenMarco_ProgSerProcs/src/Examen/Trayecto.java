/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

/**
 *
 * @author FP
 */
public class Trayecto {
    private int numero;
    private int[] tiempoPaquetes;

    public Trayecto(int numero, int[] paquetes) {
        this.numero = numero;
        this.tiempoPaquetes = paquetes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int[] getPaquetes() {
        return tiempoPaquetes;
    }

    public void setPaquetes(int[] paquetes) {
        this.tiempoPaquetes = paquetes;
    }
    
    
}
