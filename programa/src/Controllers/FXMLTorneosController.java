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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

   @FXML
    private TableView<Torneo> tablatorneos;
    private TableColumn fechainscripciontorneos;
    private TableColumn nombretorneos;
    private TableColumn deportetorneos;
    private TableColumn fechainiciotorneos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> listaTorneos = tm.getTorneos();
        
        fechainscripciontorneos.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        nombretorneos.setCellValueFactory(new PropertyValueFactory("nombre"));
        deportetorneos.setCellValueFactory(new PropertyValueFactory("deporte"));
        fechainiciotorneos.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        tablatorneos.setItems(listaTorneos);

    }
    }    
    

