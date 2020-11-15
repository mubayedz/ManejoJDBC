
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;
import java.sql.SQLException;


public class TestManejoUsuarios {
    public static void main(String[] args) {
         UsuarioDAO usuariodao = new UsuarioDAO();

        // insertando un nuevo objeto de la clase persona
        Usuario InsertarUsuario = new Usuario("juan12233", "sksks");
        usuariodao.insertar(InsertarUsuario);
        
        // Modificar un registro de la persona existente               /// no deja modificar el AddressID y el CustomerID
        Usuario modificarUsuario = new Usuario(4, "Joselala", "2k2kkqk");
        usuariodao.actualizar(modificarUsuario);
        
        // Eliminar un registro
        Usuario eliminarRegistro = new Usuario(5);
        usuariodao.eliminar(eliminarRegistro);

        // imprimo los valores de la tabla
        List<Usuario> usuarios = usuariodao.seleccionar();
        for (Usuario usuario1 : usuarios) { // itero el arraylist Persona
            System.out.println("Items son : " + usuario1);
        }
        
    }
   
    
}
