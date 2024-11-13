/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateempresa;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.*;
/**
 *
 * @author FP
 */
public class main {
    public static void main(String[] args) throws ParseException {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session sesion = sessionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        
        //Insercion de un departamento con metodo save
        //Departamentos d = new Departamentos((byte)62,"CONTABILIDAD", "GUADALAJARA");
        
        //Insercion de un departamento
        Departamentos d = new Departamentos((byte)62);
        //Date fecha = new Date();
        String formatofecha = "1992/08/23";
        SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy/MM/dd"); 
        //java.sql.Date formatoFecha = new java.sql.Date(fecha.getTime());
        Date fecha = formatoFecha.parse(formatofecha);
        Empleados e = new Empleados((short)4456,d,"CALVO","LIMPIADOR",(short)7499, fecha, (float) 1500, (float)100);
        
        //sesion.save(d);
        sesion.save(e);
        tx.commit();
        System.out.println("Registro injertado");
        sesion.close();
        sessionFactory.close();
    }
    
}
