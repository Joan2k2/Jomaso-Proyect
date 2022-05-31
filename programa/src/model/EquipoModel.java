/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**Clase encargada de gestionar las acciones de la base de datos
 * en relacion a la clase Equipo
 *  
 * @author Jose Ramon
 * @version 0.1
 * @extends DBUtil
 */
public class EquipoModel extends DBUtil {
    
    /**Crea nuevo Equipo en la base de datos
    * segun una clase Equipo y Usuario
    * (Id Usuario, nombre equipo y descripcion equipo)
    *  
    * @author Jose Ramon
    * @version 0.1
    * @param "Equipo"
    * @param "Usuario"
    */
    public void crearEquipo(Usuario u,Equipo eq) {
		
	try {
            //Iniciamos conexión
            String insertSql = "CALL addEquipo(?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1,u.getId());
            stmt.setString(2,eq.getNombre());
            stmt.setBlob(3,eq.getImg());

            stmt.execute();		
	}catch (SQLException e) {
            e.printStackTrace();
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Borra un equipo de la base de datos
    * segun un los datos de una clase Usuario y Equipo
    * (Id Usuario e Id Equipo)
    *  
    * @author Jose Ramon
    * @version 0.1
    * @param "Equipo"
    * @param "Usuario"
    */
    public void borraEquipo(Usuario u,Equipo eq){
        try{				
	String insertSql="CALL borraEquipo(?,?)";
                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, u.getId());
            stmt.setInt(2, eq.getId());
                
            stmt.execute();
	} catch (SQLException e) {
            e.printStackTrace();
        } 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Aplica nuevos jugadores a un equipo en la base de datos
     * segun los datos  de la clase Usuario y Equipo
     * (Id Usuario e Id Equipo)
    *  
    * @author Jose Ramon
    * @version 0.1
    * @param "Equipo"
    * @param "Usuario"
    */
    public void addJugador(Usuario u,Equipo eq){
        try{				
	String insertSql="CALL addJugador(?,?)";
                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, u.getId());
            stmt.setInt(2, eq.getId());
                
            stmt.execute();
	} catch (SQLException e) {
            e.printStackTrace();
        } 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Elimina un jugador de un equipo en la base de datos 
     * segun los datos de la clase Usuario y Equipo
     * (Id Usuario e Id Equipo)
    *  
    * @author Jose Ramon
    * @version 0.1
    * @param "Equipo"
    * @param "Usuario"
    */
    public void borrarJugador(Usuario u,Equipo eq){
        try{				
	String insertSql="CALL borrarJugador(?,?)";
                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, u.getId());
            stmt.setInt(2, eq.getId());
                
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
