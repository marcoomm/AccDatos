/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1;

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class principal {

    public static final String conexion = "jdbc:mysql://localhost:3306/biblioteca";

    public static void visualizarLibro() {
        try (Connection con = DriverManager.getConnection(conexion, "root", "fp.2023"); Statement st = con.createStatement()) {

            Statement sentencia = con.createStatement();

            String selectLibro = "select * from libro natural join (autor,editorial,tema)";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            while (sentenciaSelect.next()) {
                System.out.println(sentenciaSelect.getString("isbn"));
                System.out.println(sentenciaSelect.getString("titulo"));
                System.out.println(sentenciaSelect.getInt("numeroEjemplares"));
                System.out.println(sentenciaSelect.getString("nombreAutor"));
                System.out.println(sentenciaSelect.getString("nombreEditorial"));
                System.out.println(sentenciaSelect.getString("direccion"));
                System.out.println(sentenciaSelect.getString("telefono"));
                System.out.println(sentenciaSelect.getString("nombretema"));
                System.out.println("");
                System.out.println("-----------------------------------------------------");

            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public static boolean existeAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "SELECT * FROM autor";
        ResultSet sentencia = con.createStatement().executeQuery(sentenciaAutor);
        if (!sentencia.next()) {
            return false;
        } else {
            sentencia.first();
        }

    }

    public static void main(String[] args) throws SQLException {

        String usr = "root";
        String passw = "fp.2023";

        Scanner teclado = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(conexion, usr, passw); Statement st = con.createStatement()) {

            System.out.println("Conexion correcta");

            try (Statement ver = con.createStatement()) {

                String isbn = "9823525255";
                String titulo = "";
                String numeroEjemplares = "";
                String nombreAutor = "";
                String nombreEditorial = "";
                String nombreTema = "";

                String select = "SELECT * FROM Autor";
                String selectLibro = "SELECT * FROM libro WHERE isbn = '" + isbn + "'; ";
                ResultSet rs = ver.executeQuery(selectLibro);
                if (rs.next()) {
                    System.out.println("El libro ya existe");

                    /*int id = rs.getInt("idAutor"); 
                   String nombre =
                     rs.getString("NombreAutor"); System.out.println("Id: " +
                      id + "\n" + "Nombre: " + nombre);*/
                } else {

                    if (!existeAutor(nombreAutor, con)) {
                        altaAutor(nombreAutor);
                    }
                    int idAutor = buscarAutor(nombreAutor);

                    if (!existeTema(nombreTema)) {
                        altaTema(nombreTema);
                    }
                    int idTema = buscarAutor(nombreAutor);

                    if (!existeEditorial(nombreEditorial)) {
                        altaEditorial(nombreEditorial);
                    }
                    int idEditorial = buscarEditorial(nombreEditorial);

                    altaEditorial(nombreEditorial);
                    altaLibro(isbn, titulo, numeroEjemplares, idAutor, idEditorial, idTema);

                }

                //visualizarLibro();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            /**
             * int opcion = 0; System.out.println("2 - ver tabla autores"); if
             * (opcion == 1) {
             *
             * /*
             * String insertar1 = ("INSERT INTO Autor values (25, 'Padua Keoma
             * Salas')");
             *
             * try(Statement insertar = con.createStatement()){
             *
             * insertar.execute(insertar1);
             *
             * System.out.println("Datos insertados correctamente");
             * }catch(SQLException e){ e.printStackTrace(); }
             *
             * }
             */
            //if (opcion == 2) {
            //}
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}
