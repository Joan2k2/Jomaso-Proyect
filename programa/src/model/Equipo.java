/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;
import java.util.ArrayList;

/**
 * Clase usada para almacenar la informacion a usar de los equipos
 * 
 * @author Jose Ramon
 * @version 0.1
 * @extends Object
 */
public class Equipo {
    private int id;
    private int[] jugadores;
    private int admin;
    private ArrayList<Deporte> deportes;
    private String nombre;
    private Blob img;
    private String descripcion;
    private String nameAdmin;
    
    //Constructor default
    public Equipo(){}

    public String getNameAdmin() {
        return nameAdmin;
    }

    public void setNameAdmin(String nameAdmin) {
        this.nameAdmin = nameAdmin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }
    
    public Equipo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(int[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(ArrayList<Deporte> deportes) {
        this.deportes = deportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
