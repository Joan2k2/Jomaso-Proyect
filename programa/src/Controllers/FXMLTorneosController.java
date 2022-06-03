/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mysql.cj.MysqlType;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Torneo;
import model.TorneoModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLTorneosController implements Initializable {

   @FXML
    private TableView<Torneo> tablatorneos;
   
    @FXML
    private TableColumn fechaInscripccion;
    @FXML
    private TableColumn nombreTorneo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableColumn idTorneo;
    @FXML
    private TextField idVerTorneo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> listaTorneos = tm.getTorneos();
        this.idTorneo.setCellValueFactory(new PropertyValueFactory("id"));
        this.fechaInscripccion.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        this.nombreTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.nombreDeporte.setCellValueFactory(new PropertyValueFactory("deporte"));
        this.fechaInicio.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        this.tablatorneos.setItems(listaTorneos);

    }

    @FXML
    private void llevaTorneoVista(ActionEvent event) {
        
        
        
    }
    }    
    

