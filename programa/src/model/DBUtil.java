/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**Clase encargada de la gestion de abrir y cerrar la conexion con la base de datos
 *  
 * @author Jose Ramon
 * @version 0.1
 * @extends Object
 */
public class DBUtil {
	private Connection conn;
	private String cadenaConexion = "jdbc:mysql:https://jomaso.ddns.net:3306/joma_jomabb";
	private String nombreUsuario = "joma_jomabbusr";
	private String password = "1234567";
	
        
        /**ABRE conexion con la base de datos
         * 
         * @author Jose Ramon
         * @version 0.1
        */
	public Connection getConexion() {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
			return this.conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
        
	/**CIERRA conexion con la base de datos
         * 
         * @author Jose Ramon
         * @version 0.1
         */
	public void cerrarConexion() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
