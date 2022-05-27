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
    
    public boolean crearUsuario(Usuario u) {
		Boolean resultado = false;
		
		try {
			//Iniciamos conexión
			String insertSql = "";
				
			PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
			
			stmt.setInt(1, u.getId());
			stmt.setString(2,u.getNickName() );
			stmt.setInt(3, );
			stmt.setInt(4, ());
			
			stmt.execute();
			resultado = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			//Cerramos conexión
			this.cerrarConexion();
			return resultado;
		}
	}
    
    public ArrayList<Usuario> getUsuario() {
		
		ArrayList<Usuario> listaAlumnos = new ArrayList<Usuario>();
		
		try {
			//Iniciamos conexión
			String sql = "";
			PreparedStatement stmt = (PreparedStatement) this.getConexion();
			ResultSet rs = stmt.executeQuery();  
		
			while(rs.next()) {
				
                            
                                String nickN=rs.getString("nickName");
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int edad = rs.getInt("edad");
                                String correo=rs.getString("correo");
                                String apellidos=rs.getString("apellidos");
                                boolean admin=rs.getBoolean("admin");
                                Blob foto=rs.getBlob("foto");
                                
                                
								
				Usuario p = new Usuario();
				listaAlumnos.add(p);
			}
			
			return listaAlumnos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally {
			//Cerramos conexión
			this.cerrarConexion();
		}
	}


    //maradona 

    
    
}
