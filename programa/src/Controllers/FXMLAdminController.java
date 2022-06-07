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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.EquipoModel;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
