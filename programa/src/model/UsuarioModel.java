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
            stmt.setString(3,u.getApellidos()); 
            stmt.setString(4,u.getCorreo());
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
    
    public Usuario obtUsuario(String nick){
        Usuario u=new Usuario();
        
        try {
            //Iniciamos conexión
            String insertSql = "SELECT addUsuario(?)";

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
                u.setContrasenya(rs.getString("contrasenya"));
                u.setAdmin(rs.getBoolean("admin"));//OJO QUE IGUAL NO FURULA
                u.setImg(rs.getBlob("foto"));
                u.setDescripcion(rs.getString("descripcion"));
                
                //array de deportes que juega el usuario
                ArrayList<Deporte> arrayDep=new ArrayList();
                while(rs.next()){
                    Deporte d=new Deporte();
                    
                    d.setId(rs.getInt("deporteId"));
                    d.setNombre(rs.getString("deporteNombre"));
                    
                    arrayDep.add(d);
                }
                u.setDeportes(arrayDep);
                
                //array de equipos que participa el usuario
                ArrayList<Equipo> arrayEqi=new ArrayList();
                while(rs.next()){
                    Equipo e=new Equipo();
                    
                    e.setId(rs.getInt("equipoId"));
                    e.setNombre(rs.getString("equipoNombre"));
                    e.setAdmin(rs.getInt("equipoAdmin"));
                    e.setImg(rs.getBlob("equipoLogo"));
                    e.setDescripcion(rs.getString("equipoDescripcion"));
                    
                    //array de deportes que juega el equipo
                    ArrayList<Deporte> depE=new ArrayList();
                    while(rs.next()){
                        Deporte d=new Deporte();

                        d.setId(rs.getInt("deporteId"));
                        d.setNombre(rs.getString("deporteNombre"));

                        depE.add(d);
                    }
                    e.setDeportes(depE);
                    
                    arrayEqi.add(e);
                }
                u.setEquipos(arrayEqi); 
            }
            return u;
                        
	}catch (SQLException e) {
            e.printStackTrace();
            return null;
	} 
	finally {
            //Cerramos conexión
            this.cerrarConexion();
	}
    }
    
    
    

        
    }

