/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Torneo;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private TableView<Torneo> tabla;
    @FXML
    private TableColumn nombreTorneo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn fechaInscripccion;
    @FXML
    private TableColumn fechaInicio;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
