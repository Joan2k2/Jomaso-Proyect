/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;

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
    private int[] deportes;
    private String nombre;
    private Blob img;
    
    //Constructor default
    public Equipo(){}
    
    //Constructor con todos los atributos
    public Equipo(int id, int[] jugadores, int admin, int[] deportes, String nombre, Blob img) {
        this.id = id;
        this.jugadores = jugadores;
        this.admin = admin;
        this.deportes = deportes;
        this.nombre = nombre;
        this.img = img;
    }
    
    //equipo generico
    public Equipo(int id, int admin, String nombre, Blob img) {
        this.id = id;
        this.admin = admin;
        this.nombre = nombre;
        this.img = img;
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

    public int[] getDeportes() {
        return deportes;
    }

    public void setDeportes(int[] deportes) {
        this.deportes = deportes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
