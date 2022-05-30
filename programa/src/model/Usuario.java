/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;


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
    private Equipo[] equipos;
    private int[] deportes;
    private boolean admin;
    private Blob img;
    
    //Constructor default
    public Usuario(){}
    
    //Constructor con todos los atributos
    public Usuario(String nickName, String nombre, String apellidos, String contrasenya, int id, Equipo[] equipos, int[] deportes, boolean admin, Blob img) {
        this.nickName = nickName;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenya = contrasenya;
        this.id = id;
        this.equipos = equipos;
        this.deportes = deportes;
        this.admin = admin;
        this.img = img;
    }
    //user creacion generica
    public Usuario(String nickName, String nombre, String contrasenya, int id, Blob img) {
        this.nickName = nickName;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.id = id;
        this.img = img;
    }
    
    //Constructor con solo id
    public Usuario(int id) {
        this.id = id;
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

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }

    public int[] getDeportes() {
        return deportes;
    }

    public void setDeportes(int[] deportes) {
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
