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
 * @author Joan_2k2
 */
public class FXMLCrearEquipoController implements Initializable {

    @FXML
    private ChoiceBox<String> laBox;
    @FXML
    private Button botonCrearEquipo;
    @FXML
    private TextArea descripccionEquipo;
    @FXML
    private TextField textoNombreEquipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           String Futbol="Futbol";
        String Tenis="Tenis";
        String Petanca="Petanca";
        ObservableList<String> lista =FXCollections.observableArrayList();
        lista.add(Futbol);
        lista.add(Petanca);
        lista.add(Tenis);
        laBox.setItems(lista);
    }    

    @FXML
    private void crearEquipo(ActionEvent event) {
        EquipoModel em= new EquipoModel();
        em.crearEquipo(textoNombreEquipo.getText(), descripccionEquipo.getText());
        Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText(laBox.getValue());
            ale.showAndWait();
        
        
        
        
    }
    
}