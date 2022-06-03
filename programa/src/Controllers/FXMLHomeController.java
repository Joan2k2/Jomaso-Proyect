/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Torneo;
import model.TorneoModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private TableColumn nombreTorneo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn fechaInscripccion;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableView<Torneo> tablaHome;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> listarTorneosHome = tm.listarTorneosHome();  

        this.fechaInscripccion.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        this.nombreTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.nombreDeporte.setCellValueFactory(new PropertyValueFactory("deporte"));
        this.fechaInicio.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        this.tablaHome.setItems(listarTorneosHome);
    }    
    
}
