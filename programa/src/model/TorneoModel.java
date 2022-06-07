/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase encargada de gestionar las acciones de la base de datos en relacion a
 * la clase Torneo
 *
 * @author jose Ramon
 * @version 0.1
 * @extends DBUtil
 */
public class TorneoModel extends DBUtil {

    /**
     * Crea nuevo Torneo en la base de datos segun una clase torneo (nombre*,
     * descripcion, fechaInicio*, fechaInscripcion*)
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
            stmt.setString(1, t.getNombre());
            stmt.setString(2, t.getDescripcion());
            stmt.setString(3, t.getFehcaInicio());
            stmt.setString(1, t.getFechaInscripcion());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    /**
     * Borra un torneo de la base de datos segun un los datos de una clase
     * Usuario y Torneo (Id Usuario e Id Torneo)
     *
     * @author Jose Ramon
     * @version 0.1
     * @param "Torneo"
     * @param "Usuario"
     */
    public void borrarTorneo(int id) {

        try {
            //Iniciamos conexión
            String insertSql = "DELETE FROM torneos  WHERE id=?";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, id);

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    /**
     * Inscribe a un equipo a un torneo y guarda el registro en la base de datos,
     * para lograr eso solo necesitas pasarle el nombre del equipo y el mismo accedera
     * a la id del usuario y del torneo mediante la clase estatica UsuarioLog
     *
     * @author Jose Ramon
     * @version 0.2
     * @param "String"
     * @return boolean
     */
    public boolean inscribEquipo(String equipoName) {
        try {
            //Iniciamos conexión
            //name, contra, equipoName, idUsrLog
            String insertSql = "SELECT `inscribEquipo`(?, ?, ?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1, equipoName);
            stmt.setInt(2, UsuarioLog.getId());
            stmt.setInt(3,UsuarioLog.getAlmacenId());

            ResultSet rs=stmt.executeQuery();
            boolean resultado=false;
            
            while(rs.next()){
                resultado=rs.getBoolean(1);
            }
            return resultado;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    /**
     * desapunta a un equipo a un torneo y guarda el registro en la base de datos,
     * para lograr eso solo necesitas pasarle el nombre del equipo y el mismo accedera
     * a la id del usuario y del torneo mediante la clase estatica UsuarioLog
     *
     * @author Jose Ramon
     * @version 0.2
     * @param "String"
     * @return boolean
     */
    public boolean desInscribEquipo(String equipoName) {
        try {
            //Iniciamos conexión
            String insertSql = "SELECT desinscribirEquipo(?,?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setString(1, equipoName);
            stmt.setInt(2, UsuarioLog.getId());
            stmt.setInt(3,UsuarioLog.getAlmacenId());

            ResultSet rs=stmt.executeQuery();
            boolean resultado=false;
            
            while(rs.next()){
                resultado=rs.getBoolean(1);
            }
            return resultado;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    /**Retorna una lista de los torneos creados mas recientemente
     *
     * @author Jose Ramon
     * @version 0.1
     * @return "ObservableList<Torneo>"
     */
    public ObservableList<Torneo> listarTorneosHome() {

        try {
            //Iniciamos conexión
            ObservableList<Torneo> almatorneo =FXCollections.observableArrayList();
            String insertSql = "call obtenerTorneosHome()";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Torneo t = new Torneo();
                t.setId(rs.getInt("id"));
                t.setNombre(rs.getString("nombre"));
                t.setFehcaInicio(rs.getString("fecha_inicio"));
                t.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                t.setDeporte(rs.getString("deporte"));
                almatorneo.add(t);

            }

            return almatorneo;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
    
    /**Retorna una lista de TODOS los torneos en DB
     *
     * @author Jose Ramon
     * @version 0.1
     * @return "ObservableList<Torneo>"
     */
    public ObservableList<Torneo> listarTorneos() {

        try {
            //Iniciamos conexión
            ObservableList<Torneo> listaTorneos = FXCollections.observableArrayList();
            String insertSql = "CALL obtenerTorneos()";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Torneo t = new Torneo();
                t.setId(Integer.parseInt(rs.getString("id")));
                t.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                t.setNombre(rs.getString("nombre"));
                t.setDeporte(rs.getString("deporte"));
                t.setFehcaInicio(rs.getString("fecha_inicio"));
                listaTorneos.add(t);
            }

            return listaTorneos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
    
    /**Retorna un objeto Torneo con la informacion necesara de este
     * para mostrarlo en su perfil
     *
     * @author Jose Ramon
     * @version 0.1
     * @return "Torneo"
     */
    public Torneo getTorneo() {
        
        try {
            //Iniciamos conexión
            String insertSql = "SELECT t.descripcion,t.fecha_inscripcion,t.fecha_inicio,t.nombre,d.nombre AS \"deporte\" FROM torneos t, deportes d, trata tr WHERE tr.id_torneo=t.id AND t.id=? and tr.id_deporte=d.id";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            
            stmt.setInt(1, UsuarioLog.getAlmacenId());
            ResultSet rs = stmt.executeQuery();
            Torneo t = new Torneo();
            while (rs.next()) {
                
                t.setDescripcion(rs.getString("descripcion"));
                t.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                t.setNombre(rs.getString("nombre"));
                t.setDeporte(rs.getString("deporte"));
                t.setFehcaInicio(rs.getString("fecha_inicio"));
            }

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }
    
    /**Retorna una lista de TODOS los equipos que participan en X torneo
     * (es necesario que en UsuarioLog.almacenId se encuentre la id del torneo)
     *
     * @author Jose Ramon
     * @version 0.1
     * @return "ObservableList<Equipo>"
     */
    public ObservableList<Equipo> getEquipos() {

        try {
            //Iniciamos conexión
            ObservableList<Equipo> equipos = FXCollections.observableArrayList();
            String insertSql = "SELECT e.nombre,u.nickname,e.descripcion FROM equipos e,torneos t,compite c,participa p,usuarios u WHERE u.id=p.id_usuario and p.id_equipo=e.id and c.id_equipos=e.id and c.id_torneo=t.id and e.admin=u.id AND t.id=?";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, UsuarioLog.getAlmacenId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Equipo e = new Equipo();
                e.setNombre(rs.getString("nombre"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setNameAdmin(rs.getString("nickname"));
                equipos.add(e);
            }

            return equipos;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   }

}
