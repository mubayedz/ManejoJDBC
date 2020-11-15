/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import datos.UsuarioDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author mubayed
 */
public class TestManejoPersonas {

    public static void main(String[] args) throws SQLException {
        PersonaDAO personadao = new PersonaDAO();
  

        // insertando un nuevo objeto de la clase persona
        /*Persona InsertarPersona = new Persona("2", "Juan", "Jose", "mubayed@gmail.com", "2");
        personadao.insertar(InsertarPersona);*/
        
        // Modificar un registro de la persona existente               /// no deja modificar el AddressID y el CustomerID
        /* Persona modificarPersona = new Persona(599, "1", "James", "Jose", "jeejje@gmail.com", "605");
        personadao.actualizar(modificarPersona);*/
        
        // Eliminar un registro
        Persona eliminarRegistro = new Persona(602);
        personadao.eliminar(eliminarRegistro);

        // imprimo los valores de la tabla
        List<Persona> personas = personadao.seleccionar();
        for (Persona persona1 : personas) { // itero el arraylist Persona
            System.out.println("Items son : " + persona1);
        }
    }
}
