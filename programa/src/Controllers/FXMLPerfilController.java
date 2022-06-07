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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Equipo;
import model.EquipoModel;
import model.Torneo;
import model.TorneoModel;
import model.UsuarioLog;
import model.UsuarioModel;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class FXMLPerfilController implements Initializable {

    @FXML
    private ImageView fotoperfil;
    @FXML
    private TableView<Equipo> tablaperfil;
    @FXML
    private TextField descripcionperfil;
    @FXML
    private TableColumn nombreperfil;
    @FXML
    private TableColumn deporteperfil;
    @FXML
    private TextField nicknameperfil;
    @FXML
    private TextField edadperfil;
    @FXML
    private TextField apellidosperfil;
    @FXML
    private TextField correoperfil;
    @FXML
    private TextField nombreperfilText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        UsuarioModel um = new UsuarioModel();

        ObservableList<Equipo> listarEquiposPerfil = um.getEquipo();  

        this.nombreperfil.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.deporteperfil.setCellValueFactory(new PropertyValueFactory("nameAdmin"));
        this.tablaperfil.setItems(listarEquiposPerfil);
        
        this.nicknameperfil.setText(UsuarioLog.getNickName());
        this.edadperfil.setText(Integer.toString(UsuarioLog.getEdad()));
        this.nombreperfilText.setText(UsuarioLog.getNombre());
        this.apellidosperfil.setText(UsuarioLog.getApellidos());
        this.descripcionperfil.setText(UsuarioLog.getDescripcion());
        this.correoperfil.setText(UsuarioLog.getCorreo());
        
    }

    @FXML
    private void equiposTablViewMouseClickeddesdeperfil(MouseEvent event) {
          Equipo e = tablaperfil.getSelectionModel().getSelectedItem();
        
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
            Equipo equipoSeleccionado = this.tablaperfil.getSelectionModel().getSelectedItem();
            UsuarioLog.setAlmacenId(equipoSeleccionado.getId());
            try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLEquipoVista.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.tablaperfil.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    }
}