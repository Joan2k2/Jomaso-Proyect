/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Deporte;
import model.DeporteModel;
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
public class FXMLAdminController implements Initializable {

    @FXML
    private Button crearTorneo;
    @FXML
    private Button borrarTorneo;
    @FXML
    private Button borrarUsuario;
    @FXML
    private TextField idBorrarUsuario;
    @FXML
    private Button borrarEquipo;
    @FXML
    private TextField idBorrarEquipo;
    @FXML
    private TextField idBorrarDeporte;
    @FXML
    private Button borrarDeporte;
    @FXML
    private TextField nombreAdminDeporte;
    @FXML
    private Button crearDeporte;
    @FXML
    private TextField idBorrarTorneo;
    @FXML
    private TableView<Torneo> tablaTorneoAdmin;
    @FXML
    private TableColumn idTablaTorneo;
    @FXML
    private TableColumn nombreTablaTorneo;
    @FXML
    private TableView<Deporte> tablaDeporteAdmin;
    @FXML
    private TableColumn idTablaDeporte;
    @FXML
    private TableColumn nombreTablaDeporte;
    @FXML
    private TableView<Equipo> tablaEquipoAdmin;
    @FXML
    private TableColumn idTablaEquipo;
    @FXML
    private TableColumn nombreTablaEquipo;
    @FXML
    private TableView<Usuario> tablaUsuarioAdmin;
    @FXML
    private TableColumn idTablaUsuario;
    @FXML
    private TableColumn nombreTablaUsuario;
    @FXML
    private TextField nameAdmin;
    @FXML
    private TextArea descripcionDeporte;
    @FXML
    private TextArea descripcionTorneo;
    @FXML
    private TextField nombreTorneo;
    @FXML
    private ChoiceBox<String> listDeporte;
    @FXML
    private DatePicker fechaInicioTorn;
    @FXML
    private DatePicker fechaInscripcionTorn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.nameAdmin.setText(UsuarioLog.getNickName());

        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> torneoAdmin = tm.listarTorneos();
        this.idTablaTorneo.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tablaTorneoAdmin.setItems(torneoAdmin);

        DeporteModel dm = new DeporteModel();

        ObservableList<Deporte> deporteAdmin = dm.listarDeporte();
        this.idTablaDeporte.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaDeporte.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tablaDeporteAdmin.setItems(deporteAdmin);

        EquipoModel em = new EquipoModel();

        ObservableList<Equipo> equipoAdmin = em.listarEquipo();
        this.idTablaEquipo.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaEquipo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tablaEquipoAdmin.setItems(equipoAdmin);

        UsuarioModel um = new UsuarioModel();

        ObservableList<Usuario> usuarioAdmin = um.listarUsuario();
        this.idTablaUsuario.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreTablaUsuario.setCellValueFactory(new PropertyValueFactory("nickName"));
        this.tablaUsuarioAdmin.setItems(usuarioAdmin);

