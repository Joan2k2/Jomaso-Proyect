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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Usuario;
import model.UsuarioModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLRegistrarseController implements Initializable {

    @FXML
    private ImageView imagenfondo;
    @FXML
    private AnchorPane anchorpanel2;
    @FXML
    private TextField NicknameUser;
    @FXML
    private TextField PasswUser;
    @FXML
    private Hyperlink hypervinculoIniciarSesion;
    @FXML
    private Button botonRegistrarte;
    @FXML
    private TextField NombreUser;
    @FXML
    private TextField ApellidoUser;
    @FXML
    private TextField CorreoUser;
    @FXML
    private TextField EdadUser;
    @FXML
    private TextField PasswUserConfirma;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginUsr(ActionEvent event) {
    }

    @FXML
    private void loginPassw(ActionEvent event) {
    }

    @FXML
    private void llevaaLogin(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLLogin.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.hypervinculoIniciarSesion.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrarte(ActionEvent event) {
        boolean comprobar;
        if (NombreUser.getText().isEmpty() || PasswUser.getText().isEmpty() || CorreoUser.getText().isEmpty() || EdadUser.getText().isEmpty() || NicknameUser.getText().isEmpty()) {

            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Error");
            al.setContentText("Solo puedes dejar vacio los apellidos");
            al.showAndWait();
        } else {

            
            Usuario u = new Usuario();
            UsuarioModel um = new UsuarioModel();
            

            if (PasswUser.getText().equals(PasswUserConfirma.getText())) {
                
                u.setNombre(NombreUser.getText());
                u.setApellidos(ApellidoUser.getText());
                u.setCorreo(CorreoUser.getText());
                u.setEdad(Integer.parseInt(EdadUser.getText()));
                u.setNickName(NicknameUser.getText());
                u.setContrasenya(PasswUser.getText());

                comprobar=um.crearUsuario(u);
                if(comprobar==false){
                    Alert aler = new Alert(Alert.AlertType.ERROR);
                    aler.setContentText("Error, ya existe ese usuario");
                    aler.setHeaderText("Error");
                    aler.showAndWait();
                }else{
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setContentText("Usuario creado con exito");
                ale.setHeaderText("credenciales");
                ale.showAndWait();
                }

                

            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Las contraseñas no coinciden");
                a.setHeaderText("Error de contraseña");
                a.showAndWait();
            }

        }

    }

}
