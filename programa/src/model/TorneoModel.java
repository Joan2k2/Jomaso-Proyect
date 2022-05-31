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
public class TorneoModel extends DBUtil{
    
    public void crearTorneo(Torneo t) {
		
	try {
            //Iniciamos conexión
            String insertSql = "CALL addTorneo(?,?,?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,t.getNombre());
            stmt.setString(2,t.getDescripcion());
            stmt.setString(3,t.getFehcaInicio());
            stmt.setString(1,t.getFechaInscripcion());

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    public void borrarTorneo(Torneo t, Usuario u){
        try {
            //Iniciamos conexión
            String insertSql = "CALL borraTorneo(?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1,u.getId());
            stmt.setInt(2,t.getId());

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    public void inscribEquipo(Torneo t, Equipo eq){
        try {
            //Iniciamos conexión
            String insertSql = "CALL inscribEquipo(?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1,eq.getId());
            stmt.setInt(2,t.getId());

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    public void desInscribEquipo(Torneo t, Equipo eq){
        try {
            //Iniciamos conexión
            String insertSql = "CALL desInscribEquipo(?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1,eq.getId());
            stmt.setInt(2,t.getId());

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    
}
