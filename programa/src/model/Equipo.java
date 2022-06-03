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
    
    //Constructor default
    public Equipo(){}
    
    //Constructor con todos los atributos
    public Equipo(int[] jugadores, int admin, ArrayList<Deporte> deportes, String nombre,String descripcion , Blob img) {
        this.jugadores = jugadores;
        this.admin = admin;
        this.deportes = deportes;
        this.nombre = nombre;
        this.img = img;
        this.descripcion=descripcion;
    }
    
    //equipo generico
    public Equipo(int admin, String nombre,String descripcion ,Blob img) {
        this.admin = admin;
        this.nombre = nombre;
        this.img = img;
        this.descripcion=descripcion;
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
