/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.ArrayList;


/**
 * Clase usada para almacenar la informacion a usar del usuario
 * (a implementar) tambie cifra la contraseña antes de ser introducida a la base de datos
 *
 * @author Jose Ramon
 * @version 0.1
 * @extends Object
 */
public class Usuario {
    private String nickName;
    private String nombre;
    private String apellidos;
    private String contrasenya;
    private int id;
    private ArrayList<Equipo> equipos;
    private ArrayList<Deporte> deportes;
    private boolean admin;
    private Blob img;
    private String correo;
    private int edad;
    private String descripcion;
    private String almacenString;
    
    //Constructor default
    public Usuario(){}

    public String getAlmacenString() {
        return almacenString;
    }

    public void setAlmacenString(String almacenString) {
        this.almacenString = almacenString;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
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

    public ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(ArrayList<Deporte> deportes) {
        this.deportes = deportes;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Blob getImg() {
        return img;
    }

    public void setImg(Blob img) {
        this.img = img;
    }
   
    
}
