/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mubayed
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT customer_id, store_id, first_name, last_name, email, address_id FROM customer";
    private static final String SQL_INSERT = "INSERT INTO customer(store_id, first_name, last_name, email, address_id) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE customer SET store_id = ?, first_name = ?, last_name = ?, email = ?, address_id = ? WHERE customer_id = ?";
    private static final String SQL_DELETE = "DELETE FROM customer WHERE customer_id = ?";
    // regresara la lista de la clase persona
    public List<Persona> seleccionar() {
        Connection conexion = null;
        ResultSet res = null;
        PreparedStatement smtm = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_SELECT);
            res = smtm.executeQuery();
            while (res.next()) { // iterara hasta todos los resultados
                int CustomerID = res.getInt("customer_id");
                String StoreID = res.getString("store_id");
                String FirstName = res.getString("first_name");
                String LastName = res.getString("last_name");
                String Email = res.getString("email");
                String Addressid = res.getString("address_id");
                persona = new Persona(CustomerID, StoreID, FirstName, LastName, Email, Addressid); //agarra los datos
                personas.add(persona); // agregara el persona en el arraylist

            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // se cierran de forma inversa las conexiones a las que fueron llamadas
                Conexion.close(res);
                Conexion.close(smtm);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return personas;

    }

    public int insertar(Persona persona) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_INSERT);
            smtm.setString(1, persona.getStoreID());
            smtm.setString(2, persona.getFirstName());
            smtm.setString(3, persona.getLastName());
            smtm.setString(4, persona.getEmail());
            smtm.setString(5, persona.getAddressid());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(smtm);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int actualizar(Persona persona) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_UPDATE);
            smtm.setString(1, persona.getStoreID());
            smtm.setString(2, persona.getFirstName());
            smtm.setString(3, persona.getLastName());
            smtm.setString(4, persona.getEmail());
            smtm.setString(5, persona.getAddressid());
            smtm.setInt(6, persona.getCustomerID());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(smtm);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }
    
    public int eliminar(Persona persona) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_DELETE);
            smtm.setInt(1, persona.getCustomerID());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(smtm);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }
}