        ObservableList<String> lista = dm.getDeportes();
        listDeporte.setItems(lista);

    }

    @FXML
    private void crearTorneo(ActionEvent event) {
        String s = listDeporte.getSelectionModel().getSelectedItem();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = new Date();
            String inicios = fechaInicioTorn.getValue().toString();
            String inscripccions = fechaInscripcionTorn.getValue().toString();
//            Date inicio = dateFormat.parse(inicios);
//            Date inscripcion = dateFormat.parse(inscripccions);

//            String formattedDateinicio = dateFormat.format(inicios);
            java.sql.Date fechainitorneo = java.sql.Date.valueOf(inicios);
            java.sql.Date fechainscritorneo = java.sql.Date.valueOf(inscripccions);

            if (this.nombreTorneo.getText().isEmpty() || this.fechaInicioTorn.getValue().toString().isEmpty() || this.fechaInscripcionTorn.getValue().toString().isEmpty() || s == null) {
                Alert ale = new Alert(Alert.AlertType.ERROR);
                ale.setHeaderText("Error");
                ale.setContentText("No puedes dejar ni el nombre, fecha inicio, fecha inscripcion o deporte del torneo vacio");
                ale.showAndWait();
            } else if (fechainscritorneo.before(fechainitorneo)) {
                TorneoModel tm = new TorneoModel();
                Torneo t = new Torneo();
                t.setDeporte(s);
                t.setDescripcion(descripcionTorneo.getText());
                t.setNombre(nombreTorneo.getText());
                t.setFehcaInicio(inicios);
                t.setFechaInscripcion(inscripccions);
                tm.crearTorneo(t);
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setHeaderText("Creado correctamente");
                ale.setContentText("Se ha creado correctamente el torneo");
                ale.showAndWait();

                tm = new TorneoModel();

                ObservableList<Torneo> torneoAdmin = tm.listarTorneos();
                this.idTablaTorneo.setCellValueFactory(new PropertyValueFactory("id"));
                this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.tablaTorneoAdmin.setItems(torneoAdmin);
            } else {
                Alert ale = new Alert(Alert.AlertType.ERROR);
                ale.setHeaderText("Error");
                ale.setContentText("La fecha de inscripcción no puede ser superior a la de inicio");
                ale.showAndWait();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void borrarTorneo(ActionEvent event) {
        if (this.idBorrarTorneo.getText().isEmpty()) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("Introduce la ID del Torneo");
            ale.showAndWait();
        } else {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Seguro que quiere borrar el torneo?");
            Optional<ButtonType> action = alert.showAndWait();
            
            if (action.get() == ButtonType.OK) {
                
                 TorneoModel tm = new TorneoModel();

                tm.borrarTorneo(Integer.parseInt(idBorrarTorneo.getText()));
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setHeaderText("Correcto");
                ale.setContentText("Todo ok");
                ale.showAndWait();

                tm = new TorneoModel();

                ObservableList<Torneo> torneoAdmin = tm.listarTorneos();
                this.idTablaTorneo.setCellValueFactory(new PropertyValueFactory("id"));
                this.nombreTablaTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.tablaTorneoAdmin.setItems(torneoAdmin);
            
            } 
            
           

         
        }

    }

    @FXML
    private void borrarUsuario(ActionEvent event) {
        if (this.idBorrarUsuario.getText().isEmpty()) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("Introduce la ID del Usuario");
            ale.showAndWait();
        } else {
            
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText(null);
                alert.setTitle("Confirmación");
                alert.setContentText("¿Seguro que quiere borrar el usuario?");
                Optional<ButtonType> action = alert.showAndWait();

                if (action.get() == ButtonType.OK) {
                    
                    UsuarioModel um = new UsuarioModel();

                    um.borraUsuario(Integer.parseInt(idBorrarUsuario.getText()));
                    Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                    ale.setHeaderText("Correcto");
                    ale.setContentText("Todo ok");
                    ale.showAndWait();

                    um = new UsuarioModel();

                    ObservableList<Usuario> usuarioAdmin = um.listarUsuario();
                    this.idTablaUsuario.setCellValueFactory(new PropertyValueFactory("id"));
                    this.nombreTablaUsuario.setCellValueFactory(new PropertyValueFactory("nickName"));
                    this.tablaUsuarioAdmin.setItems(usuarioAdmin);
            }
        }

    }

    @FXML
    private void borrarEquipo(ActionEvent event) {
        if (this.idBorrarEquipo.getText().isEmpty()) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("No puedes dejar la id vacia");
            ale.showAndWait();
        } else {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Seguro que quiere borrar el usuario?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                EquipoModel em = new EquipoModel();

                em.borraEquipoAdmin(Integer.parseInt(idBorrarEquipo.getText()));
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setHeaderText("Correcto");
                ale.setContentText("Todo ok");
                ale.showAndWait();

                em = new EquipoModel();

                ObservableList<Equipo> equipoAdmin = em.listarEquipo();
                this.idTablaEquipo.setCellValueFactory(new PropertyValueFactory("id"));
                this.nombreTablaEquipo.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.tablaEquipoAdmin.setItems(equipoAdmin);
            }
//            
        }
    }

    @FXML
    private void borrarDeporte(ActionEvent event) {

        if (this.idBorrarDeporte.getText().isEmpty()) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("No puedes dejar la id vacia");
            ale.showAndWait();
        } else {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Confirmación");
            alert.setContentText("¿Seguro que quiere borrar el usuario?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                DeporteModel dm = new DeporteModel();

                dm.borraDeporte(Integer.parseInt(idBorrarDeporte.getText()));
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setHeaderText("Correcto");
                ale.setContentText("Todo ok");
                ale.showAndWait();

                dm = new DeporteModel();

                ObservableList<Deporte> deporteAdmin = dm.listarDeporte();
                this.idTablaDeporte.setCellValueFactory(new PropertyValueFactory("id"));
                this.nombreTablaDeporte.setCellValueFactory(new PropertyValueFactory("nombre"));
                this.tablaDeporteAdmin.setItems(deporteAdmin);
            }
        }
    }

    @FXML
    private void crearDeporte(ActionEvent event) {

        if (this.nombreAdminDeporte.getText().isEmpty() || this.descripcionDeporte.getText().isEmpty()) {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("No puedes dejar ni el nombre ni la descripcción vacia");
            ale.showAndWait();

        } else {
            DeporteModel dm = new DeporteModel();
            Deporte d = new Deporte();
            d.setNombre(nombreAdminDeporte.getText());
            d.setDescripcion(descripcionDeporte.getText());
            dm.crearDeporte(d);

            dm = new DeporteModel();

            ObservableList<Deporte> deporteAdmin = dm.listarDeporte();
            this.idTablaDeporte.setCellValueFactory(new PropertyValueFactory("id"));
            this.nombreTablaDeporte.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.tablaDeporteAdmin.setItems(deporteAdmin);
            Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
            ale.setHeaderText("Correcto");
            ale.setContentText("Todo ok");
            ale.showAndWait();

        }

    }
}
