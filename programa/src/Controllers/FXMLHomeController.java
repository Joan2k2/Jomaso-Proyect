/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Torneo;
import model.TorneoModel;
import model.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private TableColumn nombreTorneo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn fechaInscripccion;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableView<Torneo> tablaHome;
    @FXML
    private Hyperlink noticia1;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TorneoModel tm = new TorneoModel();

        ObservableList<Torneo> listarTorneosHome = tm.listarTorneosHome();  

        this.fechaInscripccion.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        this.nombreTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.nombreDeporte.setCellValueFactory(new PropertyValueFactory("deporte"));
        this.fechaInicio.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        this.tablaHome.setItems(listarTorneosHome);
    }    
    @FXML
    private void vermas1(ActionEvent event) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI("https://jomaso.ddns.net/noticias.html"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 

    @FXML
    private void torneoTablViewMouseClicked(MouseEvent event) {
        Torneo t = tablaHome.getSelectionModel().getSelectedItem();
        
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Torneo torneoSeleccionado = this.tablaHome.getSelectionModel().getSelectedItem();
            UsuarioLog.setAlmacenId(torneoSeleccionado.getId());
            try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLTorneoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.tablaHome.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }
}

