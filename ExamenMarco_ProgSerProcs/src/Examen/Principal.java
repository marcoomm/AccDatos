/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {
        Trayecto t1 = new Trayecto(1, new int[]{3, 6, 10, 1, 5});
        Trayecto t2 = new Trayecto(1, new int[]{4, 7, 8, 6, 5});
        

        long inicio = System.currentTimeMillis();
        long extra = 500;
        Moto moto1 = new Moto("Pakito", t1, inicio);
        Moto moto2 = new Moto("El primo pakito", t2, inicio);
        

        moto1.start();
        moto2.start();
        
    }

}
