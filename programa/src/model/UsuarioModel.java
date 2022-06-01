/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**Clase encargada de gestionar las acciones de la base de datos
 * en relacion a la clase Usuario
 *  
 * @author Jose Ramon
 * @version 0.1
 * @extends DBUtil
 */
public class UsuarioModel extends DBUtil {
    
    /**Crea nuevo Usuario en la base de datos
    * segun los datos de la clase Usuario
    *  (nickename, nombre, correo, contrasenya y edad)
    * 
    * @author Jose Ramon
    * @param "Usuario"
    * @version 0.1
    */
    public void crearUsuario(Usuario u) {
		
	try {
            //Iniciamos conexión
            String insertSql = "CALL addUsuario(?,?,?,?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,u.getNickName() );
            stmt.setString(2,u.getNombre());
            stmt.setString(3,u.getApellidos());
            stmt.setString(4,u.getCorreo());
            stmt.setString(5,u.getContrasenya());
            stmt.setInt(6,u.getEdad());
            // Traduce a integer si el usuario es administrador o no
            // si es 1 el usuario es administrador y si es 0 no lo es
            int admin;
            if(u.getAdmin()==true)
                admin=1;
            else
                admin=0;
            
            stmt.setInt(5,admin);

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    
    }
    
    /** Borra Usuario en la base de datos
    * segun los datos de la clase Usuario
    *  (id usuario, contrasenya)
    * 
    * @author Jose Ramon
    * @version 0.1
    * @param "Usuario"
    */
    public void borraUsuario(Usuario u){
        try{				
		String insertSql="CALL borraUsuario(?)";
                
                PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
                stmt.setInt(1, u.getId());
                
                stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexión
			this.cerrarConexion();
		}
    }
    
    public void usrLog(Usuario u){
        try{				
	String insertSql="CALL usrLog(?,?)";
                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setString(1, u.getNickName());
            stmt.setString(1, u.getContrasenya());
                
            stmt.execute();
			
        } catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
        
    }
    
}
