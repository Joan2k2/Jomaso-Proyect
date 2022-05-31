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
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 1erDAM
 */
public class FXMLControllerLogin implements Initializable {

    @FXML
    private ImageView imagenfondo;
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
    private void loginUsr(ActionEvent event) {
    }

    @FXML
    private void loginPassw(ActionEvent event) {
        
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
        try {

                     FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXMLHome.fxml"));

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
    
}
