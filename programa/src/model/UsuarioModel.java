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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public boolean crearUsuario(Usuario u) {
        boolean retorno=false;
	try {
            //Iniciamos conexión
            String insertSql = "SELECT addUsuario(?,?,?,?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,u.getNickName() );
            stmt.setString(2,u.getNombre());
            stmt.setString(3,u.getCorreo()); 
            stmt.setString(4,u.getApellidos());
            stmt.setString(5,u.getContrasenya());
            stmt.setInt(6,u.getEdad());

            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                 retorno=rs.getBoolean(1);
            }
            return retorno;
                        
	}catch (SQLException e) {
            e.printStackTrace();
            return retorno;
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
            //return resultado;
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
    
    /**Analiza en nickName y contraseña de usuario a logearse y devuelve los dos parametros anteriores
     * son ciertos o no.
     * (si el nick y contraseña son iguales devuelve true, de lo contrario devuelve false)
     * al final de la funcion si el booleano a retornar es true llama a la funcion obtUsuario
     * para crear y almacenar los datos del usuario logeado para un uso futuro.
     * 
     * @author Jose Ramon
     * @version 0.2
     * @param "Usuario"
     * @return boolean
     */
    public boolean usrLog(Usuario u){
        boolean retorno=false;
        try{				

	String insertSql="SELECT userLog(?,?)";

	

                
            PreparedStatement stmt=this.getConexion().prepareStatement(insertSql);
            stmt.setString(1, u.getNickName());
            stmt.setString(2, u.getContrasenya());
                

            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
              retorno=rs.getBoolean(1);
            }
            if(retorno==true){
                UsuarioLog.setContrasenya(u.getContrasenya());
                obtUsuario(u.getNickName());
            }
            return retorno;

			
        } catch (SQLException e) {
            e.printStackTrace();
            return retorno;
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
        
    }
    
    /**saca los datos personales de usuario legeado (en caso de que el logeo sea exitoso)
     * y posteriormente lo almacena los datos en la clase estatica "UsuarioLog"
     * 
     * @author Jose Ramon
     * @version 0.2
     * @param "Usuario"
     * @return "UsuarioLog"
     */
    private UsuarioLog obtUsuario(String nick){
        Usuario u=new Usuario();
        
        try {
            //Iniciamos conexión
            String insertSql = "SELECT * FROM usuarios u WHERE u.nickname=?";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1,nick);

            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                //datos casicos de usr
                u.setId(rs.getInt("id"));
                u.setNickName(rs.getString("nickname"));
                u.setCorreo(rs.getString("correo"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEdad(rs.getInt("edad"));
                u.setAdmin(rs.getBoolean("admin"));//OJO QUE IGUAL NO FURULA
                u.setImg(rs.getBlob("foto"));
                u.setDescripcion(rs.getString("descripcion"));
            }
            return UsuarioLog.getSingletonInstance(u);
                        
	}catch (SQLException e) {
            e.printStackTrace();
            return null;
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    /**Devuelve un observable list de los equipos del usuairo
     * 
     * @author Jose Ramon
     * @version 0.1
     * @return "ObservableList(Equipo)"
     */
    public ObservableList<Equipo> getEquipo() {

        try {
            //Iniciamos conexión
            ObservableList<Equipo> listEquipo = FXCollections.observableArrayList();
            String insertSql = "SELECT e.id,e.nombre, d.nombre AS \"deporte\" FROM equipos e, participa p, practica pr, deportes d, usuarios u WHERE p.id_usuario=u.id AND p.id_equipo=e.id AND pr.id_equipo=e.id AND pr.id_deporte=d.id AND u.id=?";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1,UsuarioLog.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Equipo e = new Equipo();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setNameAdmin(rs.getString("deporte"));
                listEquipo.add(e);
            }

            return listEquipo;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
    /**Devuelve un observable list de los usuarios 
     * para uso del administrador
     * 
     * @return "ObservableList(torneo)"
     */
   public ObservableList<Usuario> listarUsuario() {

        try {
            //Iniciamos conexión
            ObservableList<Usuario> listaUsuario = FXCollections.observableArrayList();
            String insertSql = "SELECT id, nickname FROM usuarios";
            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNickName(rs.getString("nickname"));
                listaUsuario.add(u);
            }

            return listaUsuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
    
    
    

        
    }

