/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class FXMLTorneosController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Torneo t1 = new Torneo("Futbol", "Torneo Futbol 7", "02-06-2022", "15-06-2022");
        Torneo t2 = new Torneo("Basket", "Torneo Basket 3x3", "03-06-2022", "16-06-2022");
        Torneo t3 = new Torneo("Hockey", "Torneo Hockey Hierba", "04-06-2022", "17-06-2022");
        Torneo t4 = new Torneo("Tenis", "Torneo Tenis", "05-06-2022", "18-06-2022");
        
        ObservableList<Torneo> listaTorneos = FXCollections.observableArrayList();   
     
        listaTorneos.add(t1);
        listaTorneos.add(t2);
        listaTorneos.add(t3);
        listaTorneos.add(t4);
        
        TorneoModel t = new TorneoModel();
        
        
        this.fechainscripciontorneos.setCellValueFactory(new PropertyValueFactory("Fecha Inscripcion"));
        this.nombretorneos.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.deportetorneos.setCellValueFactory(new PropertyValueFactory("Deporte"));
        this.fechainiciotorneos.setCellValueFactory(new PropertyValueFactory("Fecha Inicio"));
    }    

    
}
