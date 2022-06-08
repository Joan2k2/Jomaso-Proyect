/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Clase usada para almacenar la informacion a usar de Torneos
 * 
 * @author Jose Ramon
 * @version 0.1
 */
public class Torneo {
    private int id;
    private ArrayList<Equipo> equipos;
    private String descripcion;
    private String nombre;
    private String fechaInscripcion;
    private String fehcaInicio;
    private Date fechaInicioDate;
    private Date fechaInscripcionDate;
    private String deporte;
    
    //Constructor default
    public Torneo() {}

    public Date getFechaInicioDate() {
        return fechaInicioDate;
    }

    public void setFechaInicioDate(Date fechaInicioDate) {
        this.fechaInicioDate = fechaInicioDate;
    }

    public Date getFechaInscripcionDate() {
        return fechaInscripcionDate;
    }

    public void setFechaInscripcionDate(Date fechaInscripcionDate) {
        this.fechaInscripcionDate = fechaInscripcionDate;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
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
