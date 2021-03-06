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
import model.UsuarioLog;
import model.UsuarioModel;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLControllerLogin implements Initializable {

    @FXML
    private AnchorPane anchorpanel2;
    @FXML
    private TextField Nicknameuser;
    @FXML
    private TextField PasswUser;
    @FXML
    private Hyperlink hypervinculoregistrarse;
    @FXML
    private Button botonLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void llevaaregistrarse(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLRegistrarse.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.botonLogin.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logearte(ActionEvent event) {
        UsuarioModel um = new UsuarioModel();
        
        Usuario u = new Usuario();
        
        u.setNickName(Nicknameuser.getText());
        u.setContrasenya(PasswUser.getText());

        if (um.usrLog(u) == true) {
            
            if(UsuarioLog.getAdmin()==false){
                try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLMenu.fxml"));

                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                Stage myStage = (Stage) this.botonLogin.getScene().getWindow();
                myStage.close();

            } catch (IOException ex) {
                Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
                try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLAdmin.fxml"));

                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                Stage myStage = (Stage) this.botonLogin.getScene().getWindow();
                myStage.close();

            } catch (IOException ex) {
                Logger.getLogger(FXMLRegistrarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            

        } else {
            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("El usuario o la contrase??a es incorrecto");
            ale.showAndWait();
        }

    }
    
    

}
