/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**Clase encargada de gestionar las acciones de la base de datos
 * en relacion a la clase Torneo
 *
 * @author jose Ramon
 * @version 0.1
 * @extends DBUtil
 */
public class TorneoModel extends DBUtil{
    
    /**Crea nuevo Torneo en la base de datos
    * segun una clase torneo
    * (nombre*, descripcion, fechaInicio*, fechaInscripcion*)
    * 
    * @author Jose Ramon
    * @version 0.1
    * @param "Torneo"
     */
    public void crearTorneo(Torneo t) {
		
	try {
            //Iniciamos conexión
            String insertSql = "CALL addTorneo(?,?,?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,t.getNombre());
            stmt.setString(2,t.getDescripcion());
            stmt.setString(3,t.getFechaInicio());
            stmt.setString(4,t.getFechaInscripcion());

            stmt.execute();
			
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Borra un torneo de la base de datos
    * segun un los datos de una clase Usuario y Torneo
    * (Id Usuario e Id Torneo)
    * 
     * @author Jose Ramon
    * @version 0.1
    * @param "Torneo"
    * @param "Usuario"
     */
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
    
    /**Inscribe 
     * 
     * @param t
     * @param eq 
     */
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
