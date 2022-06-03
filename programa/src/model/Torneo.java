/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 * Clase usada para almacenar la informacion a usar de Torneos
 * 
 * @author Jose Ramon
 * @version 0.1
 * @extends Object
 */
public class Torneo {
    private int id;
    private ArrayList<Equipo> equipos;
    private String descripcion;
    private String nombre;
    private String fechaInscripcion;
    private String fehcaInicio;
    
    //Constructor con todos los atributos
    public Torneo(ArrayList<Equipo> equipos, String descripcion, String nombre, String fechaInscripcion, String fehcaInicio) {
        this.equipos = equipos;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechaInscripcion = fechaInscripcion;
        this.fehcaInicio = fehcaInicio;
    }
    //Constructor creacion generica
    public Torneo(String nombre, String fechaInscripcion, String fehcaInicio) {
        this.nombre = nombre;
        this.fechaInscripcion = fechaInscripcion;
        this.fehcaInicio = fehcaInicio;
    }
    
    //Constructor default
    public Torneo() {}
    
    //Constructor con solo id
    public Torneo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getFehcaInicio() {
        return fehcaInicio;
    }

    public void setFehcaInicio(String fehcaInicio) {
        this.fehcaInicio = fehcaInicio;
    }
    
    
}
