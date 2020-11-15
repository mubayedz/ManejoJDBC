/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mubayed
 */
public class Testing extends Conexion{
    public static void main(String[] args) {
        try {
            Connection conexion = getConnection();
            Statement instruccion = conexion.createStatement(); // creo la conexion con conexion y instruccion
                String sql = "SELECT customer_id, store_id, first_name, last_name, email FROM customer"; // coloco la query
                ResultSet resultado = instruccion.executeQuery(sql);
                while(resultado.next()){ // iterara hasta todos los resultados
                    System.out.print("Customer ID: "+ resultado.getInt("customer_id"));
                    System.out.print(" Store_id: "+ resultado.getInt("store_id"));
                    System.out.print(" First_name: "+ resultado.getString("first_name"));
                    System.out.print(" Last_name: "+ resultado.getString("last_name"));
                    System.out.print(" Email: "+ resultado.getString("email"));
                    System.out.println("");
                }
                // cierro las conexiones para evitar memory leaks
                close(resultado);
                close(instruccion);           
                close(conexion);
        } catch (SQLException ConexionEx) {
           ConexionEx.printStackTrace(System.out);
        }
        
    }
    
}
