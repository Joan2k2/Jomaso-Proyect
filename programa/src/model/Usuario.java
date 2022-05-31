/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    private String correo;
    private int edad;
    private String descripcion;
    
    //Constructor default
    public Usuario(){}
    
    //Constructor con todos los atributos
    public Usuario(String nickName, String nombre, String apellidos, String contrasenya, int id, Equipo[] equipos, int[] deportes, boolean admin, Blob img, String correo, int edad, String descripcion) {    
        this.nickName = nickName;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasenya = contrasenya;
        this.id = id;
        this.equipos = equipos;
        this.deportes = deportes;
        this.admin = admin;
        this.img = img;
        this.correo = correo;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    //user creacion generica

    public Usuario(String nickName, String nombre, String contrasenya, String correo, int edad) {
        this.nickName = nickName;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.correo = correo;
        this.edad = edad;
    }
    
    
    //Constructor con solo id
    public Usuario(int id) {
        this.id = id;
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

    /**
     * Metodo para encriptar la contraseña intoducida por el Usuario a MD5
     * (devuelve un string)
     * @author Joan Ruiz
     * @param "String"
    */
    public static String converMD5(String input) {
 try {
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] messageDigest = md.digest(input.getBytes());
 BigInteger number = new BigInteger(1, messageDigest);
 String hashtext = number.toString(16);

 while (hashtext.length() < 32) {
 hashtext = "0" + hashtext;
 }
 return hashtext;
 }
 catch (NoSuchAlgorithmException e) {
 throw new RuntimeException(e);
 }
 }
    
}
