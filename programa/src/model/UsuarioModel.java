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

/**
 *
 * @author 1erDAM
 */
public class UsuarioModel extends DBUtil {
    
    public void crearUsuario(Usuario u) {
		
		try {
			//Iniciamos conexión
			String insertSql = "CALL addUsuario(?,?,?,?,?)";
				
			PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
			stmt.setString(1,u.getNickName() );
			stmt.setString(2,u.getNombre());
			stmt.setString(3,u.getApellidos());
                        stmt.setString(4,u.getContrasenya());
                        stmt.setBoolean(5,u.getAdmin());
                        
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexión
			this.cerrarConexion();
		}
        
	}
    
    public void borraUsuario(Usuario u){
        try{				
		String insertSql="CALL borraUsuario(?,?)";
                
                PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
                stmt.setInt(1, u.getId());
                stmt.setString(2, u.getContrasenya());
                
                stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexión
			this.cerrarConexion();
		}
    }
    
   


    //maradona 

    
    
}
