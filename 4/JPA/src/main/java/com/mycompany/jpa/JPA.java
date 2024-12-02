/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author FP
 */
public class JPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecaJPA");
        EntityManager em = emf.createEntityManager();

        //Libros libros = em.find(Libros.class, "123-456");
        //System.out.println(libros.toString());
        List<Libros> libros = em.createNamedQuery("Libros.findAll").getResultList();
        for (Libros libro : libros) {
            System.out.println(libro.toString());
        }

        List<Libros> libros2 = em.createQuery("SELECT l FROM libros").getResultList();
        for (Libros libro : libros2) {
            System.out.println(libro.toString());
        }

        em.close();
        emf.close();
    }
}
