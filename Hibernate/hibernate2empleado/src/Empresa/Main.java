/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import org.hibernate.*;

/**
 *
 * @author FP
 */
public class Main {
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        
        //Insercion de un departamento con metodo save
        //Departamentos d = new Departamentos((byte)62,"CONTABILIDAD", "GUADALAJARA");
        
        //Insercion de un departamento
        Departamentos d = new Departamentos((byte)62);
        Empleados e = new Empleados((short)4455,d,"CALVO","LIMPIADOR",(short)7499);
        
        //sesion.save(d);
        tx.commit();
        System.out.println("Registro insertado");
        sesion.close();
        sessionFactory.close();
    }
    
}
