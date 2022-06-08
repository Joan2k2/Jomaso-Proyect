/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Equipo;
import model.EquipoModel;
import model.Torneo;
import model.TorneoModel;
import model.Usuario;
import model.UsuarioLog;
import model.UsuarioModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLEquipoVistaController implements Initializable {

    @FXML
    private TableView<Usuario> tablaJugadores;
    @FXML
    private TableColumn nicknameTablaJuga;
    @FXML
    private TableColumn nombreTablaJuga;
    @FXML
    private TableColumn correoTablaJuga;
    @FXML
    private TableView<Torneo> tablaTorneo;
    @FXML
    private TableColumn nombreTablaTorneo;
    @FXML
    private TableColumn fechaInicioTablaTorneos;
    @FXML
    private TableColumn FechaInscripTablaTorneo;
    @FXML
    private TableColumn deporteTablaTorneo;
    @FXML
    private Button botonUnirseEquipo;
    @FXML
    private Button botonSalirEquipo;
    @FXML
    private TextArea descripcionText;
    @FXML
    private Button botonVolverHome;
    @FXML
    private Text nombreEquipoTextp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EquipoModel em = new EquipoModel();
        nombreEquipoTextp.setText(em.getEquipo().getNombre());
        descripcionText.setText(em.getEquipo().getDescripcion());

        ObservableList<Torneo> listaEquipos = em.listarTorneo();

        this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.fechaInicioTablaTorneos.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        this.FechaInscripTablaTorneo.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        this.deporteTablaTorneo.setCellValueFactory(new PropertyValueFactory("deporte"));
        this.tablaTorneo.setItems(listaEquipos);

        ObservableList<Usuario> listausuario = em.getJugadores();
        this.nicknameTablaJuga.setCellValueFactory(new PropertyValueFactory("nickName"));
        this.nombreTablaJuga.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.correoTablaJuga.setCellValueFactory(new PropertyValueFactory("correo"));
        this.tablaJugadores.setItems(listausuario);
    }

    @FXML
    private void seUne(ActionEvent event) {
        EquipoModel em = new EquipoModel();
        boolean resultado = false;
        
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Seguro que quiere unirse al equipo?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
        resultado = em.addJugador();
        if (resultado == true) {

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Te has unido correctamente");
            a.setHeaderText("Todo Ok!!");
            a.showAndWait();
            ObservableList<Torneo> listaEquipos = em.listarTorneo();

            this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.fechaInicioTablaTorneos.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
            this.FechaInscripTablaTorneo.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
            this.deporteTablaTorneo.setCellValueFactory(new PropertyValueFactory("deporte"));
            this.tablaTorneo.setItems(listaEquipos);

            ObservableList<Usuario> listausuario = em.getJugadores();
            this.nicknameTablaJuga.setCellValueFactory(new PropertyValueFactory("nickName"));
            this.nombreTablaJuga.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.correoTablaJuga.setCellValueFactory(new PropertyValueFactory("correo"));
            this.tablaJugadores.setItems(listausuario);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("ha fallado");
            a.setHeaderText("Error de Inscribirse");
            a.showAndWait();
        }
            }
    }

    @FXML
    private void seSale(ActionEvent event) {
        EquipoModel em = new EquipoModel();
        boolean resultado = false;

         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setHeaderText(null);
         alert.setTitle("Confirmación");
         alert.setContentText("¿Seguro que quiere abandonar el equipo?");
         Optional<ButtonType> action = alert.showAndWait();

         if (action.get() == ButtonType.OK) {
        resultado = em.borrarJugador();
        if (resultado == true) {

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Te has salido correctamente");
            a.setHeaderText("Todo Ok!!");
            a.showAndWait();
            ObservableList<Torneo> listaEquipos = em.listarTorneo();

            this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.fechaInicioTablaTorneos.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
            this.FechaInscripTablaTorneo.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
            this.deporteTablaTorneo.setCellValueFactory(new PropertyValueFactory("deporte"));
            this.tablaTorneo.setItems(listaEquipos);

            ObservableList<Usuario> listausuario = em.getJugadores();
            this.nicknameTablaJuga.setCellValueFactory(new PropertyValueFactory("nickName"));
            this.nombreTablaJuga.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.correoTablaJuga.setCellValueFactory(new PropertyValueFactory("correo"));
            this.tablaJugadores.setItems(listausuario);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("ha fallado");
            a.setHeaderText("Error de eliminarse");
            a.showAndWait();
        }
         }

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

            Stage myStage = (Stage) this.botonVolverHome.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void torneoTablViewMouseClickedddesdeEquipo(MouseEvent event) {
        Torneo t = tablaTorneo.getSelectionModel().getSelectedItem();
        
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Torneo torneoSeleccionado = this.tablaTorneo.getSelectionModel().getSelectedItem();
            UsuarioLog.setAlmacenId(torneoSeleccionado.getId());
            try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLTorneoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.tablaTorneo.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }

}
