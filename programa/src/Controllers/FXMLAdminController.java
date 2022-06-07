/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Deporte;
import model.DeporteModel;
import model.Equipo;
import model.EquipoModel;
import model.Torneo;
import model.TorneoModel;
import model.Usuario;
import model.UsuarioModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private Button crearTorneo;
    @FXML
    private Button borrarTorneo;
    @FXML
    private Button borrarUsuario;
    @FXML
    private TextField nombreAdminTorneo;
    @FXML
    private TextField descripcionAdminTorneo;
    @FXML
    private TextField fechaInsAdminTorneo;
    @FXML
    private TextField fechaIniAdminTorneo;
    @FXML
    private TextField idBorrarUsuario;
    @FXML
    private Button borrarEquipo;
    @FXML
    private TextField idBorrarEquipo;
    @FXML
    private TextField idBorrarDeporte;
    @FXML
    private Button borrarDeporte;
    @FXML
    private TextField nombreAdminDeporte;
    @FXML
    private Button crearDeporte;
    @FXML
    private TextArea descripcionAdminDeporte;
    @FXML
    private TextField idBorrarTorneo;
    @FXML
    private TableView<Torneo> tablaTorneoAdmin;
    @FXML
    private TableColumn idTablaTorneo;
    @FXML
    private TableColumn nombreTablaTorneo;
    @FXML
    private TableView<Deporte> tablaDeporteAdmin;
    @FXML
    private TableColumn idTablaDeporte;
    @FXML
    private TableColumn nombreTablaDeporte;
    @FXML
    private TableView<Equipo> tablaEquipoAdmin;
    @FXML
    private TableColumn idTablaEquipo;
    @FXML
    private TableColumn nombreTablaEquipo;
    @FXML
    private TableView<Usuario> tablaUsuarioAdmin;
    @FXML
    private TableColumn idTablaUsuario;
    @FXML
    private TableColumn nombreTablaUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> torneoAdmin = tm.listarTorneos();
        this.idTablaTorneo.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));           
        this.tablaTorneoAdmin.setItems(torneoAdmin);
        
        
        DeporteModel dm = new DeporteModel();

        ObservableList<Deporte> deporteAdmin = dm.listarDeporte();
        this.idTablaDeporte.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaDeporte.setCellValueFactory(new PropertyValueFactory("nombre"));           
        this.tablaDeporteAdmin.setItems(deporteAdmin);
        
        
        EquipoModel em = new EquipoModel();

        ObservableList<Equipo> equipoAdmin = em.listarEquipo();
        this.idTablaEquipo.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaEquipo.setCellValueFactory(new PropertyValueFactory("nombre"));           
        this.tablaEquipoAdmin.setItems(equipoAdmin);
        
        
        UsuarioModel um = new UsuarioModel();

        ObservableList<Usuario> usuarioAdmin = um.listarUsuario();
        this.idTablaUsuario.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaUsuario.setCellValueFactory(new PropertyValueFactory("nickname"));           
        this.tablaUsuarioAdmin.setItems(usuarioAdmin);
        
    }    
 
    
    @FXML
    private void crearTorneo(ActionEvent event) {
        
    }

    @FXML
    private void borrarTorneo(ActionEvent event) {
        
    }

    @FXML
    private void borrarUsuario(ActionEvent event) {
        
    }

           
    private void crearEquipo(ActionEvent event) {
        
    }
    
    @FXML
    private void borrarEquipo(ActionEvent event) {
        
    }

    @FXML
    private void borrarDeporte(ActionEvent event) {
    }

    @FXML
    private void crearDeporte(ActionEvent event) {
}
}
