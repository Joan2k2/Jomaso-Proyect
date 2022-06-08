/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import com.mysql.cj.MysqlType;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Equipo;
import model.Torneo;
import model.TorneoModel;
import model.UsuarioLog;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLTorneosController implements Initializable {

   @FXML
    private TableView<Torneo> tablatorneos;
    @FXML
    private TableColumn fechaInscripccion;
    @FXML
    private TableColumn nombreTorneo;
    @FXML
    private TableColumn nombreDeporte;
    @FXML
    private TableColumn fechaInicio;
    @FXML
    private TableColumn idTorneo;
    private Button botonLlevaTorneo;
    @FXML
    private TextField filtro;
    
    private ObservableList<Torneo> filtroTorneo;
    private  ObservableList<Torneo> listaTorneos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    
        TorneoModel tm = new TorneoModel();

        listaTorneos = tm.listarTorneos();
        this.idTorneo.setCellValueFactory(new PropertyValueFactory("id"));
        this.fechaInscripccion.setCellValueFactory(new PropertyValueFactory("fechaInscripcion"));
        this.nombreTorneo.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.nombreDeporte.setCellValueFactory(new PropertyValueFactory("deporte"));
        this.fechaInicio.setCellValueFactory(new PropertyValueFactory("fehcaInicio"));
        this.tablatorneos.setItems(listaTorneos);
        
        this.filtroTorneo = FXCollections.observableArrayList();

    }

    private void llevaTorneoVista(ActionEvent event) {
        Torneo t = tablatorneos.getSelectionModel().getSelectedItem();
        UsuarioLog.setAlmacenId(t.getId());
        
        
        System.out.println(t.getId() + t.getDescripcion() + t.getNombre());
        
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLTorneoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonLlevaTorneo.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void torneoTablViewMouseClicked(MouseEvent event) {
        Torneo t = tablatorneos.getSelectionModel().getSelectedItem();
        
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Torneo torneoSeleccionado = this.tablatorneos.getSelectionModel().getSelectedItem();
            UsuarioLog.setAlmacenId(torneoSeleccionado.getId());
            try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLTorneoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.tablatorneos.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }

    @FXML
    private void filtroNombre(KeyEvent event) {
        String Nfiltro=this.filtro.getText();
        
        if(Nfiltro.isEmpty()){
            this.tablatorneos.setItems(this.listaTorneos); 
        }else{
            this.filtroTorneo.clear();  
            
            for(Torneo t:this.listaTorneos){
                if(t.getNombre().toLowerCase().contains(Nfiltro.toLowerCase())){
                    this.filtroTorneo.add(t);
                }
            } 
            this.tablatorneos.setItems(this.filtroTorneo);
        }
    }

}    