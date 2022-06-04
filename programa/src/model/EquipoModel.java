/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    /**Retorna una lista de los Usuarios que participan en X equipo,
     * necesita la id del equipo como parametro
     * 
     * @author Jose Ramon
     * @version 0.1
     * @param "int id"
     * @return "ObservableList<Usuario>"
     */
    public ObservableList<Usuario> getJugadores(int id){
        try{				
            String insertSql="SELECT u.id,u.nickname,u.correo,u.nombre from usuarios u,participa p WHERE p.id_usuario=u.id AND p.id_equipo=?";
            
            ObservableList<Usuario> listJugadores = FXCollections.observableArrayList();
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNickName(rs.getString("nickname"));
                u.setCorreo(rs.getString("correo"));
                u.setNombre(rs.getString("nombre"));
                listJugadores.add(u);
            }
                
            return listJugadores;
	} catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Retorna una lista de los proximos Torneos que se apunto X equipo,
     * necesita la id del equipo como parametro
     * 
     * @author Jose Ramon
     * @version 0.1
     * @param "int id"
     * @return "ObservableList<Torneo>"
     */
    public ObservableList<Torneo> getTorneos(int id){
        try{				
            String insertSql="SELECT t.nombre,t.fecha_inicio,t.fecha_inscripcion,d.nombre AS \"deporte\" FROM torneos t,compite c,deportes d,trata tr WHERE tr.id_torneo=t.id AND tr.id_deporte=d.id and c.id_torneo=t.id AND c.id_equipos=?";
            
            ObservableList<Torneo> listTorneos = FXCollections.observableArrayList();
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Torneo t=new Torneo();
                
                t.setNombre(rs.getString("nombre"));
                t.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                t.setFehcaInicio(rs.getString("fecha_inicio"));
                t.setDeporte(rs.getNString("deporte"));
                
                listTorneos.add(t);
            }
                
            return listTorneos;
	} catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    
    
}
