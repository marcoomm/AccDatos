/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateempresa;

/**
 *
 * @author FP
 */
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernateempresa.Departamentos;
import hibernateempresa.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ListaDepartamentos {

    public static void main(String[] args) throws ParseException {

        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();

        System.out.println("===========================================");

        //consulta 1
        Query q = session.createQuery("from Departamentos");
        q.setFetchSize(10);
        Iterator<Departamentos> iter = q.iterate();

        while (iter.hasNext()) {
            Departamentos depar = (Departamentos) iter.next();
            System.out.println(depar.getDeptNo() + ", " + depar.getDNombre());
        }

        System.out.println("==========================================");

        //consulta 2
        Query q2 = session.createQuery("from Empleados as e where e.departamentos.deptNo=20");
        List<Empleados> lista2 = q2.list();
        Iterator<Empleados> iter2 = lista2.iterator();

        while (iter2.hasNext()) {
            Empleados emp = (Empleados) iter2.next();
            System.out.println(emp.getApellido() + ", " + emp.getSalario());
        }

        System.out.println("===========================================");

        //consulta 3
        String hql = "from Empleados where empNo = :numemple";
        Query q3 = session.createQuery(hql);

        q3.setParameter("numemple", (short) 7369);
        Empleados emple = (Empleados) q3.uniqueResult();
        System.out.println(emple.getApellido() + ", " + emple.getOficio());

        List<Empleados> lista3 = q3.list();
        Iterator<Empleados> iter3 = lista3.iterator();

        System.out.println("===========================================");

        //consult 4
        String hql2 = "from Empleados emp where emp.departamentos.deptNo = :ndep and emp.oficio = :ofi";
        Query q4 = session.createQuery(hql2);

        q4.setParameter("ndep", (byte) 30);
        q4.setParameter("ofi", "VENDEDOR");

        List<Empleados> lista4 = q4.list();
        Iterator<Empleados> iter4 = lista4.iterator();

        while (iter4.hasNext()) {
            Empleados emp = (Empleados) iter4.next();
            System.out.println(emp.getApellido() + ", " + emp.getSalario());
        }

        System.out.println("===========================================");
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "1991-02-22";
        Date fecha = null;
        
        try{
            fecha = formatoDelTexto.parse(strFecha);
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        String hql3 = "from Empleados where fechaAlt = :fechaalta";
        Query q5 = session.createQuery(hql3);
        q5.setDate("fechaalta", fecha);
        
        System.out.println("===========================================");
        
        List <Byte> numeros = new ArrayList <Byte> ();
        numeros.add((byte) 10);
        numeros.add((byte) 20);
        
        String hql4 = "from Empleados emp where emp.departamentos.deptNo in (:listadep) order by emp.departamentos.deptNo";
        
        Query q6 = session.createQuery(hql4);
        q.setParameter("listadep", numeros);
        
        System.out.println("===========================================");

        session.close();

    }
}
