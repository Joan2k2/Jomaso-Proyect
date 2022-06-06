/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
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
import model.UsuarioModel;

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

        TorneoModel tm = new TorneoModel();
        ObservableList<Equipo> listaEquipos = tm.getEquipos();
        Torneo t = tm.getTorneo();
        this.nombreEquipoTabla.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.liderEquipoTabla.setCellValueFactory(new PropertyValueFactory("nameAdmin"));
        this.descripcionEquipoTabla.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.tablaEquipos.setItems(listaEquipos);

        textoDescripccion.setText(t.getDescripcion());
        nombreTorneo.setText(t.getNombre());
        fechaInicioDato.setText(t.getFehcaInicio());
        fechaInscripccionDato.setText(t.getFechaInscripcion());
        deporteDato.setText(t.getDeporte());

    }

    @FXML

    private void unirEquipo(ActionEvent event) {
        boolean resultado = false;
        LocalDate date_of_today = LocalDate.now();
        Usuario u = new Usuario();
        TorneoModel tm = new TorneoModel();
        u.setNickName(nombreUsuarioInsertar.getText());
        u.setContrasenya(contraseñaUsuarioInsertar.getText());
//comprobar que la fecha de inscripccion es mayor o igual a la fecha actual
//comprobar que el nombre de usuario y contraseña de usuario son los mismos que en usuarioLog

        if (u.getNickName().equals(UsuarioLog.getNickName())  && u.getContrasenya().equals(UsuarioLog.getContrasenya())) {

                resultado = tm.inscribEquipo(nombreEquipoInsertar.getText());
            if (resultado==true) {

                
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Te has inscrito correctamente");
                a.setHeaderText("Todo Ok!!");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(UsuarioLog.getNickName());
                a.setHeaderText("Error de Inscribirse");
                a.showAndWait();
            }

        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText(UsuarioLog.getNickName());
            a.setHeaderText(UsuarioLog.getContrasenya());
            a.showAndWait();
        }

    }

    @FXML
    private void quitarEquipo(ActionEvent event) {
        boolean resultado=false;
        Usuario u = new Usuario();
        u.setNickName(nombreUsuarioInsertar.getText());
        u.setContrasenya(contraseñaUsuarioInsertar.getText());
        TorneoModel tm = new TorneoModel();
        
        
        if (u.getNickName().equals(UsuarioLog.getNickName())  && u.getContrasenya().equals(UsuarioLog.getContrasenya())) {
            resultado=tm.desInscribEquipo(nombreEquipoInsertar.getText());
            if (resultado==true) {

                
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Te has eliminado correctamente");
                a.setHeaderText("Todo Ok!!");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("No funciona");
                System.out.println(resultado);
                a.setHeaderText("Error de eliminarse");
                a.showAndWait();
            }
            
            
        }else{
         Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("El usuario o contraseña no coinciden");
            a.setHeaderText("Error de autenticacion");
            a.showAndWait();}
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
