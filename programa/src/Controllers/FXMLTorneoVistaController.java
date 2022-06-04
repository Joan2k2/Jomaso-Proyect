/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Equipo;
import model.Torneo;
import model.TorneoModel;
import model.Usuario;
import model.UsuarioLog;

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
    @FXML
    private Button botonVolverTorneos;
    @FXML
    private TextField fechaInicioDato;
    @FXML
    private TextField fechaInscripccionDato;
    @FXML
    private TextField deporteDato;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TorneoModel tm=new TorneoModel();
        ObservableList<Equipo> listaEquipos = tm.getEquipos();
        Torneo t =tm.getTorneo();
//        this.nombreEquipoTabla.setCellFactory(new PropertyValueFactory("nombre"));
//        this.liderEquipoTabla.setCellFactory(new PropertyValueFactory("nameAdmin"));
//        this.descripcionEquipoTabla.setCellFactory(new PropertyValueFactory("descripcion"));
//        this.tablaEquipos.setItems(listaEquipos);
        
        textoDescripccion.setText(t.getDescripcion());
        nombreTorneo.setText(t.getNombre());
        fechaInicioDato.setText(t.getFehcaInicio());
        fechaInscripccionDato.setText(t.getFechaInscripcion());
        deporteDato.setText(t.getDeporte());
       
    }    

    @FXML
    private void unirEquipo(ActionEvent event) {
//        Usuario u =new Usuario();
//        u.set
//        
//        boolean resultado=inscribEquipo;
//        
//        if(resultado==true){
//        
//        
//        
//        }
        
    }

    @FXML
    private void quitarEquipo(ActionEvent event) {
        
        
    }


    @FXML
    private void llevarHome(ActionEvent event) {
                try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLMenu.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonVolverTorneos.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
