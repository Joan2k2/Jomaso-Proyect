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
public class UsuarioLog {
    private static String nickName;
    private static String nombre;
    private static String apellidos;
    private static String contrasenya;
    private static int id;
    private static ArrayList<Equipo> equipos;
    private static ArrayList<Deporte> deportes;
    private static boolean admin;
    private static Blob img;
    private static String correo;
    private static int edad;
    private static String descripcion;
    private static UsuarioLog usuarioLog;
    private static int almacenId; 
    
    //Constructor default
    private UsuarioLog(){}
    
    /**crea un objeto UsuarioLog y almacena todos los datos del usuario logeado
     * en la clase estatica de mismo nombre
     * 
     * @author Jose Ramon Jimenez
     * @version 0.1
     * @param u
     * @return "UsuarioLog"
     */
    public static UsuarioLog getSingletonInstance(Usuario u){
        if(usuarioLog==null){
            usuarioLog=new UsuarioLog();
            UsuarioLog.admin=u.getAdmin();
            UsuarioLog.apellidos=u.getApellidos();
           // UsuarioLog.contrasenya=u.getContrasenya();
            UsuarioLog.correo=u.getCorreo();
            UsuarioLog.deportes=u.getDeportes();
            UsuarioLog.descripcion=u.getDescripcion();
            UsuarioLog.edad=u.getEdad();
            UsuarioLog.equipos=u.getEquipos();
            UsuarioLog.id=u.getId();
            UsuarioLog.img=u.getImg();
            UsuarioLog.nickName=u.getNickName();
            UsuarioLog.nombre=u.getNombre();
            return UsuarioLog.usuarioLog;
        }
        return UsuarioLog.usuarioLog;
    }

    public static UsuarioLog getUsuarioLog() {
        return usuarioLog;
    }

    public static void setUsuarioLog(UsuarioLog usuarioLog) {
        UsuarioLog.usuarioLog = usuarioLog;
    }

    public static int getAlmacenId() {
        return almacenId;
    }

    public static void setAlmacenId(int almacenId) {
        UsuarioLog.almacenId = almacenId;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
         UsuarioLog.correo = correo;
    }

    public static int getEdad() {
        return edad;
    }

    public static void setEdad(int edad) {
         UsuarioLog.edad = edad;
    }

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
         UsuarioLog.descripcion = descripcion;
    }
    
    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
         UsuarioLog.nickName = nickName;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
         UsuarioLog.nombre = nombre;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public static void setApellidos(String apellidos) {
         UsuarioLog.apellidos = apellidos;
    }

    public static String getContrasenya() {
        return contrasenya;
    }

    public static void setContrasenya(String contrasenya) {
         UsuarioLog.contrasenya = contrasenya;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
         UsuarioLog.id = id;
    }

    public static ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public static void setEquipos(ArrayList<Equipo> equipos) {
         UsuarioLog.equipos = equipos;
    }

    public static ArrayList<Deporte> getDeportes() {
        return deportes;
    }

    public static void setDeportes(ArrayList<Deporte> deportes) {
         UsuarioLog.deportes = deportes;
    }

    public static boolean getAdmin() {
        return admin;
    }

    public static void setAdmin(boolean admin) {
         UsuarioLog.admin = admin;
    }

    public static Blob getImg() {
        return img;
    }

    public  static void setImg(Blob img) {
         UsuarioLog.img = img;
    }
   
    
}
