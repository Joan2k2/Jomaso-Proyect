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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Equipo;
import model.EquipoModel;
import model.Torneo;
import model.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class FXMLEquiposController implements Initializable {

    @FXML
    private TableView<Equipo> tablaEquipos;
    @FXML
    private TableColumn nombreEquipo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn nicnameUser;
    @FXML
    private Button botonunirseEquipo;
    @FXML
    private TableColumn idEquipos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    EquipoModel em = new EquipoModel();

        ObservableList<Equipo> listaequipos = em.listarEquipo();
        this.idEquipos.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombreEquipo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.nombreDeporte.setCellValueFactory(new PropertyValueFactory("descripcion"));   
        this.nicnameUser.setCellValueFactory(new PropertyValueFactory("nameAdmin"));              
        this.tablaEquipos.setItems(listaequipos);
    }    

    @FXML
    private void llevaEquipoVista(ActionEvent event) {
        Equipo e = tablaEquipos.getSelectionModel().getSelectedItem();
        UsuarioLog.setAlmacenId(e.getId());
        
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLEquipoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonunirseEquipo.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void equiposTablViewMouseClicked(MouseEvent event) {
        Equipo e = tablaEquipos.getSelectionModel().getSelectedItem();
        
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Equipo equipoSeleccionado = this.tablaEquipos.getSelectionModel().getSelectedItem();
            UsuarioLog.setAlmacenId(equipoSeleccionado.getId());
            try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLEquipoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.tablaEquipos.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }
    
}
