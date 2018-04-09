/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author khaoula
 */



import edu.AllForKids.entities.User;
import edu.AllForKids.services.CrudUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfmail;

    @FXML
    private Button btnconnexion;
    @FXML
    private Button btnsignup;
    @FXML
    private AnchorPane Pane;
    @FXML
    private Text BtnForgetPassword;
    @FXML
    private PasswordField tfpass;
    public static User CurrentUser;

    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Initializes the controller class.
     */
    File imgfile;
    int file = 0;
    Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnconnexion(ActionEvent event) throws SQLException, IOException {

        tfmail.setStyle(" -fx-border-color : white ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white");
        tfpass.setStyle(" -fx-border-color : white ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white");

        if (tfmail.getText().equals("") || tfpass.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez inserer votre email et votre mot de pass");
            a.showAndWait();

            if (tfmail.getText().equals("")) {
                tfmail.setStyle("-fx-border-color : red ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white ");
            }
            if (tfpass.getText().equals("")) {
                tfpass.setStyle("-fx-border-color : red ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white ");
            }
        } else {
            String email = tfmail.getText();
            String pass = tfpass.getText();
            CrudUser crudutilisateur = new CrudUser();
            User u = crudutilisateur.Authentification(email, pass);
            if (u == null) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Email ou mot de passe incorrect");
                a.showAndWait();
            } else if (u.getEnabled() != 1) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setContentText("Compte n'est pas confirmé ou bien deactivé par l'admin");
                b.showAndWait();
            } else {
                CurrentUser = u;
                if (u.getRoles().equals("admin")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilBackEnd.fxml"));
                   // loader.setController(new AccueilBackEndController(primaryStage));

                    AnchorPane root = loader.load();
                    AccueilBackEndController dashboard = loader.getController();

                    dashboard.setLabelUserName(u.getUsername(), u.getId());
                    Scene scene = new Scene(root);
                    primaryStage.setTitle("Accueil");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.setMaximized(true);

                } else if (u.getRoles().equals("parent")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilFrontEnd.fxml"));
                   // loader.setController(new AcceuilFrontEndController(primaryStage));

                    BorderPane root = loader.load();
                    AcceuilFrontEndController frontaceuil = loader.getController();

                    frontaceuil.setLabelUserName(u.getUsername(), u.getId());
                    Scene scene = new Scene(root);
                    primaryStage.setTitle("Accueil");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    primaryStage.setMaximized(true);

                }
            }
        }

    }

    @FXML
    private void Register(ActionEvent event) throws IOException {

        /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("Registrer.fxml")) ; 
       loader.setController(new RegistrerController(primaryStage));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Register");
        primaryStage.setScene(scene);
        primaryStage.show();*/
        //Stage primaryStage= new Stage();
        //Node source =(Node) event.getSource();
        // Stage primarysStage= (Stage)source.getScene().getWindow();
        /*Parent root = FXMLLoader.load(getClass().getResource("Registrer.fxml"));
        Scene scene = new Scene(root);
        Stage primarysStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.show();*/
        FXMLLoader loader = new FXMLLoader(getClass().getResource("R.fxml"));
        Stage primarystage = null;
       // loader.setController(new RController(primarystage));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primarystage.setTitle("Registrer");
        primarystage.setScene(scene);
        primarystage.show();

    }

}
