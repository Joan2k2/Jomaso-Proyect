/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Equipo;
import model.Torneo;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class FXMLTorneoVistaController implements Initializable {

    @FXML
    private TableView<Equipo> tablaEquipos;
    @FXML
    private TableColumn nombreEquipoTabla;
    @FXML
    private TableColumn liderEquipoTabla;
    @FXML
    private TableColumn descripcionEquipoTabla;
    @FXML
    private Text nombreTorneo;
    @FXML
    private TextField nombreEquipoInsertar;
    @FXML
    private TextField nombreUsuarioInsertar;
    @FXML
    private TextField contraseñaUsuarioInsertar;
    @FXML
    private TextArea textoDescripccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Torneo t = new Torneo();
        textoDescripccion.setText(t.getDescripcion());
        nombreTorneo.setText(t.getNombre());
    }    

    @FXML
    private void unirEquipo(ActionEvent event) {
    }

    @FXML
    private void quitarEquipo(ActionEvent event) {
    }
    
}
