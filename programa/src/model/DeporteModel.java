/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 1erDAM
 */
public class DeporteModel extends DBUtil {
    
    
    public void crearDeporte(Deporte d) {
		
	try {
            //Iniciamos conexión
            String insertSql = "CALL addDeporte(?,?)";
				
            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,d.getNombre());
            stmt.setString(2,d.getDescripcion());                      
			
            stmt.execute();
			
        } catch (SQLException e) {
            e.printStackTrace();
        } 
	finally {
	//Cerramos conexión
	this.cerrarConexion();
	}
        
    }
    
    public void borraUsuario(Deporte d){
       try{				
            String insertSql="CALL borraDeporte(?)";
                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, d.getId());

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
