/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class FXMLEquiposController implements Initializable {

    @FXML
    private TableView<?> tablaEquipos;
    @FXML
    private TableColumn<?, ?> nombreEquipo;
    @FXML
    private TableColumn<?, ?> nombreDeporte;
    @FXML
    private TableColumn<?, ?> nicnameUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
