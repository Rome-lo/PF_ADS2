/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romeo Lopez Molina
 */
public class Usuario {
    private int idusuario;
    private String nombre;
    private String apellido;
    private String nickname;
    private String password;
    private int id_dir;

    public Usuario() {
    }

    public Usuario(int idusuario, String nombre, String apellido, String nickname, String password, int id_dir) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.password = password;
        this.id_dir = id_dir;
    }

    public Usuario(String nombre, String apellido, String nickname, String password, int id_dir) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.password = password;
        this.id_dir = id_dir;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }
    
    
    
    
    
}
