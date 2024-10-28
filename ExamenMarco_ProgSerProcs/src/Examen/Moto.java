/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Examen;

/**
 *
 * @author FP
 */
public class Moto extends Thread{

    private String nombre;
    private Trayecto paquetes;
    private long inicio;

    public Moto(String nombre, Trayecto paquetes, long inicio) {
        this.nombre = nombre;
        this.paquetes = paquetes;
        this.inicio = inicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Examen.Trayecto getLista(){
        return paquetes;
    }
    
    public void setLista(Examen.Trayecto paquetes){
        this.paquetes = paquetes;
    }
    
    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getInicio() {
        return inicio;
    }

    private void tiempoTrayecto(int minutos) {
        try {
            Thread.sleep((minutos * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void run() {
        System.out.println("La moto " + this.nombre + "ha salido de casa "
                + paquetes.getNumero() + "En : " + (System.currentTimeMillis() - inicio) / 1000 + " min");

        for (int i = 0; i < paquetes.getPaquetes().length; i++) {
            this.tiempoTrayecto(paquetes.getPaquetes()[i]);
            System.out.println("llevando el pedido " + (i + 1) + " ->Tiempo: "
                    + (System.currentTimeMillis() - inicio) / 1000 + " min");
        }
        System.out.println("La moto " + this.nombre + " ha llevado todos los paquetes"
                + paquetes.getNumero() + " en : " + (System.currentTimeMillis() - inicio)
                / 1000 + " min");
        
        
    }
}
