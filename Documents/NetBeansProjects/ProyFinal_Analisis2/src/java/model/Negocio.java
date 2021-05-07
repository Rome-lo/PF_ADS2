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
public class Negocio {
    private int idnegocio;
    private String nombre;
    private int id_dir;
    private String descripcion;
    private int sanciones;
    private int idusuario;

    public Negocio(String nombre, int CAT_direcciones_id_dir, String descripcion, int sanciones, int idusuario) {
        this.nombre = nombre;
        this.id_dir = CAT_direcciones_id_dir;
        this.descripcion = descripcion;
        this.sanciones = sanciones;
    }

    public Negocio(int idnegocio, String nombre, int CAT_direcciones_id_dir, String descripcion, int sanciones, int idusuario) {
        this.idnegocio = idnegocio;
        this.nombre = nombre;
        this.id_dir = CAT_direcciones_id_dir;
        this.descripcion = descripcion;
        this.sanciones = sanciones;
    }

    public int getIdnegocio() {
        return idnegocio;
    }

    public void setIdnegocio(int idnegocio) {
        this.idnegocio = idnegocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_dir() {
        return id_dir;
    }

    public void setId_dir(int id_dir) {
        this.id_dir = id_dir;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSanciones() {
        return sanciones;
    }

    public void setSanciones(int sanciones) {
        this.sanciones = sanciones;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    
    
    
    
}
