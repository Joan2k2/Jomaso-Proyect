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
    public boolean borrarTorneo(Torneo t, Usuario u) {
        boolean retorno = false;

        try {
            //Iniciamos conexión
            String insertSql = "CALL borraTorneo(?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, u.getId());
            stmt.setInt(2, t.getId());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
        return retorno;
    }

    /**
     * Inscribe
     *
     * @param t
     * @param eq
     */
    public void inscribEquipo(Torneo t, Equipo eq) {
        try {
            //Iniciamos conexión
            String insertSql = "SELECT `inscribEquipo`(?, ?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, eq.getId());
            stmt.setInt(2, t.getId());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    public void desInscribEquipo(Torneo t, Equipo eq) {
        try {
            //Iniciamos conexión
            String insertSql = "CALL desInscribEquipo(?,?)";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            stmt.setInt(1, eq.getId());
            stmt.setInt(2, t.getId());

            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Cerramos conexión
            this.cerrarConexion();
        }
    }

    public ObservableList<Torneo> listarTorneosHome() {

        try {
            //Iniciamos conexión
            ObservableList<Torneo> almatorneo =FXCollections.observableArrayList();
            String insertSql = "call obtenerTorneosHome()";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Torneo t = new Torneo();
                
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
    
    public ObservableList<Torneo> getTorneos() {

        try {
            //Iniciamos conexión
            ObservableList<Torneo> listaTorneos = FXCollections.observableArrayList();
            String insertSql = "CALL obtenerTorneos()";

            PreparedStatement stmt = this.getConexion().prepareStatement(insertSql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Torneo t = new Torneo();
                t.setFechaInscripcion(rs.getString("fecha_inscripcion"));
                t.setNombre("nombre");
                t.setDeporte("deporte");
                t.setFehcaInicio(rs.getString("fecha_inicio"));
                listaTorneos.add(t);
            }

            return listaTorneos;

        } catch (SQLException e) {
            e.printStackTrace();
        return null;
    }
   }

}
