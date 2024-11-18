/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateempresa;

/**
 *
 * @author FP
 *
 *
 *
 *
 */
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import hibernateempresa.*;
import hibernateempresa.Departamentos;
import hibernateempresa.Totales;
import hibernateempresa.Empleados;
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

        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        String hql3 = "from Empleados where fechaAlt = :fechaalta";
        Query q5 = session.createQuery(hql3);
        q5.setDate("fechaalta", fecha);

        System.out.println("===========================================");
        /*
        List <Byte> numeros = new ArrayList <Byte> ();
        numeros.add((byte) 10);
        numeros.add((byte) 20);
        
        String hql4 = "from Empleados emp where emp.departamentos.deptNo in (:listadep) order by emp.departamentos.deptNo";
        
        Query q6 = session.createQuery(hql4);
        q.setParameter("listadep", numeros);
        
        System.out.println("===========================================");
         */

 /*
        CONSULTAS SOBRE CLASES NO ASOCIADAS
         */
        System.out.println("==========CONSULTAS SOBRE CLASES NO ASOCIADAS===========");

        String hql5 = "from Empleados e, Departamentos d where e.departamentos.deptNo = d.deptNo order by Apellido";
        Query cons = session.createQuery(hql5);
        Iterator q7 = cons.iterate();
        while (q7.hasNext()) {
            Object[] par = (Object[]) q7.next();
            Empleados em = (Empleados) par[0];
            Departamentos de = (Departamentos) par[1];
            System.out.println(em.getApellido() + " " + em.getSalario() + " " + de.getDNombre() + " " + de.getLoc());
        }
        System.out.println("===========================================");

        String hql6 = "select avg(em.salario) from Empleados as em";
        Query cons6 = session.createQuery(hql6);
        Double suma = (Double) cons6.uniqueResult();
        System.out.println("Salario medio: " + suma);

        System.out.println("===========================================");

        String hql7 = "select e.departamentos.deptNo, avg(salario), count(empNo) from Empleados e group by e.departamentos.deptNo";
        Query cons7 = session.createQuery(hql7);
        Iterator iter7 = cons7.iterate();
        while (iter7.hasNext()) {
            Object[] par = (Object[]) iter7.next();
            Byte depar = (Byte) par[0];
            Double media = (Double) par[1];
            Long cuenta = (Long) par[2];
            System.out.println("Dept: " + depar + " Media: " + media + " NºEmp: " + cuenta);
        }

        System.out.println("===========================================");

        String hql8 = "select new Totales(d.deptNo, count(e.empNo), avg(e.salario),d.dnombre)"
                + " from Empleados as e right join e.departamentos as d "
                + "group by d.deptNo, d.dnombre";
        
        Query cons8 = session.createQuery(hql8);
        Iterator q8 = cons8.iterate();
        while(q8.hasNext()){
            Totales tot = (Totales) q8.next();
            System.out.println("Nº Dep: "+tot.getNumero());
            System.out.println("Salario medio: "+tot.getMedia());
            System.out.println("Nº Emple: "+tot.getCuenta());
        }
        
        System.out.println("===========================================");
        
        
        String hql9 = "select d.deptNo, count(e.empNo), avg(e.salario), d.dnombre "
                + "from Empleados as e right join e.departamentos as d "
                + "group by d.deptNo, d.dnombre";

        session.close();

    }
}
