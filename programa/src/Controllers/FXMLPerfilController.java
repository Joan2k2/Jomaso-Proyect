/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
}