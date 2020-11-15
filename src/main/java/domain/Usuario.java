/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author mubayed
 */
public class Usuario {

    private int idUsuario;
    private String Username;
    private String Password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;

    }

    public Usuario(int idUsuario, String Username, String Password) {
        this.idUsuario = idUsuario;
        this.Username = Username;
        this.Password = Password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", Username=" + Username + ", Password=" + Password + '}';
    }
    
}
