package datos;

import static datos.Conexion_test.getConnection;
import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    // regresara la lista de la clase persona
    public List<Usuario> seleccionar() {
        Connection conexion = null;
        ResultSet res = null;
        PreparedStatement smtm = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_SELECT);
            res = smtm.executeQuery();
            while (res.next()) { // iterara hasta todos los resultados
                int idUsuario = res.getInt("id_usuario");
                String Username = res.getString("username");
                String Password = res.getString("password");
                usuario = new Usuario(idUsuario, Username, Password);
                usuarios.add(usuario); // agregara usuario al arraylist

            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // se cierran de forma inversa las conexiones a las que fueron llamadas
                Conexion_test.close(res);
                Conexion_test.close(smtm);
                Conexion_test.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return usuarios;

    }

    public int insertar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_INSERT);
            smtm.setString(1, usuario.getUsername());
            smtm.setString(2, usuario.getPassword());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion_test.close(smtm);
                Conexion_test.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int actualizar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_UPDATE);
            smtm.setString(1, usuario.getUsername());
            smtm.setString(2, usuario.getPassword());
            smtm.setInt(3, usuario.getIdUsuario());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion_test.close(smtm);
                Conexion_test.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int eliminar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement smtm = null;
        int registros = 0;
        try {
            conexion = getConnection();
            smtm = conexion.prepareStatement(SQL_DELETE);
            smtm.setInt(1, usuario.getIdUsuario());
            registros = smtm.executeUpdate(); //update , insert or delete
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion_test.close(smtm);
                Conexion_test.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

}
