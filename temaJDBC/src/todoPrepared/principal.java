/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todoPrepared;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author marke
 */
public class principal {

    private static final String cadena_conexion = "jdbc:mysql://localhost:3306/biblioteca";

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("1- Ver todo el contenido de la tabla Libro");
        //System.out.println("2- ");

        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                try (Connection con = DriverManager.getConnection(cadena_conexion, "root", "fp.2023"); Statement st = con.createStatement()) {

                    String ver = "select * from libro join autor, editorial, tema";
                    ResultSet cursor = st.executeQuery(ver);
                    while (cursor.next()) {
                        System.out.print(cursor.getString("ISBN") + " ");
                        System.out.print(cursor.getString("titulo") + " ");
                        System.out.println(cursor.getInt("numeroejemplares") + " ");
                        System.out.print(cursor.getString("nombreAutor") + " ");
                        System.out.println(cursor.getString("nombreEditorial") + " ");
                        System.out.print(cursor.getString("direccion") + " ");
                        System.out.print(cursor.getString("telefono") + " ");
                        System.out.print(cursor.getString("nombretema") + " ");
                        System.out.println("");
                        System.out.println("--------------------------------");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
                break;
        }

    }

}
