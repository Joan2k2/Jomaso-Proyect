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
 * en relacion a la clase Deporte
 *  
 * @author Jose Ramon
 * @version 0.1
 * @extends DBUtil
 */
public class DeporteModel extends DBUtil {
    
    /** Crea nuevos deportes en la base de datos
    * segun una clase Deporte 
    *  
    * @author Jose Ramon
    * @param "Deporte"
    * @version 0.1
    */
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
    
    /**Borra un deporte de la base de datos
    * segun un los datos de una clase deporte 
    *  
    * @author Jose Ramon
    * @param "Deporte"
    * @version 0.1
    */
    public void borraDeporte(Deporte d){
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
    
    public ObservableList<String> getDeportes() {

        try {
            //Iniciamos conexión
            ObservableList<String> almaDeporte =FXCollections.observableArrayList();
            String insertSql = "SELECT nombre FROM deportes";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String a=rs.getString("nombre");
                
                almaDeporte.add(a);
            }

            return almaDeporte;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
